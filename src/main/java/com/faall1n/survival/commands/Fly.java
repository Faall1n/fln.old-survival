package com.faall1n.survival.commands;

import com.faall1n.survival.utils.AbstractCommand;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly extends AbstractCommand {

    public Fly(String command, String usage, String description) {
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

        if (!p.hasPermission("survival.cmd.fly")) {
            p.sendMessage("§cDesculpe, você não possui permissão para executar este comando.");
            return true;
        }
        if (p.getAllowFlight()) {
            p.setAllowFlight(false);
            p.setFlying(false);
            p.sendMessage("§cSeu modo de voo foi desativado!");
            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
        } else {
            p.setAllowFlight(true);
            p.setFlying(true);
            p.sendMessage("§aSeu modo de voo foi ativado!");
            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
        }

        return false;
    }

}

