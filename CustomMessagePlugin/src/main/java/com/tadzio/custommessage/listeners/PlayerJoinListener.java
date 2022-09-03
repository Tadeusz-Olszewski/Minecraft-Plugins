package com.tadzio.custommessage.listeners;

import com.tadzio.custommessage.CustomMessage;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    private final CustomMessage plugin = CustomMessage.getPlugin(CustomMessage.class);

    @EventHandler
    private void onPlayerJoin(PlayerJoinEvent e){
        e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("on-join").replace("{PLAYER}", e.getPlayer().getDisplayName())));
    }
}
