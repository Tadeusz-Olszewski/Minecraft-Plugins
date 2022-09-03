package com.tadzio.commandsign.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerClickListener implements Listener {

    @EventHandler
    private void onPlayerClickSign(PlayerInteractEvent e){
        if(!e.getPlayer().hasPermission("sign.*") || !e.getPlayer().hasPermission("sign.use")){
            return;
        }

        if(e.getClickedBlock() == null){
            return;
        }

        if(e.getClickedBlock().getType() == Material.OAK_SIGN || e.getClickedBlock().getType() == Material.OAK_WALL_SIGN){
            if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
                Sign sign = (Sign) e.getClickedBlock().getState();
                if(sign.getLine(0).equalsIgnoreCase(ChatColor.DARK_BLUE + "[CMD]")){
                    e.getPlayer().chat("/"+sign.getLine(1));
                }
            }
        }
    }
}
