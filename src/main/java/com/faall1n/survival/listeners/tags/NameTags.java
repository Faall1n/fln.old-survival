package com.faall1n.survival.listeners.tags;

import com.faall1n.survival.Main;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class NameTags {
    @SuppressWarnings("deprecation")
    public static void updateGroupTablist(final Player p) {
        try {
            final Scoreboard sb = (p.getScoreboard() != null) ? p.getScoreboard()
                    : Bukkit.getScoreboardManager().getNewScoreboard();
            for (final Player player : Bukkit.getOnlinePlayers()) {
                final String uuid = Bukkit.getPlayer(player.getName().toLowerCase()).getUniqueId().toString()
                        .replace("-", "").substring(0, 15);
                Team Tag = null;
                if (p.hasPermission("tag.cord")) {
                    Tag = sb.getTeam("a" + uuid);
                    if (Tag == null) {
                        Tag = sb.registerNewTeam("a" + uuid);
                        Tag.setPrefix("§4[CORD] §f");
                    }
                } else if (p.hasPermission("tag.dev")) {
                    Tag = sb.getTeam("b" + uuid);
                    if (Tag == null) {
                        Tag = sb.registerNewTeam("b" + uuid);
                        Tag.setPrefix("§3[DEV] §f");
                    }
                } else {
                    Tag = sb.getTeam("z" + uuid);
                    if (Tag == null) {
                        Tag = sb.registerNewTeam("z" + uuid);
                        Tag.setPrefix("§f");
                    }
                }
                Tag.addPlayer((OfflinePlayer) player);
            }
        } catch (Exception ex) {
        }
    }

    public static void run() {
        new BukkitRunnable() {
            public void run() {
                for (final Player p : Bukkit.getOnlinePlayers()) {
                    NameTags.updateGroupTablist(p);
                }
            }
        }.runTaskTimer(Main.plugin, 0L, 10L);
    }
}