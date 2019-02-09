package com.faall1n.survival.chat;

import com.faall1n.survival.Main;
import com.faall1n.survival.utils.Helper;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Local implements Listener {

    @EventHandler
    public void on(AsyncPlayerChatEvent e) {
        if (e.isCancelled())
            return;

        e.setCancelled(true);

        String message = e.getMessage();

        if (e.getPlayer().hasPermission("vip.cor"))
            message = message.replace("&", "§");

        if (message.contains("&l") || message.contains("&m") || message.contains("&n") || message.contains("&o")
                || message.contains("&i") || message.contains("&k")) {
            e.getPlayer().sendMessage("§cSua mensagem contém caracteres inválidos.");
        }

        String grupo = Helper.getGroup(e.getPlayer());

        String format = "§e(l) " + grupo + "§f" + e.getPlayer().getName() + "§e: " + message;

        int i = 0;
        Bukkit.getOnlinePlayers().stream()
                .filter(r -> r.getLocation().distanceSquared(e.getPlayer().getLocation()) < 60).forEach(r -> {
            if (e.getPlayer().hasPermission("survival.chat.destaque")) {
                r.sendMessage("");
                r.sendMessage(format);
                r.sendMessage("");
            } else
                r.sendMessage(format);
        });

        if (i == 0) {
            e.getPlayer().sendMessage("§cNão tem ninguém perto de você.");
        }

    }

}