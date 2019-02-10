package com.faall1n.survival.commands;

import com.faall1n.survival.utils.AbstractCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EnderChest extends AbstractCommand {

    public EnderChest(String command, String usage, String description) {
        super(command, usage, description);
        this.register();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cApenas jogadores in-game!");
            return true;
        }

        Player p = (Player) sender;

        if (args.length == 0) {
            if (!p.hasPermission("survival.cmd.enderchest")) {
                p.sendMessage("§cDesculpe, você não possui permissão para executar este comando.");
                return true;
            }
            p.openInventory(p.getEnderChest());
        }
        if (args.length == 1) {
            if (!p.hasPermission("survival.staff.enderchest")) {
                p.sendMessage("§cDesculpe, você não possui permissão para executar este comando.");
                return true;
            }
            Player target = Bukkit.getPlayerExact(args[0]);
            if (target == null) {
                p.sendMessage("§cEste jogador está offline!");
                return true;
            }
            p.openInventory(target.getEnderChest());
        }
		return false;
    }
}
