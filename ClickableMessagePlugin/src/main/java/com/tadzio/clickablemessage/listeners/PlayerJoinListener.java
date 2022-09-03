package com.tadzio.clickablemessage.listeners;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    private void onPlayerJoin(PlayerJoinEvent e){
        TextComponent healText = new TextComponent(ChatColor.GREEN + "Click to heal");
        healText.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/heal"));
        healText.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("if you click this chat message your health have been restored")));
        e.getPlayer().spigot().sendMessage(healText);
    }
}
