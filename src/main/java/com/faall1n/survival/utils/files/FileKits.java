package com.faall1n.survival.utils.files;

import java.io.File;
import java.io.IOException;

import com.faall1n.survival.Main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class FileKits {

	public static FileConfiguration DATA_YAML;
	public static File f;

	public static void createCustomConfig() {
		FileKits.f = new File(Main.getInstance().getDataFolder(), "kits.yml");
		if (!FileKits.f.exists()) {
			try {
				FileKits.f.createNewFile();
			} catch (IOException var2) {
				Bukkit.getConsoleSender().sendMessage("§cNão foi possível criar o arquivo kits.yml");
			}
		}
		FileKits.DATA_YAML = (FileConfiguration) YamlConfiguration.loadConfiguration(FileKits.f);
	}

	public static FileConfiguration getConfig() {
		return FileKits.DATA_YAML;
	}

}
