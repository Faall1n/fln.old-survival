package com.faall1n.survival.listeners;

import com.faall1n.survival.Main;
import com.faall1n.survival.utils.Helper;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage(null);
        Player p = e.getPlayer();

        for (int i = 250; i > 0; i--) {
            p.sendMessage(" ");
        }
        Helper.sendTitle(p, "§6§lBEM-VINDO", "§fao Survival!");
        p.sendMessage("");
        p.sendMessage("§aBem-vindo, §f" + Helper.getGroup(p) + p.getName() + "§a ao Survival!");
        p.sendMessage("");
        p.sendMessage("§aEstamos com §f" + Bukkit.getOnlinePlayers().size() + "§a jogadores online!");
        p.sendMessage("§aObrigado por jogar em nosso Servidor.");
        p.sendMessage("");

        for (Player all : Bukkit.getOnlinePlayers()) {
            if (p.hasPermission("survival.vip.join")) {
                all.sendMessage(Helper.getGroup(p) + p.getName() + "§6 entrou no servidor!");
            }
        }

    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        e.setQuitMessage(null);
        Player p = e.getPlayer();

        for (Player all : Bukkit.getOnlinePlayers()) {
            if (p.hasPermission("survival.vip.join")) {
                all.sendMessage(Helper.getGroup(p) + "§6 saiu do servidor!");
            }
        }
    }

}
