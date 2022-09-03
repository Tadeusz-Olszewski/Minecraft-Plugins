package com.tadzio.heal.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("heal")){
            if(args.length == 0){
                if(sender.hasPermission("heal.*") || sender.hasPermission("heal.me")){
                    Player player = (Player) sender;
                    player.setHealth(20);
                    sender.sendMessage("You has been healed");
                    return true;
                } else {
                    sender.sendMessage("You don't have permission");
                    return false;
                }
            } else if(args.length == 1) {
                if (sender.hasPermission("heal.*") || sender.hasPermission("heal.player")) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if(target != null){
                        target.setHealth(20);
                        target.sendMessage("You has been healted :D");
                        return true;
                    } else {
                        sender.sendMessage("Player " + args[0] + " has been offline !");
                        return false;
                    }
                }
            } else {
                sender.sendMessage("/heal or /heal <player>");
                return false;
            }

        }
        return false;
    }
}
