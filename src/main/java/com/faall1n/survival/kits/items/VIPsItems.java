package com.faall1n.survival.kits.items;

import java.util.ArrayList;
import java.util.List;

import com.faall1n.survival.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class VIPsItems {

	public static List<ItemStack> ultradiario() {
		List<ItemStack> items = new ArrayList<ItemStack>();

		items.add(new ItemBuilder(Material.DIAMOND_HELMET).unsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).lore("�aItem ULTRA").build());
		items.add(new ItemBuilder(Material.DIAMOND_CHESTPLATE).unsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).lore("�aItem ULTRA").build());
		items.add(new ItemBuilder(Material.DIAMOND_LEGGINGS).unsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).lore("�aItem ULTRA").build());
		items.add(new ItemBuilder(Material.DIAMOND_BOOTS).unsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).lore("�aItem ULTRA").build());
		items.add(new ItemBuilder(Material.DIAMOND_SWORD).unsafeEnchantment(Enchantment.DAMAGE_ALL, 1).lore("�aItem ULTRA").build());
		items.add(new ItemBuilder(Material.GOLDEN_APPLE).durability(1).amount(2).build());

		return items;
	}

	public static List<ItemStack> ultrasemanal() {
		List<ItemStack> items = new ArrayList<ItemStack>();

		items.add(
				new ItemBuilder(Material.CHEST).name("�eCaixa Misteriosa").lore("�7Tipo: �fB�sica").amount(1).build());
		items.add(
				new ItemBuilder(Material.CHEST).name("�eCaixa Misteriosa").lore("�7Tipo: �fB�sica").amount(1).build());
		items.add(new ItemBuilder(Material.ENDER_CHEST).name("�eCaixa Misteriosa").lore("�7Tipo: �fAvan�ada").amount(1)
				.build());

		return items;
	}

	public static List<ItemStack> ultramensal() {
		List<ItemStack> items = new ArrayList<ItemStack>();

		items.add(new ItemBuilder(Material.DIAMOND_HELMET).unsafeEnchantment(Enchantment.DURABILITY, 4)
				.unsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4).lore("�aItem ULTRA").build());
		items.add(new ItemBuilder(Material.DIAMOND_CHESTPLATE).unsafeEnchantment(Enchantment.DURABILITY, 4)
				.unsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4).lore("�aItem ULTRA").build());
		items.add(new ItemBuilder(Material.DIAMOND_LEGGINGS).unsafeEnchantment(Enchantment.DURABILITY, 4)
				.unsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4).lore("�aItem ULTRA").build());
		items.add(new ItemBuilder(Material.DIAMOND_BOOTS).unsafeEnchantment(Enchantment.DURABILITY, 4)
				.unsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4).lore("�aItem ULTRA").build());
		items.add(new ItemBuilder(Material.DIAMOND_SWORD).unsafeEnchantment(Enchantment.DURABILITY, 4)
				.unsafeEnchantment(Enchantment.DAMAGE_ALL, 4).lore("�aItem ULTRA").build());
		items.add(new ItemBuilder(Material.BOW).unsafeEnchantment(Enchantment.DURABILITY, 4)
				.unsafeEnchantment(Enchantment.ARROW_INFINITE, 1).unsafeEnchantment(Enchantment.ARROW_FIRE, 1)
				.unsafeEnchantment(Enchantment.ARROW_DAMAGE, 4).lore("�aItem ULTRA").build());
		//
		items.add(new ItemBuilder(Material.DIAMOND_PICKAXE).unsafeEnchantment(Enchantment.DURABILITY, 4)
				.unsafeEnchantment(Enchantment.DIG_SPEED, 4).lore("�aItem ULTRA").build());
		items.add(new ItemBuilder(Material.DIAMOND_AXE).unsafeEnchantment(Enchantment.DURABILITY, 4)
				.unsafeEnchantment(Enchantment.DIG_SPEED, 4).lore("�aItem ULTRA").build());
		items.add(new ItemBuilder(Material.DIAMOND_SPADE).unsafeEnchantment(Enchantment.DURABILITY, 4)
				.unsafeEnchantment(Enchantment.DIG_SPEED, 4).lore("�aItem ULTRA").build());
		//
		items.add(new ItemBuilder(Material.COOKED_BEEF).amount(32).build());
		items.add(new ItemBuilder(Material.GOLDEN_APPLE).durability(1).amount(20).build());
		items.add(new ItemBuilder(Material.GOLDEN_APPLE).amount(10).build());
		items.add(new ItemBuilder(Material.POTION).durability(8233).amount(5).build());
		items.add(new ItemBuilder(Material.POTION).durability(8226).amount(5).build());
		items.add(new ItemBuilder(Material.BREWING_STAND_ITEM).build());
		items.add(new ItemBuilder(Material.ARROW).build());

		return items;
	}

	public static List<ItemStack> lorddiario() {
		List<ItemStack> items = new ArrayList<ItemStack>();

		items.add(new ItemBuilder(Material.CHAINMAIL_HELMET).unsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1)
				.lore("�dItem LORD").build());
		items.add(new ItemBuilder(Material.CHAINMAIL_CHESTPLATE)
				.unsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).lore("�dItem LORD").build());
		items.add(new ItemBuilder(Material.CHAINMAIL_LEGGINGS)
				.unsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).lore("�dItem LORD").build());
		items.add(new ItemBuilder(Material.CHAINMAIL_BOOTS).unsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1)
				.lore("�dItem LORD").build());
		items.add(new ItemBuilder(Material.DIAMOND_SWORD).unsafeEnchantment(Enchantment.DAMAGE_ALL, 1).lore("�dItem LORD")
				.build());
		items.add(new ItemBuilder(Material.DIAMOND_PICKAXE).unsafeEnchantment(Enchantment.DIG_SPEED, 1).lore("�dItem LORD")
				.build());
		items.add(new ItemBuilder(Material.DIAMOND_AXE).unsafeEnchantment(Enchantment.DIG_SPEED, 1).lore("�dItem LORD")
				.build());
		items.add(new ItemBuilder(Material.DIAMOND_SPADE).unsafeEnchantment(Enchantment.DIG_SPEED, 1).lore("�dItem LORD")
				.build());
		items.add(new ItemBuilder(Material.COOKED_BEEF).amount(16).build());
		items.add(new ItemBuilder(Material.GOLDEN_APPLE).durability(1).amount(4).build());

		return items;
	}

	public static List<ItemStack> lordsemanal() {
		List<ItemStack> items = new ArrayList<ItemStack>();

		items.add(
				new ItemBuilder(Material.CHEST).name("�eCaixa Misteriosa").lore("�7Tipo: �fB�sica").amount(1).build());
		items.add(
				new ItemBuilder(Material.CHEST).name("�eCaixa Misteriosa").lore("�7Tipo: �fB�sica").amount(1).build());
		items.add(new ItemBuilder(Material.ENDER_CHEST).name("�eCaixa Misteriosa").lore("�7Tipo: �fAvan�ada").amount(1)
				.build());

		return items;
	}
	
	public static List<ItemStack> lordmensal() {
		List<ItemStack> items = new ArrayList<ItemStack>();

		items.add(new ItemBuilder(Material.DIAMOND_HELMET).unsafeEnchantment(Enchantment.DURABILITY, 6)
				.unsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 6).lore("�dItem LORD").build());
		items.add(new ItemBuilder(Material.DIAMOND_CHESTPLATE).unsafeEnchantment(Enchantment.DURABILITY, 6)
				.unsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 6).lore("�dItem LORD").build());
		items.add(new ItemBuilder(Material.DIAMOND_LEGGINGS).unsafeEnchantment(Enchantment.DURABILITY, 6)
				.unsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 6).lore("�dItem LORD").build());
		items.add(new ItemBuilder(Material.DIAMOND_BOOTS).unsafeEnchantment(Enchantment.DURABILITY, 6)
				.unsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 6).lore("�dItem LORD").build());
		items.add(new ItemBuilder(Material.DIAMOND_SWORD).unsafeEnchantment(Enchantment.DURABILITY, 6)
				.unsafeEnchantment(Enchantment.DAMAGE_ALL, 6).lore("�dItem LORD").build());
		items.add(new ItemBuilder(Material.BOW).unsafeEnchantment(Enchantment.DURABILITY, 1)
				.unsafeEnchantment(Enchantment.ARROW_INFINITE, 1).unsafeEnchantment(Enchantment.ARROW_FIRE, 2)
				.unsafeEnchantment(Enchantment.ARROW_DAMAGE, 6).lore("�dItem LORD").build());
		//
		items.add(new ItemBuilder(Material.DIAMOND_PICKAXE).unsafeEnchantment(Enchantment.DURABILITY, 6)
				.unsafeEnchantment(Enchantment.DIG_SPEED, 6).lore("�dItem LORD").build());
		items.add(new ItemBuilder(Material.DIAMOND_AXE).unsafeEnchantment(Enchantment.DURABILITY, 6)
				.unsafeEnchantment(Enchantment.DIG_SPEED, 6).lore("�dItem LORD").build());
		items.add(new ItemBuilder(Material.DIAMOND_SPADE).unsafeEnchantment(Enchantment.DURABILITY, 6)
				.unsafeEnchantment(Enchantment.DIG_SPEED, 6).lore("�dItem LORD").build());
		//
		items.add(new ItemBuilder(Material.COOKED_BEEF).amount(64).build());
		items.add(new ItemBuilder(Material.GOLDEN_APPLE).amount(25).build());
		items.add(new ItemBuilder(Material.GOLDEN_APPLE).durability(1).amount(35).build());
		items.add(new ItemBuilder(Material.POTION).durability(8233).amount(10).build());
		items.add(new ItemBuilder(Material.POTION).durability(8226).amount(10).build());
		items.add(new ItemBuilder(Material.BREWING_STAND_ITEM).amount(2).build());
		items.add(new ItemBuilder(Material.ENCHANTMENT_TABLE).amount(2).build());
		items.add(new ItemBuilder(Material.ARROW).build());

		return items;
	}

	public static List<ItemStack> supremodiario() {
		List<ItemStack> items = new ArrayList<ItemStack>();

		items.add(new ItemBuilder(Material.CHAINMAIL_HELMET).unsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2)
				.lore("�3Item SUPREMO").build());
		items.add(new ItemBuilder(Material.CHAINMAIL_CHESTPLATE)
				.unsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).lore("�3Item SUPREMO").build());
		items.add(new ItemBuilder(Material.CHAINMAIL_LEGGINGS)
				.unsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).lore("�3Item SUPREMO").build());
		items.add(new ItemBuilder(Material.CHAINMAIL_BOOTS).unsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2)
				.lore("�3Item SUPREMO").build());
		items.add(new ItemBuilder(Material.DIAMOND_SWORD).unsafeEnchantment(Enchantment.DAMAGE_ALL, 2)
				.lore("�3Item SUPREMO").build());
		items.add(new ItemBuilder(Material.DIAMOND_PICKAXE).unsafeEnchantment(Enchantment.DIG_SPEED, 2)
				.lore("�3Item SUPREMO").build());
		items.add(new ItemBuilder(Material.DIAMOND_AXE).unsafeEnchantment(Enchantment.DIG_SPEED, 2).lore("�3Item SUPREMO")
				.build());
		items.add(new ItemBuilder(Material.DIAMOND_SPADE).unsafeEnchantment(Enchantment.DIG_SPEED, 2)
				.lore("�3Item SUPREMO").build());
		items.add(new ItemBuilder(Material.COOKED_BEEF).amount(32).build());
		items.add(new ItemBuilder(Material.GOLDEN_APPLE).durability(1).amount(6).build());

		return items;
	}

	public static List<ItemStack> supremosemanal() {
		List<ItemStack> items = new ArrayList<ItemStack>();

		items.add(
				new ItemBuilder(Material.CHEST).name("�eCaixa Misteriosa").lore("�7Tipo: �fB�sica").amount(1).build());
		items.add(
				new ItemBuilder(Material.CHEST).name("�eCaixa Misteriosa").lore("�7Tipo: �fB�sica").amount(1).build());
		items.add(
				new ItemBuilder(Material.CHEST).name("�eCaixa Misteriosa").lore("�7Tipo: �fB�sica").amount(1).build());
		items.add(new ItemBuilder(Material.ENDER_CHEST).name("�eCaixa Misteriosa").lore("�7Tipo: �fAvan�ada").amount(1)
				.build());
		items.add(new ItemBuilder(Material.ENDER_CHEST).name("�eCaixa Misteriosa").lore("�7Tipo: �fAvan�ada").amount(1)
				.build());
		items.add(new ItemBuilder(Material.ENDER_PORTAL_FRAME).name("�eCaixa Misteriosa").lore("�7Tipo: �fUltra")
				.amount(1).build());

		return items;
	}
	
	public static List<ItemStack> supremomensal() {
		List<ItemStack> items = new ArrayList<ItemStack>();

		items.add(new ItemBuilder(Material.DIAMOND_HELMET).unsafeEnchantment(Enchantment.DURABILITY, 8)
				.unsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 8).lore("�3Item SUPREMO").build());
		items.add(new ItemBuilder(Material.DIAMOND_CHESTPLATE).unsafeEnchantment(Enchantment.DURABILITY, 8)
				.unsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 8).lore("�3Item SUPREMO").build());
		items.add(new ItemBuilder(Material.DIAMOND_LEGGINGS).unsafeEnchantment(Enchantment.DURABILITY, 8)
				.unsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 8).lore("�3Item SUPREMO").build());
		items.add(new ItemBuilder(Material.DIAMOND_BOOTS).unsafeEnchantment(Enchantment.DURABILITY, 8)
				.unsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 8).lore("�3Item SUPREMO").build());
		items.add(new ItemBuilder(Material.DIAMOND_SWORD).unsafeEnchantment(Enchantment.DURABILITY, 8)
				.unsafeEnchantment(Enchantment.DAMAGE_ALL, 8).lore("�3Item SUPREMO").build());
		items.add(new ItemBuilder(Material.BOW).unsafeEnchantment(Enchantment.DURABILITY, 8)
				.unsafeEnchantment(Enchantment.ARROW_INFINITE, 1).unsafeEnchantment(Enchantment.ARROW_FIRE, 2)
				.unsafeEnchantment(Enchantment.ARROW_DAMAGE, 8).lore("�3Item SUPREMO").build());
		//
		items.add(new ItemBuilder(Material.DIAMOND_PICKAXE).unsafeEnchantment(Enchantment.DURABILITY, 8)
				.unsafeEnchantment(Enchantment.DIG_SPEED, 8).lore("�3Item SUPREMO").build());
		items.add(new ItemBuilder(Material.DIAMOND_AXE).unsafeEnchantment(Enchantment.DURABILITY, 8)
				.unsafeEnchantment(Enchantment.DIG_SPEED, 8).lore("�3Item SUPREMO").build());
		items.add(new ItemBuilder(Material.DIAMOND_SPADE).unsafeEnchantment(Enchantment.DURABILITY, 8)
				.unsafeEnchantment(Enchantment.DIG_SPEED, 8).lore("�3Item SUPREMO").build());
		//
		items.add(new ItemBuilder(Material.GOLDEN_APPLE).amount(30).build());
		items.add(new ItemBuilder(Material.GOLDEN_APPLE).durability(1).amount(50).build());
		items.add(new ItemBuilder(Material.POTION).durability(8233).amount(15).build());
		items.add(new ItemBuilder(Material.POTION).durability(8226).amount(15).build());
		items.add(new ItemBuilder(Material.BREWING_STAND_ITEM).amount(3).build());
		items.add(new ItemBuilder(Material.ENCHANTMENT_TABLE).amount(3).build());
		items.add(new ItemBuilder(Material.ARROW).build());

		return items;
	}

	public static List<ItemStack> hypperdiario() {
		List<ItemStack> items = new ArrayList<ItemStack>();

		items.add(new ItemBuilder(Material.CHAINMAIL_HELMET).unsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3)
				.lore("�6Item HYPPER").build());
		items.add(new ItemBuilder(Material.CHAINMAIL_CHESTPLATE)
				.unsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).lore("�6Item HYPPER").build());
		items.add(new ItemBuilder(Material.CHAINMAIL_LEGGINGS)
				.unsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).lore("�6Item HYPPER").build());
		items.add(new ItemBuilder(Material.CHAINMAIL_BOOTS).unsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3)
				.lore("�6Item HYPPER").build());
		items.add(new ItemBuilder(Material.DIAMOND_SWORD).unsafeEnchantment(Enchantment.DAMAGE_ALL, 3)
				.lore("�6Item HYPPER").build());
		items.add(new ItemBuilder(Material.DIAMOND_PICKAXE).unsafeEnchantment(Enchantment.DIG_SPEED, 3)
				.lore("�6Item HYPPER").build());
		items.add(new ItemBuilder(Material.DIAMOND_AXE).unsafeEnchantment(Enchantment.DIG_SPEED, 3).lore("�6Item HYPPER")
				.build());
		items.add(new ItemBuilder(Material.DIAMOND_SPADE).unsafeEnchantment(Enchantment.DIG_SPEED, 3).lore("�6Item HYPPER")
				.build());
		items.add(new ItemBuilder(Material.GOLDEN_APPLE).durability(1).amount(8).build());

		return items;
	}

	public static List<ItemStack> hyppersemanal() {
		List<ItemStack> items = new ArrayList<ItemStack>();

		items.add(
				new ItemBuilder(Material.CHEST).name("�eCaixa Misteriosa").lore("�7Tipo: �fB�sica").amount(1).build());
		items.add(
				new ItemBuilder(Material.CHEST).name("�eCaixa Misteriosa").lore("�7Tipo: �fB�sica").amount(1).build());
		items.add(
				new ItemBuilder(Material.CHEST).name("�eCaixa Misteriosa").lore("�7Tipo: �fB�sica").amount(1).build());
		items.add(new ItemBuilder(Material.ENDER_CHEST).name("�eCaixa Misteriosa").lore("�7Tipo: �fAvan�ada").amount(1)
				.build());
		items.add(new ItemBuilder(Material.ENDER_CHEST).name("�eCaixa Misteriosa").lore("�7Tipo: �fAvan�ada").amount(1)
				.build());
		items.add(new ItemBuilder(Material.ENDER_PORTAL_FRAME).name("�eCaixa Misteriosa").lore("�7Tipo: �fUltra")
				.amount(1).build());
		items.add(new ItemBuilder(Material.ENCHANTMENT_TABLE).name("�eCaixa Misteriosa").lore("�7Tipo: �fLend�ria")
				.amount(1).build());

		return items;
	}
	
	public static List<ItemStack> hyppermensal() {
		List<ItemStack> items = new ArrayList<ItemStack>();

		items.add(new ItemBuilder(Material.DIAMOND_HELMET).unsafeEnchantment(Enchantment.DURABILITY, 10)
				.unsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10).lore("�6Item HYPPER").build());
		items.add(new ItemBuilder(Material.DIAMOND_CHESTPLATE).unsafeEnchantment(Enchantment.DURABILITY, 10)
				.unsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10).lore("�6Item HYPPER").build());
		items.add(new ItemBuilder(Material.DIAMOND_LEGGINGS).unsafeEnchantment(Enchantment.DURABILITY, 10)
				.unsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10).lore("�6Item HYPPER").build());
		items.add(new ItemBuilder(Material.DIAMOND_BOOTS).unsafeEnchantment(Enchantment.DURABILITY, 10)
				.unsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10).lore("�6Item HYPPER").build());
		items.add(new ItemBuilder(Material.DIAMOND_SWORD).unsafeEnchantment(Enchantment.DURABILITY, 10)
				.unsafeEnchantment(Enchantment.DAMAGE_ALL, 10).lore("�6Item HYPPER").build());
		items.add(new ItemBuilder(Material.BOW).unsafeEnchantment(Enchantment.DURABILITY, 10)
				.unsafeEnchantment(Enchantment.ARROW_INFINITE, 1).unsafeEnchantment(Enchantment.ARROW_FIRE, 2)
				.unsafeEnchantment(Enchantment.ARROW_DAMAGE, 10).lore("�6Item HYPPER").build());
		//
		items.add(new ItemBuilder(Material.DIAMOND_PICKAXE).unsafeEnchantment(Enchantment.DURABILITY, 10)
				.unsafeEnchantment(Enchantment.DIG_SPEED, 10).lore("�6Item HYPPER").build());
		items.add(new ItemBuilder(Material.DIAMOND_AXE).unsafeEnchantment(Enchantment.DURABILITY, 10)
				.unsafeEnchantment(Enchantment.DIG_SPEED, 10).lore("�6Item HYPPER").build());
		items.add(new ItemBuilder(Material.DIAMOND_SPADE).unsafeEnchantment(Enchantment.DURABILITY, 10)
				.unsafeEnchantment(Enchantment.DIG_SPEED, 10).lore("�6Item HYPPER").build());
		//
		items.add(new ItemBuilder(Material.GOLDEN_APPLE).durability(1).amount(64).build());
		items.add(new ItemBuilder(Material.GOLDEN_APPLE).amount(32).build());
		items.add(new ItemBuilder(Material.POTION).durability(8233).amount(20).build());
		items.add(new ItemBuilder(Material.POTION).durability(8226).amount(20).build());
		items.add(new ItemBuilder(Material.BREWING_STAND_ITEM).amount(4).build());
		items.add(new ItemBuilder(Material.ARROW).build());

		return items;
	}

}
