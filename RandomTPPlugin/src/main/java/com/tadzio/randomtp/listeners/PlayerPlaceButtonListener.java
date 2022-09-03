package com.tadzio.randomtp.listeners;

import com.tadzio.randomtp.RandomTP;
import com.tadzio.randomtp.items.RTPButtonItem;
import com.tadzio.randomtp.utils.RTPButton;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlayerPlaceButtonListener implements Listener {

    @EventHandler
    private void onPlayerPlaceStoneButton(BlockPlaceEvent e){
        if(!e.getItemInHand().hasItemMeta()){
            return;
        }

        if(e.getItemInHand().getItemMeta().getDisplayName().equals(RTPButtonItem.getButton().getItemMeta().getDisplayName())){
            Location placeButtonLocation = e.getBlockPlaced().getLocation();
            String nameOfSectionInConfig = System.currentTimeMillis() + "";

            RTPButton rtpButton = new RTPButton(placeButtonLocation, nameOfSectionInConfig);
            RandomTP.buttonsLocations.add(rtpButton);
            e.getPlayer().sendMessage(ChatColor.GREEN + "Random teleport button has been set");
        }
    }
}
