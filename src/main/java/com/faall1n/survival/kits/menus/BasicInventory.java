package com.faall1n.survival.kits.menus;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.faall1n.survival.kits.items.BasicsItems;
import com.faall1n.survival.kits.menus.preview.PreviewBasico;
import com.faall1n.survival.kits.menus.preview.PreviewSemanal;
import com.faall1n.survival.utils.Cooldown;
import com.faall1n.survival.utils.ItemBuilder;
import com.faall1n.survival.utils.files.FileKits;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import com.faall1n.survival.kits.InventoryKits;

public class BasicInventory implements Listener {

	public Cooldown cool;

	public static void open(Player p) {
		Inventory inv = Bukkit.createInventory((InventoryHolder) p, 36, "Kits - Básicos");
		inv.setItem(11, new ItemBuilder(Material.IRON_CHESTPLATE).name("§eBásico")
				.lore("§7Clique com esquerdo para §fpegar o kit§7.", "§7Clique com direito para §fver conteúdo§7.")
				.build());
		inv.setItem(31, new ItemBuilder(Material.CARPET).durability(14).name("§aVoltar").build());
		p.openInventory(inv);
	}

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		Inventory inv = e.getInventory();
		if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) {
			return;
		}
		if (inv.getName().equals("Kits - Básicos")) {
			e.setCancelled(true);
			switch (e.getRawSlot()) {
			case 31: {
				InventoryKits.open(p);
				break;
			}
			case 11: {
				List<ItemStack> items0 = BasicsItems.pvp();
				if (e.isRightClick()) {
					PreviewBasico.open(p, "Básico", items0, "Básicos");
					break;
				}
				if (p.getInventory().firstEmpty() == -1) {
					p.sendMessage("§cVocê não possui espaço suficiente no inventário.");
					return;
				}
				if (p.hasPermission("survival.kits.bypass")) {
					p.closeInventory();
					for (ItemStack item : items0) {
						if (p.getInventory().firstEmpty() == -1) {
							p.getWorld().dropItem(p.getLocation(), item);
						} else {
							p.getInventory().addItem(new ItemStack[]{item});
						}
					}
					String name = ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName());
					p.sendMessage("§aKit '" + name + "' coletado.");
					p.updateInventory();
					break;
				}
				this.cool = new Cooldown(FileKits.getConfig(), new File("plugins/Survival/kits.yml"));
				if (this.cool.acabouDelay("kits." + p.getName() + ".pvp", TimeUnit.MINUTES.toMillis(5L))) {
					this.cool.removeDelay("kits." + p.getName() + ".pvp");
				} else if (this.cool.temDelay("kits." + p.getName() + ".pvp")) {
					p.closeInventory();
					p.sendMessage("§cAguarde "
							+ this.cool.getDelayString("kits." + p.getName() + ".pvp", TimeUnit.MINUTES.toMillis(5L))
							+ "para coletar este kit novamente.");
				}
				if (!this.cool.temDelay("kits." + p.getName() + ".pvp")) {
					this.cool.addDelay("kits." + p.getName() + ".pvp");
					p.closeInventory();
					for (ItemStack item : items0) {
						if (p.getInventory().firstEmpty() == -1) {
							p.getWorld().dropItem(p.getLocation(), item);
						} else {
							p.getInventory().addItem(new ItemStack[]{item});
						}
					}
					p.updateInventory();
					String name = ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName());
					p.sendMessage("§aKit '" + name + "' coletado.");
					break;
				}
				break;
			}
			}
		}
	}

}
