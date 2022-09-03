package com.tadzio.custommessage.listeners;

import com.tadzio.custommessage.CustomMessage;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    private final CustomMessage plugin = CustomMessage.getPlugin(CustomMessage.class);

    @EventHandler
    private void onPlayerQuit(PlayerQuitEvent e){
        e.setQuitMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("on-quit").replace("{PLAYER}", e.getPlayer().getDisplayName())));
    }
}
