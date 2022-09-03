package com.tadzio.magictools.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Arrow;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerClickMouseListener implements Listener {

    @EventHandler
    private void onPlayerRightClick(PlayerInteractEvent e){
        if(!e.getPlayer().hasPermission("magictools.*") || !e.getPlayer().hasPermission("magictools.use.shootsword")){
            e.getPlayer().sendMessage(ChatColor.RED + "You don't have permission");
            return;
        }

        if(e.getItem() != null && e.getItem().getItemMeta() != null){
            if(e.getItem().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "Shoot Sword")){
                e.getPlayer().launchProjectile(Arrow.class);
            }
        }
    }
}
