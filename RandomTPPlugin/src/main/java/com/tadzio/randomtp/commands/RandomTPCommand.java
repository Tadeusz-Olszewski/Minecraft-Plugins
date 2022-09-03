package com.tadzio.randomtp.commands;

import com.tadzio.randomtp.items.RTPButtonItem;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RandomTPCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("rtp.give")){
            if(args.length == 0){
                if(!(sender instanceof Player)){
                    sender.sendMessage(ChatColor.RED + "You must be a player");
                    return false;
                }

                Player player = (Player) sender;
                player.getInventory().addItem(RTPButtonItem.getButton());
                player.sendMessage(ChatColor.GREEN + "You've got RTP Button");
                return true;
            } else {
                sender.sendMessage(ChatColor.RED + "Correct use: /rtp");
                return false;
            }
        } else {
            sender.sendMessage(ChatColor.RED + "You don't have permission");
            return false;
        }
    }
}
