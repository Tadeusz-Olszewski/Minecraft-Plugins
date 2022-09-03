package com.tadzio.chat.commands;

import com.tadzio.chat.Chat;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ChatCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 1){
            if(args[0].equalsIgnoreCase("on")){
                if(!sender.hasPermission("chat.on") || !sender.hasPermission("*")){
                    sender.sendMessage(ChatColor.RED + "You don't have permission !");
                    return false;
                }

                if(Chat.chatEnabled){
                    sender.sendMessage(ChatColor.RED + "Chat is enabled !");
                    return false;
                } else {
                    Chat.chatEnabled = true;
                    sender.sendMessage(ChatColor.GREEN + "Chat is enabled now !");
                    Bukkit.broadcastMessage(ChatColor.GREEN + "Chat has been enabled !");
                    return true;
                }
            } else if (args[0].equalsIgnoreCase("off")){
                if(!sender.hasPermission("chat.off") || !sender.hasPermission("chat.*")){
                    sender.sendMessage(ChatColor.RED + "You don't have permission !");
                    return false;
                }

                if(Chat.chatEnabled){
                    Chat.chatEnabled = false;
                    sender.sendMessage(ChatColor.RED + "Chat is disabled now !");
                    Bukkit.broadcastMessage(ChatColor.RED + "Chat has been disabled !");
                    return true;
                } else {
                    sender.sendMessage(ChatColor.RED + "Chat is disabled !");
                    return false;
                }
            } else if (args[0].equalsIgnoreCase("clear")){
                if(!sender.hasPermission("chat.clear") || !sender.hasPermission("chat.*")){
                    sender.sendMessage(ChatColor.RED + "You don't have permission !");
                    return false;
                }

                for(int i = 0; i < 100; i++){
                    Bukkit.broadcastMessage("");
                }

                Bukkit.broadcastMessage(ChatColor.GREEN + "Chat has been cleared");
                return true;
            }
        } else {
            if(!sender.hasPermission("chat.help") || !sender.hasPermission("chat.*")){
                sender.sendMessage(ChatColor.RED + "You don't have permission !");
                return false;
            }

            sender.sendMessage("/chat on - enabled chat");
            sender.sendMessage("/chat off - disabled chat");
            sender.sendMessage("/chat clear - clear chat");
            return true;
        }
        return false;
    }
}