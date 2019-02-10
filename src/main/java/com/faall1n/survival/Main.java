package com.faall1n.survival;

import com.faall1n.survival.chat.Global;
import com.faall1n.survival.chat.Local;
import com.faall1n.survival.commands.Aviso;
import com.faall1n.survival.commands.Fly;
import com.faall1n.survival.commands.Kit;
import com.faall1n.survival.kits.InventoryKits;
import com.faall1n.survival.kits.menus.BasicInventory;
import com.faall1n.survival.kits.menus.preview.PreviewBasico;
import com.faall1n.survival.kits.menus.preview.PreviewDiario;
import com.faall1n.survival.kits.menus.preview.PreviewMensal;
import com.faall1n.survival.kits.menus.preview.PreviewSemanal;
import com.faall1n.survival.listeners.PlayerListener;
import com.faall1n.survival.listeners.ServerListener;
import com.faall1n.survival.listeners.scoreboard.Score;
import com.faall1n.survival.listeners.tags.NameTags;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
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
    private static Economy econ = null;

    public static Chat getChat() {
        return chat;
    }

    public static Economy getEconomy() {
        return econ;
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
        setupEconomy();

        NameTags.run();

        carregarCommands();
        carregarEventos();
        Score.run();

        ConsoleCommandSender console = Bukkit.getConsoleSender();

        console.sendMessage("");
        console.sendMessage("§a[Survival] - " + getPlugin().getDescription().getDescription());
        console.sendMessage("§a[Survival] - " + getPlugin().getDescription().getVersion());
        console.sendMessage("§a[Survival] - Plugin iniciado");
        console.sendMessage("");

    }

    public void carregarCommands() {

        new Global("g", "/g", "Chat Global");

        new Aviso("aviso", "/aviso", "Aviso");
        new Aviso("avisar", "/avisar", "Aviso");
        new Aviso("say", "/say", "Say");
        new Fly("fly", "/fly", "Fly");
        new Kit("kit", "/kit", "Kits");
        new Kit("kits", "/kits", "Kits");

    }

    public void carregarEventos() {
        PluginManager PM = Bukkit.getPluginManager();

        PM.registerEvents(new Local(), this);

        PM.registerEvents(new PlayerListener(), this);
        PM.registerEvents(new ServerListener(), this);
        PM.registerEvents(new Score(), this);

        PM.registerEvents(new InventoryKits(), this);
        PM.registerEvents(new BasicInventory(), this);
        PM.registerEvents(new PreviewBasico(), this);
        PM.registerEvents(new PreviewDiario(), this);
        PM.registerEvents(new PreviewSemanal(), this);
        PM.registerEvents(new PreviewMensal(), this);

    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }

}
