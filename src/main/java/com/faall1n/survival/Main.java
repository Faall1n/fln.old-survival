package com.faall1n.survival;

import net.milkbowl.vault.chat.Chat;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Plugin plugin;
    public static Main instance;
    private static Chat chat = null;

    public static Chat getChat() {
        return chat;
    }

    public static Main getInstance() {
        return instance;
    }

    public static Plugin getPlugin() {
        return plugin;
    }

    public Main() {
        plugin = this;
        instance = this;
        setupChat();
    }

    @Override
    public void onEnable() {

        ConsoleCommandSender console = Bukkit.getConsoleSender();

        console.sendMessage("");
        console.sendMessage("§a[Survival] - " + getPlugin().getDescription().getVersion());
        console.sendMessage("§a[Survival] - Plugin iniciado");
        console.sendMessage("");

    }

    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }

}
