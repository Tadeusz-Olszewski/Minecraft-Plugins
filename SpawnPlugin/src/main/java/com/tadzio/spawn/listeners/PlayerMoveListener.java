package com.tadzio.spawn.listeners;

import com.tadzio.spawn.tasks.TeleportTask;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.UUID;

public class PlayerMoveListener implements Listener {

    @EventHandler
    private void onPlayerMove(PlayerMoveEvent e){
        for(UUID uuid : TeleportTask.playersToTeleport.keySet()){
            if(e.getPlayer().equals(Bukkit.getPlayer(uuid))){
                TeleportTask.playersToTeleport.remove(uuid);
                TeleportTask.bossBarCooldown.removePlayer(Bukkit.getPlayer(uuid));
                e.getPlayer().sendMessage(ChatColor.RED + "Teleportation aborted");
            }
        }
    }

}
