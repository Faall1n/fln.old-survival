package com.faall1n.survival.kits;

import com.faall1n.survival.kits.menus.BasicInventory;
import com.faall1n.survival.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class InventoryKits implements Listener {

	public static void open(Player p) {
		Inventory inv = Bukkit.createInventory((InventoryHolder) p, 36, "Categorias de Kits");
		inv.setItem(11, new ItemBuilder(Material.WOOD).name("§eKits Básicos")
				.lore("§7Clique para ver os Kits Básicos do servidor.").build());
		p.openInventory(inv);
	}

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		Inventory inv = e.getInventory();
		if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) {
			return;
		}
		if (inv.getName().equals("Categorias de Kits")) {
			e.setCancelled(true);
			switch (e.getRawSlot()) {
			case 11: {
				BasicInventory.open(p);
				break;
			}
			case 13: {
				break;
			}
			case 15: {
				break;
			}
			case 16: {
				break;
			}
			}
		}
	}
}
