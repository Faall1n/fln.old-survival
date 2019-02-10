package com.faall1n.survival.utils;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bukkit.configuration.file.FileConfiguration;

public class Cooldown {
	static Map<String, Long> map;
	private FileConfiguration fc;
	private File f;

	static {
		Cooldown.map = new HashMap<String, Long>();
	}

	public Cooldown(FileConfiguration dFileC, File dFile) {
		this.fc = dFileC;
		this.f = dFile;
	}

	public void addDelay(String id) {
		if (this.fc != null && this.f != null) {
			this.fc.set(id, (Object) System.currentTimeMillis());
			Cooldown.map.put(id, System.currentTimeMillis());
			try {
				this.fc.save(this.f);
			} catch (IOException ex) {
			}
		}
	}

	public long getDelay(String id) {
		if (Cooldown.map.containsKey(id)) {
			return Cooldown.map.get(id);
		}
		return this.fc.contains(id) ? this.fc.getLong(id) : System.currentTimeMillis();
	}

	public boolean acabouDelay(String id, long l) {
		String coisa = this.getDelayString(id, l);
		return coisa.equals("agora");
	}

	public String getDelayString(String id, long l) {
		long tempoAntes = this.getDelay(id);
		long tempoAtual = System.currentTimeMillis() - l;
		String coisa = this.formatDifferenceStr(tempoAntes - tempoAtual);
		return coisa;
	}

	public void removeDelay(String id) {
		if (Cooldown.map.containsKey(id)) {
			Cooldown.map.remove(id);
		}
		if (this.fc.contains(id)) {
			this.fc.set(id, (Object) null);
			try {
				this.fc.save(this.f);
			} catch (IOException ex) {
			}
		}
	}

	public boolean temDelay(String id) {
		return Cooldown.map.containsKey(id) || this.fc.contains(id);
	}

	public String formatDifferenceStr(long time) {
		if (time == 0L) {
			return "never";
		}
		long day = TimeUnit.MILLISECONDS.toDays(time);
		long hours = TimeUnit.MILLISECONDS.toHours(time) - day * 24L;
		long minutes = TimeUnit.MILLISECONDS.toMinutes(time) - TimeUnit.MILLISECONDS.toHours(time) * 60L;
		long seconds = TimeUnit.MILLISECONDS.toSeconds(time) - TimeUnit.MILLISECONDS.toMinutes(time) * 60L;
		StringBuilder sb = new StringBuilder();
		if (day > 0L) {
			sb.append(day).append(" ").append((day == 1L) ? "dia" : "dias").append(" ");
		}
		if (hours > 0L) {
			sb.append(hours).append(" ").append((hours == 1L) ? "hora" : "horas").append(" ");
		}
		if (minutes > 0L) {
			sb.append(minutes).append(" ").append((minutes == 1L) ? "minuto" : "minutos").append(" ");
		}
		if (seconds > 0L) {
			sb.append(seconds).append(" ").append((seconds == 1L) ? "segundo" : "segundos").append(" ");
		}
		String diff = sb.toString();
		return diff.isEmpty() ? "agora" : diff;
	}

	public String getDifferenceFormatStr(long timestamp) {
		return this.formatDifferenceStr(timestamp - System.currentTimeMillis());
	}

	public long parseDateDiff(String time, boolean future) throws Exception {
		Pattern timePattern = Pattern.compile(
				"(?:([0-9]+)\\s*y[a-z]*[,\\s]*)?(?:([0-9]+)\\s*mo[a-z]*[,\\s]*)?(?:([0-9]+)\\s*w[a-z]*[,\\s]*)?(?:([0-9]+)\\s*d[a-z]*[,\\s]*)?(?:([0-9]+)\\s*h[a-z]*[,\\s]*)?(?:([0-9]+)\\s*m[a-z]*[,\\s]*)?(?:([0-9]+)\\s*(?:s[a-z]*)?)?",
				2);
		Matcher m = timePattern.matcher(time);
		int years = 0;
		int months = 0;
		int weeks = 0;
		int days = 0;
		int hours = 0;
		int minutes = 0;
		int seconds = 0;
		boolean found = false;
		while (m.find()) {
			if (m.group() != null && !m.group().isEmpty()) {
				for (int i = 0; i < m.groupCount(); ++i) {
					if (m.group(i) != null && !m.group(i).isEmpty()) {
						found = true;
						break;
					}
				}
				if (!found) {
					continue;
				}
				if (m.group(1) != null && !m.group(1).isEmpty()) {
					years = Integer.parseInt(m.group(1));
				}
				if (m.group(2) != null && !m.group(2).isEmpty()) {
					months = Integer.parseInt(m.group(2));
				}
				if (m.group(3) != null && !m.group(3).isEmpty()) {
					weeks = Integer.parseInt(m.group(3));
				}
				if (m.group(4) != null && !m.group(4).isEmpty()) {
					days = Integer.parseInt(m.group(4));
				}
				if (m.group(5) != null && !m.group(5).isEmpty()) {
					hours = Integer.parseInt(m.group(5));
				}
				if (m.group(6) != null && !m.group(6).isEmpty()) {
					minutes = Integer.parseInt(m.group(6));
				}
				if (m.group(7) != null && !m.group(7).isEmpty()) {
					seconds = Integer.parseInt(m.group(7));
					break;
				}
				break;
			}
		}
		if (!found) {
			throw new Exception("Illegal Date");
		}
		if (years > 20) {
			throw new Exception("Illegal Date");
		}
		Calendar c = new GregorianCalendar();
		if (years > 0) {
			c.add(1, years * (future ? 1 : -1));
		}
		if (months > 0) {
			c.add(2, months * (future ? 1 : -1));
		}
		if (weeks > 0) {
			c.add(3, weeks * (future ? 1 : -1));
		}
		if (days > 0) {
			c.add(5, days * (future ? 1 : -1));
		}
		if (hours > 0) {
			c.add(11, hours * (future ? 1 : -1));
		}
		if (minutes > 0) {
			c.add(12, minutes * (future ? 1 : -1));
		}
		if (seconds > 0) {
			c.add(13, seconds * (future ? 1 : -1));
		}
		return c.getTimeInMillis();
	}
}
