package com.faall1n.survival.commands;

import com.faall1n.survival.kits.InventoryKits;
import com.faall1n.survival.utils.AbstractCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Kit extends AbstractCommand {

    public Kit(String command, String usage, String description) {
        super(command, usage, description);
        this.register();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cApenas jogadores in-game!");
            return true;
        }
        Player p = (Player) sender;
        InventoryKits.open(p);
        return true;
    }

}
