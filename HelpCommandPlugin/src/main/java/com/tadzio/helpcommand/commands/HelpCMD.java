package com.tadzio.helpcommand.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class HelpCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("help")){
            sender.sendMessage("/spawn - to teleport to spawn");
            sender.sendMessage("If you have any question use /helpop");
            return true;
        }
        return false;
    }
}
