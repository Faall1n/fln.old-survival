package com.faall1n.survival.commands;

import com.faall1n.survival.utils.AbstractCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Aviso extends AbstractCommand {

    public Aviso(String command, String usage, String description) {
        super(command, usage, description);
        this.register();
    }

    public static String getMensagem(String[] args) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < args.length; i++) {
            sb.append(args[i] + " ");
        }
        return sb.toString();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cApenas jogadores in-game!");
            return true;
        }

        Player p = (Player) sender;

        if (!p.hasPermission("survival.cmd.aviso")) {
            p.sendMessage("§cDesculpe, você não possui permissão para executar este comando.");
            return true;
        }
        if (args.length == 0) {
            p.sendMessage("§cUse: '/aviso <mensagem>'.");
            return true;
        }
        if (args.length >= 1) {
            Bukkit.broadcastMessage(" ");
            Bukkit.broadcastMessage(" §c§l[AVISO] §c" + getMensagem(args));
            Bukkit.broadcastMessage(" ");
        }

        return false;
    }
}
