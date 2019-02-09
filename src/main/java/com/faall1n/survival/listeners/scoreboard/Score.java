package com.faall1n.survival.listeners.scoreboard;

import com.faall1n.survival.Main;
import com.faall1n.survival.utils.Helper;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class Score implements Listener {	

	public static void run() {

		new BukkitRunnable() {
			@Override
			public void run() {
				for (Player players : Bukkit.getOnlinePlayers()) {
					update(players);
				}
			}
		}.runTaskTimerAsynchronously(Main.getInstance(), 0L, 3L);

	}

	public static void build(Player p) {
		Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective obj = sb.registerNewObjective("score", "dummy");

		obj.setDisplayName("§5§lINVI SURVIVAL");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);

		LineAdder line = new LineAdder(sb, obj);

		line.addLine("", "§3", "", 9);
		line.addLine("", " §fCash: §6", "?", 8);
		line.addLine("", " §fCoins: §7", "?", 7);
		line.addLine("", "§2", "", 6);
		line.addLine("", " §fGrupo: §4", "?", 5);
		line.addLine("", "§1", "", 4);
		line.addLine("", " §fJogadores: §a", "?", 3);
		line.addLine("", " §fClã: §c", "?", 2);
		line.addLine("", "§0", "", 1);
		line.addLine("", "§5invinetwork.com", "", 0);

		p.setScoreboard(sb);
	}

	public static void update(Player p) {

		NumberFormat nf = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));

		Scoreboard sb = p.getScoreboard();
		if (sb.getObjective("score") != null) {

			Team coins = sb.getTeam("line7");
			coins.setSuffix(nf.format(Main.getEconomy().getBalance(p)) + "");

			Team grupo = sb.getTeam("line5");
			grupo.setSuffix(Helper.getPrefix(p) + "");

			Team server = sb.getTeam("line3");
			server.setSuffix(Helper.getOnline("0.0.0.0", 25565) + "");

		}
	}

	@EventHandler
	void evento(PlayerJoinEvent e) {
		build(e.getPlayer());
	}

}