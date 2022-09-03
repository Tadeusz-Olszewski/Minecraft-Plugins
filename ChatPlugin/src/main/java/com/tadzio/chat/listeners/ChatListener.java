package com.tadzio.chat.listeners;

import com.tadzio.chat.Chat;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    private void onMessageSend(AsyncPlayerChatEvent e){
        if(!Chat.chatEnabled){
            if(!e.getPlayer().hasPermission("chat.*") || !e.getPlayer().hasPermission("chat.bypass")){
                e.getPlayer().sendMessage(ChatColor.RED + "Chat is disabled !");
                e.setCancelled(true);
            }
        }
    }

}
