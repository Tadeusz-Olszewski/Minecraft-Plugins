package com.tadzio.spawn.commands;

import com.tadzio.spawn.tasks.TeleportTask;
import com.tadzio.spawn.utils.PlayerCooldownTeleport;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)){
            sender.sendMessage(ChatColor.RED + "You must be a player !");
            return false;
        }

        if(!sender.hasPermission("spawn.teleport") || !sender.hasPermission("spawn.*")){
            sender.sendMessage(ChatColor.RED + "You don't have permission");
            return false;
        }

        if(args.length != 0){
            sender.sendMessage(ChatColor.RED + "Usage: /spawn");
            return false;
        }

        Player player = (Player) sender;

        Location spawnLocation = new Location(player.getWorld(), 0, 80, 0);
        PlayerCooldownTeleport playerCooldownTeleport = new PlayerCooldownTeleport(5, spawnLocation);

        TeleportTask.playersToTeleport.put(player.getUniqueId(), playerCooldownTeleport);
        player.sendMessage(ChatColor.GREEN + "Teleport to spawn in 5 seconds");

        return true;
    }
}
