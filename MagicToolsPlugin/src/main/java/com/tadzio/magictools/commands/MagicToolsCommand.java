package com.tadzio.magictools.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class MagicToolsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage(ChatColor.RED + "Only players are allowed to use this command");
            return false;
        }

        if(args.length == 1){
            if(args[0].equalsIgnoreCase("shootsword")){
                if(!sender.hasPermission("magictools.give") || !sender.hasPermission("magictools.*")){
                    sender.sendMessage(ChatColor.RED + "You don't have permission to use this command");
                    return false;
                }

                ItemStack itemStack = new ItemStack(Material.DIAMOND_SWORD);
                ItemMeta itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.BLUE + "Shoot Sword");
                List<String> lore = new ArrayList<>();
                lore.add(ChatColor.GREEN + "Right click mouse button to shoot arrow");
                itemMeta.setLore(lore);
                itemStack.setItemMeta(itemMeta);
                ((Player) sender).getInventory().addItem(itemStack);
                sender.sendMessage(ChatColor.GREEN + "You've got your item");
                return true;
            } else {
                sender.sendMessage(ChatColor.RED + "Wrong argument");
                return false;
            }
        } else {
            sender.sendMessage(ChatColor.GREEN + "/magictools shootsword");
            return false;
        }
    }
}
