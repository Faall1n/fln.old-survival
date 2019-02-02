package com.faall1n.survival.listeners;

import com.faall1n.survival.Main;
import com.faall1n.survival.utils.Helper;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage(null);
        Player p = e.getPlayer();

        String grupo = Main.getChat().getPlayerPrefix(p);

        for (int i = 150; i > 0; i--) {
            p.sendMessage(" ");
        }
        Helper.sendTitle(p, "§6§lBEM-VINDO", "§fAo Survival!");
        p.sendMessage("");
        p.sendMessage("§aBem-vindo §f" + p.getName() + "§a ao Survival!");
        p.sendMessage("");
        p.sendMessage("§aEstamos com §f" + Bukkit.getOnlinePlayers().size() + "§a jogadores online!");
        p.sendMessage("§aObrigado por jogar em nosso Servidor ^^");
        p.sendMessage("");

        if (p.hasPermission("survival.vida.20")) {
            p.setMaxHealth(40);
            p.setHealth(40);
        } else if (p.hasPermission("survival.vida.15")) {
            p.setMaxHealth(7.5);
            p.setHealth(7.5);
        } else if (p.hasPermission("survival.vida.10")) {
            p.setMaxHealth(5);
            p.setHealth(5);
        }

    }

}
