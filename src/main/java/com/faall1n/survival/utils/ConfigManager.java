package com.faall1n.survival.utils;

import com.faall1n.survival.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;

import java.io.File;

public class ConfigManager implements Listener {

	public static void createNewConfig(String file) {
		if (!new File(Main.instance.getDataFolder(), file + ".yml").exists()) {
			Main.instance.saveResource(file + ".yml", false);
		}
	}

	public static FileConfiguration getConfig(String file) {
		File arquivo = new File(Main.instance.getDataFolder() + "/" + file + ".yml");
		FileConfiguration config = (FileConfiguration) YamlConfiguration.loadConfiguration(arquivo);
		return config;
	}
}
