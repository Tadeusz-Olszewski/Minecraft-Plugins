package com.tadzio.home.commands;

import com.tadzio.home.Home;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class SethomeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage(ChatColor.RED + "You must be a player !");
            return false;
        }

        if(command.getName().equalsIgnoreCase("sethome")){
            if(!sender.hasPermission("home.sethome") || !sender.hasPermission("home.*")){
                sender.sendMessage(ChatColor.RED + "You don't have permission !");
                return false;
            }

            if(args.length != 0){
                sender.sendMessage(ChatColor.RED + "Wrong usage");
                return false;
            }

            String UUID = ((Player) sender).getUniqueId().toString();

            File playerConfigFile = new File(Home.path + UUID + ".yml");

            if(!playerConfigFile.exists()){
                try{
                    playerConfigFile.createNewFile();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }

            YamlConfiguration playerConfig = YamlConfiguration.loadConfiguration(playerConfigFile);

            Location location = ((Player) sender).getLocation();

            playerConfig.set("yaw", location.getYaw());
            playerConfig.set("pitch", location.getPitch());
            playerConfig.set("x", location.getX());
            playerConfig.set("y", location.getY());
            playerConfig.set("z", location.getZ());
            playerConfig.set("world", location.getWorld().getName());

            try{
                playerConfig.save(playerConfigFile);
            } catch (IOException e){
                e.printStackTrace();
            }

            sender.sendMessage(ChatColor.GREEN + "Home have been set");
            return true;
        }

        return false;
    }
}
