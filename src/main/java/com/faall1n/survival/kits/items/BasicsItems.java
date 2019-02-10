package com.faall1n.survival.kits.items;

import java.util.ArrayList;
import java.util.List;

import com.faall1n.survival.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class BasicsItems {

	public static List<ItemStack> pvp() {
		List<ItemStack> items = new ArrayList<ItemStack>();

		items.add(new ItemBuilder(Material.IRON_HELMET).unsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).build());
		items.add(new ItemBuilder(Material.IRON_CHESTPLATE).unsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).build());
		items.add(new ItemBuilder(Material.IRON_LEGGINGS).unsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).build());
		items.add(new ItemBuilder(Material.IRON_BOOTS).unsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).build());
		items.add(new ItemBuilder(Material.IRON_SWORD).unsafeEnchantment(Enchantment.DAMAGE_ALL, 1).build());
		items.add(new ItemBuilder(Material.BOW).unsafeEnchantment(Enchantment.ARROW_DAMAGE, 1).build());
		items.add(new ItemBuilder(Material.ARROW).amount(16).build());
		items.add(new ItemBuilder(Material.GOLDEN_APPLE).amount(8).build());

		return items;
	}
	
	public static List<ItemStack> minerador() {
		List<ItemStack> items = new ArrayList<ItemStack>();

		items.add(new ItemBuilder(Material.IRON_PICKAXE).build());

		return items;
	}

	public static List<ItemStack> semanal() {
		List<ItemStack> items = new ArrayList<ItemStack>();

		items.add(
				new ItemBuilder(Material.CHEST).name("§eCaixa Misteriosa").lore("§7Tipo: §fBásica").amount(1).build());

		return items;
	}

}
