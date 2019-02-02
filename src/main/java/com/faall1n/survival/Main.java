package com.faall1n.survival;

import com.faall1n.survival.listeners.PlayerListener;
import com.faall1n.survival.listeners.ServerListener;
import com.faall1n.survival.listeners.scoreboard.Score;
import net.milkbowl.vault.chat.Chat;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
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
    }

    @Override
    public void onEnable() {
        setupChat();
        carregarEventos();
        Score.run();

        ConsoleCommandSender console = Bukkit.getConsoleSender();

        console.sendMessage("");
        console.sendMessage("§a[Survival] - " + getPlugin().getDescription().getVersion());
        console.sendMessage("§a[Survival] - Plugin iniciado");
        console.sendMessage("");

    }

    public void carregarEventos() {
        PluginManager PM = Bukkit.getPluginManager();

        PM.registerEvents(new PlayerListener(), this);
        PM.registerEvents(new ServerListener(), this);
        PM.registerEvents(new Score(), this);

    }


    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }

}
