package com.faall1n.survival.listeners;

import com.faall1n.survival.utils.Helper;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.event.server.ServerListPingEvent;

public class ServerListener implements Listener {

    @EventHandler
    public void serverMotd(ServerListPingEvent e) {
        e.setMotd("§5§lInviNetwork§5.com - §lSurvival §7(1.9)" + "\n" + "§b§lSurvival§e aberto para todos!");
    }

    @EventHandler
    public void onTabList(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        Helper.sendTablist(p,
                "\n" +
                        "§5§lINVI NETWORK" + "§7\n§7" +
                        "§7§finvinetwork.com" + "\n" + "\n" + "§dServidor conectado: §fSurvival" +
                        "" +
                        "\n","\n" +
                        "§dDiscord: §finvigo.me/discord" + "\n" +
                        "§dFórum: §finvigo.me/forum" + "\n" +
                        "§dLoja: §finvigo.me/store" + "\n" + "\n" +
                        "§5Comprando VIP você ajuda nosso servidor a ficar online!" + "\n");

    }

    @EventHandler
    public void onJoinWhitelist(PlayerLoginEvent e) {
        if (e.getResult() == Result.KICK_WHITELIST) {
            if (e.getPlayer().hasPermission("survival.staff.mod")) {
                e.allow();
                return;
            }
            e.setKickMessage(
                    "§c§lINVI SURVIVAL" + "\n§7§c"
                            + "\n§7§c"
                            + "§cDesculpe, mas nosso servidor está em Manutenção,"
                            + "\n§7§c" + "espere alguns minutos ou tente mais tarde.");

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
                    "§c§lINVI SURVIVAL" + "\n§7§c"
                            + "\n§7§c"
                            + "§cDesculpe, mas nosso servidor está em cheio,"
                            + "\n§7§c" + "espere alguns minutos ou tente mais tarde.");
        }
    }

    @EventHandler
    public void onPlayerColor(SignChangeEvent e) {
        Player p = e.getPlayer();
        if (p.hasPermission("survival.vip.cor")) {
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
