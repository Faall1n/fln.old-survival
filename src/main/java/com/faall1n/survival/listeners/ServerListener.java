package com.faall1n.survival.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.event.server.ServerListPingEvent;

public class ServerListener implements Listener {

    @EventHandler
    public void serverMotd(ServerListPingEvent e) {
        e.setMotd("§6§lSURVIVAL §7(1.9)" + "\n" + "§bUm novo servidor, uma nova era!");
    }

    @EventHandler
    public void onJoinWhitelist(PlayerLoginEvent e) {
        if (e.getResult() == Result.KICK_WHITELIST) {
            if (e.getPlayer().hasPermission("survival.staff.mod")) {
                e.allow();
                return;
            }
            e.setKickMessage(
                    "§c§lSURVIVAL" + "\n"
                            + "\n"
                            + "§cDesculpe, mas nosso servidor está em Manutenção,"
                            + "\n" + "espere alguns minutos ou tente mais tarde.");

        }
    }

    @EventHandler
    public void onJoinFullPlayer(PlayerLoginEvent e) {
        if (e.getResult() == Result.KICK_FULL) {
            if (e.getPlayer().hasPermission("survival.vip.full")) {
                e.allow();
                return;
            }
            e.setKickMessage(
                    "§c§lSURVIVAL" + "\n"
                            + "\n"
                            + "§cDesculpe, mas nosso servidor está em cheio,"
                            + "\n" + "espere alguns minutos ou tente mais tarde.");
        }
    }

    @EventHandler
    public void onPlayerColor(SignChangeEvent e) {
        Player p = e.getPlayer();
        if (p.hasPermission("survival.cor")) {
            if (e.getLine(0).contains("&")) {
                e.setLine(0, e.getLine(0).replace("&", "§"));
            }
            if (e.getLine(1).contains("&")) {
                e.setLine(1, e.getLine(1).replace("&", "§"));
            }
            if (e.getLine(2).contains("&")) {
                e.setLine(2, e.getLine(2).replace("&", "§"));
            }
            if (e.getLine(3).contains("&")) {
                e.setLine(3, e.getLine(3).replace("&", "§"));
            }
        }
    }

}
