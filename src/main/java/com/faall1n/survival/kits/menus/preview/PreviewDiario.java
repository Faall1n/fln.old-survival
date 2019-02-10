package com.faall1n.survival.kits.menus.preview;

import java.util.List;

import com.faall1n.survival.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class PreviewDiario implements Listener {

	public static void open(Player p, String name, List<ItemStack> items, String tipo) {
		Inventory inv = Bukkit.createInventory((InventoryHolder) p, 45, "Diário - " + name);
		int index = 0;
		int x = 1;
		int h = 1;
		while (index < items.size()) {
			ItemStack item = items.get(index);
			inv.setItem(x + 9 * h, item);
			if (++x == 8) {
				x = 1;
				++h;
			}
			++index;
		}
		inv.setItem(40, new ItemBuilder(Material.CARPET).durability(14).name("�aVoltar").build());
		p.openInventory(inv);
	}

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		Inventory inv = e.getInventory();
		if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) {
			return;
		}
		if (inv.getName().startsWith("Diário - ")) {
			e.setCancelled(true);
			switch (e.getRawSlot()) {
			case 40: {
				break;
			}
			}
		}
	}
}