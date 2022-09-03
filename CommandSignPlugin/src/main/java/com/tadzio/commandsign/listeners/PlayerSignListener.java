package com.tadzio.commandsign.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class PlayerSignListener implements Listener {

    @EventHandler
    private void onSignPlace(SignChangeEvent e){
        if(e.getLine(0).equalsIgnoreCase("[CMD]")){
            if(e.getLine(1) != null){
                if(e.getPlayer().hasPermission("sign.*") || e.getPlayer().hasPermission("sign.set")){
                    e.setLine(0, ChatColor.DARK_BLUE + "[CMD]");
                }
            }
        }
    }
}
