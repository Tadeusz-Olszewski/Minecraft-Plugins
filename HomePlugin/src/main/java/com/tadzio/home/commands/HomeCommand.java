package com.tadzio.home.commands;

import com.tadzio.home.Home;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class HomeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage(ChatColor.RED + "You must be a player !");
            return false;
        }

        if(command.getName().equalsIgnoreCase("home")){
            if(!sender.hasPermission("home.teleport") || !sender.hasPermission("home.*")){
                sender.sendMessage(ChatColor.RED + "You don't have permission !");
                return false;
            }

            if(args.length != 0){
                sender.sendMessage(ChatColor.RED + "Wrong usage");
                return false;
            }

            Player player = ((Player) sender);

            String UUID = player.getUniqueId().toString();

            File playerConfigFile = new File(Home.path + UUID + ".yml");

            if(!playerConfigFile.exists()){
                sender.sendMessage(ChatColor.RED + "You don't have a home");
                return false;
            }

            YamlConfiguration playerConfig = YamlConfiguration.loadConfiguration(playerConfigFile);

            double yaw = playerConfig.getDouble("yaw");
            double pitch = playerConfig.getDouble("pitch");

            int x = playerConfig.getInt("x");
            int y = playerConfig.getInt("y");
            int z = playerConfig.getInt("z");

            String worldName = playerConfig.getString("world");
            World world = Bukkit.getWorld(worldName);

            Location playerHomeLocation = new Location(world, x, y, z, (float) yaw, (float) pitch);
            player.teleport(playerHomeLocation);
            player.sendMessage(ChatColor.GREEN + "Teleported to home");

            return true;
        }
        return false;
    }
}
