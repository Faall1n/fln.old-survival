package com.faall1n.survival.chat;

import com.faall1n.survival.utils.AbstractCommand;
import com.faall1n.survival.utils.Helper;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Global extends AbstractCommand {

    public Global(String command, String usage, String description) {
        super(command, usage, description);
        this.register();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String arg2, String[] args) {
        if (sender instanceof Player) {

            Player p = (Player) sender;

            if (args.length == 0) {
                p.sendMessage("§cUtiliez: '/g <mensagem>'.");
                return false;
            }

            if (args.length > 0) {

                String msg = "";
                for (String msg2 : args) {
                    msg = String.valueOf(String.valueOf(msg)) + msg2 + " ";
                }

                String grupo = Helper.getGroup(p);

                String format = "§7(g) " + grupo + "§f" + p.getName() + "§7: " + msg;

                if (sender.hasPermission("survival.vip.cor"))
                    format = format.replace("&", "§");

                if (msg.contains("&l") || msg.contains("&m") || msg.contains("&n") || msg.contains("&o")
                        || msg.contains("&i") || msg.contains("&k")) {
                    sender.sendMessage("§cSua mensagem contém caracteres inválidos.");
                    return true;
                }

                for (Player pp : Bukkit.getOnlinePlayers()) {
                    if (pp.hasPermission("survival.chat.destaque")) {
                        pp.sendMessage("");
                        pp.sendMessage(format);
                        pp.sendMessage("");
                    } else {
                        pp.sendMessage(format);
                    }
                }
            }
        }
        return false;
    }

}
