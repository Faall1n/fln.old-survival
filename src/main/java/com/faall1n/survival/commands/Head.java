package com.faall1n.survival.commands;

import com.faall1n.survival.utils.AbstractCommand;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class Head extends AbstractCommand {

    public Head(String command, String usage, String description) {
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

        if (!p.hasPermission("survival.cmd.head")) {
            p.sendMessage("§cDesculpe, você não possui permissão para executar este comando.");
            return true;
        }
        if (args.length == 0) {
            p.sendMessage(" §cUse '/head <jogador>'.");
            return true;
        }
        if (args.length == 1) {

            ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
            SkullMeta meta = (SkullMeta) skull.getItemMeta();
            meta.setOwner(args[0]);
            skull.setItemMeta(meta);

            p.getInventory().addItem(skull);
            p.sendMessage("§aVocê pegou a cabeça do " + args[0]);
            return true;
        }
        return false;
    }

}
