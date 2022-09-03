package com.tadzio.randomtp.listeners;

import com.tadzio.randomtp.RandomTP;
import com.tadzio.randomtp.items.RTPButtonItem;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class PlayerDestroyButtonListener implements Listener {

    @EventHandler
    private void onPlayerDestroyButton(BlockBreakEvent e){
        if(!e.getBlock().getType().equals(RTPButtonItem.getButton().getType())){
            return;
        }

        RandomTP.buttonsLocations.removeIf(rtpButton -> e.getBlock().getLocation().equals(rtpButton.getButtonLocation()));
        e.getPlayer().sendMessage(ChatColor.GREEN + "Random teleport has been removed");
    }
}
