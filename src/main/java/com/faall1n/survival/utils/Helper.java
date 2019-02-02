package com.faall1n.survival.utils;

import com.faall1n.survival.Main;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Helper {

	public static String getGroup(Player p) {
		String group = Main.getChat().getPlayerPrefix(p);
		String prefix = group.replace("&", "§");

		return prefix;
	}

	public static String getPrefix(Player p) {
		String group = Main.getChat().getPlayerPrefix(p);
		String prefix = group.replace("&", "§").replace("[", "").replace("]", "");

		return prefix;
	}

	public static int getOnline(String ip, int porta) {
		int online = new getServer(ip, porta).JogadoresOnline;
		return online;
	}

	public static void sendTitle(Player p, String texto, String texto0) {
		TitleAPI titleapi = new TitleAPI(texto, texto0);
		titleapi.send(p);
	}

	public static void sendServer(Player p, String server) {
		ByteArrayDataOutput out = ByteStreams.newDataOutput();
		out.writeUTF("Connect");
		out.writeUTF(server);
		p.sendPluginMessage(Main.getInstance(), "BungeeCord", out.toByteArray());
	}

	// TabList

	public static Class<?> getNmsClass(String nmsClassName) throws ClassNotFoundException {
		return Class.forName("net.minecraft.server."
				+ Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3] + "."
				+ nmsClassName);
	}

	public static String getServerVersion() {
		return Bukkit.getServer().getClass().getPackage().getName().substring(23);
	}

	public static void sendTablist(Player p, String msg, String msg2) {
		try {
			if ((getServerVersion().equalsIgnoreCase("v1_9_R1")) || (getServerVersion().equalsIgnoreCase("v1_9_R2"))) {
				Object header = getNmsClass("ChatComponentText").getConstructor(new Class[] { String.class })
						.newInstance(new Object[] { ChatColor.translateAlternateColorCodes('&', msg) });
				Object footer = getNmsClass("ChatComponentText").getConstructor(new Class[] { String.class })
						.newInstance(new Object[] { ChatColor.translateAlternateColorCodes('&', msg2) });

				Object ppoplhf = getNmsClass("PacketPlayOutPlayerListHeaderFooter")
						.getConstructor(new Class[] { getNmsClass("IChatBaseComponent") })
						.newInstance(new Object[] { header });

				Field f = ppoplhf.getClass().getDeclaredField("b");
				f.setAccessible(true);
				f.set(ppoplhf, footer);

				Object nmsp = p.getClass().getMethod("getHandle", new Class[0]).invoke(p, new Object[0]);
				Object pcon = nmsp.getClass().getField("playerConnection").get(nmsp);

				pcon.getClass().getMethod("sendPacket", new Class[] { getNmsClass("Packet") }).invoke(pcon,
						new Object[] { ppoplhf });
			} else if ((getServerVersion().equalsIgnoreCase("v1_8_R2"))
					|| (getServerVersion().equalsIgnoreCase("v1_8_R3"))) {
				Object header = getNmsClass("IChatBaseComponent$ChatSerializer")
						.getMethod("a", new Class[] { String.class })
						.invoke(null, new Object[] { "{'text': '" + msg + "'}" });
				Object footer = getNmsClass("IChatBaseComponent$ChatSerializer")
						.getMethod("a", new Class[] { String.class })
						.invoke(null, new Object[] { "{'text': '" + msg2 + "'}" });

				Object ppoplhf = getNmsClass("PacketPlayOutPlayerListHeaderFooter")
						.getConstructor(new Class[] { getNmsClass("IChatBaseComponent") })
						.newInstance(new Object[] { header });

				Field f = ppoplhf.getClass().getDeclaredField("b");
				f.setAccessible(true);
				f.set(ppoplhf, footer);

				Object nmsp = p.getClass().getMethod("getHandle", new Class[0]).invoke(p, new Object[0]);
				Object pcon = nmsp.getClass().getField("playerConnection").get(nmsp);

				pcon.getClass().getMethod("sendPacket", new Class[] { getNmsClass("Packet") }).invoke(pcon,
						new Object[] { ppoplhf });
			} else {
				Object header = getNmsClass("ChatSerializer").getMethod("a", new Class[] { String.class }).invoke(null,
						new Object[] { "{'text': '" + msg + "'}" });
				Object footer = getNmsClass("ChatSerializer").getMethod("a", new Class[] { String.class }).invoke(null,
						new Object[] { "{'text': '" + msg2 + "'}" });

				Object ppoplhf = getNmsClass("PacketPlayOutPlayerListHeaderFooter")
						.getConstructor(new Class[] { getNmsClass("IChatBaseComponent") })
						.newInstance(new Object[] { header });

				Field f = ppoplhf.getClass().getDeclaredField("b");
				f.setAccessible(true);
				f.set(ppoplhf, footer);

				Object nmsp = p.getClass().getMethod("getHandle", new Class[0]).invoke(p, new Object[0]);
				Object pcon = nmsp.getClass().getField("playerConnection").get(nmsp);

				pcon.getClass().getMethod("sendPacket", new Class[] { getNmsClass("Packet") }).invoke(pcon,
						new Object[] { ppoplhf });
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException | ClassNotFoundException | InstantiationException | NoSuchFieldException e) {
			e.printStackTrace();
		}
	}

}
