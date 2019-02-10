package com.faall1n.survival.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import net.md_5.bungee.api.ChatColor;

public class ItemBuilder {

	private ItemStack is;

	public ItemBuilder(Material m) {
		this(m, 1, (short) 0);
	}

	public ItemBuilder(int id) {
		this(id, 1, (short) 0);
	}

	public ItemBuilder(ItemStack is) {
		this.is = is.clone();
	}

	public ItemBuilder(Material m, int amount, short data) {
		this.is = new ItemStack(m, amount, data);
	}

	@SuppressWarnings("deprecation")
	public ItemBuilder(int id, int amount, short data) {
		this.is = new ItemStack(id, amount, data);
	}

	public ItemBuilder clone() {
		return new ItemBuilder(this.is);
	}

	public ItemBuilder durability(int dur) {
		this.is.setDurability((short) dur);
		return this;
	}

	public ItemBuilder name(String name) {
		ItemMeta im = this.is.getItemMeta();
		im.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
		this.is.setItemMeta(im);
		return this;
	}

	public ItemBuilder unsafeEnchantment(Enchantment ench, int level) {
		this.is.addUnsafeEnchantment(ench, level);
		return this;
	}

	public ItemBuilder enchant(Enchantment ench, int level) {
		ItemMeta im = this.is.getItemMeta();
		im.addEnchant(ench, level, true);
		this.is.setItemMeta(im);
		return this;
	}

	public ItemBuilder removeEnchantment(Enchantment ench) {
		this.is.removeEnchantment(ench);
		return this;
	}

	public ItemBuilder owner(String owner) {
		try {
			SkullMeta im = (SkullMeta) this.is.getItemMeta();
			im.setOwner(owner);
			this.is.setItemMeta((ItemMeta) im);
		} catch (ClassCastException ex) {
		}
		return this;
	}

	public ItemBuilder infinityDurabilty() {
		this.is.setDurability((short) 32767);
		return this;
	}

	public ItemBuilder lore(String... lore) {
		ItemMeta im = this.is.getItemMeta();
		List<String> out = (im.getLore() == null) ? new ArrayList<String>() : im.getLore();
		for (String string : lore) {
			out.add(ChatColor.translateAlternateColorCodes('&', string));
		}
		im.setLore((List<String>) out);
		this.is.setItemMeta(im);
		return this;
	}

	public ItemBuilder listlore(List<String> lore) {
		ItemMeta im = this.is.getItemMeta();
		im.setLore((List<String>) lore);
		this.is.setItemMeta(im);
		return this;
	}

	@SuppressWarnings("deprecation")
	public ItemBuilder woolColor(DyeColor color) {
		if (!this.is.getType().equals((Object) Material.WOOL)) {
			return this;
		}
		this.is.setDurability((short) color.getDyeData());
		return this;
	}

	public ItemBuilder amount(int amount) {
		if (amount > 64) {
			amount = 64;
		}
		this.is.setAmount(amount);
		return this;
	}

	public ItemBuilder removeAttributes() {
		ItemMeta meta = this.is.getItemMeta();
		meta.addItemFlags(ItemFlag.values());
		this.is.setItemMeta(meta);
		return this;
	}

	public ItemStack build() {
		return this.is;
	}

	public ItemBuilder color(Color color) {
		if (!this.is.getType().name().contains("LEATHER_")) {
			return this;
		}
		LeatherArmorMeta meta = (LeatherArmorMeta) this.is.getItemMeta();
		meta.setColor(color);
		this.is.setItemMeta((ItemMeta) meta);
		return this;
	}

	public ItemBuilder head(String texture) {
		return this;
	}

	public static boolean RefSet(Class<?> sourceClass, Object instance, String fieldName,
			Object value) {
		try {
			Field field = sourceClass.getDeclaredField(fieldName);
			Field modifiersField = Field.class.getDeclaredField("modifiers");
			int modifiers = modifiersField.getModifiers();
			if (!field.isAccessible()) {
				field.setAccessible(true);
			}
			if ((modifiers & 0x10) == 0x10) {
				modifiersField.setAccessible(true);
				modifiersField.setInt(field, modifiers & 0xFFFFFFEF);
			}
			try {
				field.set(instance, value);
			} finally {
				if ((modifiers & 0x10) == 0x10) {
					modifiersField.setInt(field, modifiers | 0x10);
				}
				if (!field.isAccessible()) {
					field.setAccessible(false);
				}
			}
			if ((modifiers & 0x10) == 0x10) {
				modifiersField.setInt(field, modifiers | 0x10);
			}
			if (!field.isAccessible()) {
				field.setAccessible(false);
			}
			return true;
		} catch (Exception var11) {
			Bukkit.getLogger().log(Level.WARNING, "Unable to inject Gameprofile", var11);
			return false;
		}
	}
}
