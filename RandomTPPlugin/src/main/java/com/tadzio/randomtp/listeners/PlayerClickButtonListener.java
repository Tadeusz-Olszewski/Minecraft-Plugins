package com.tadzio.randomtp.listeners;

import com.tadzio.randomtp.RandomTP;
import com.tadzio.randomtp.items.RTPButtonItem;
import com.tadzio.randomtp.utils.RTPButton;
import com.tadzio.randomtp.utils.RandomTeleport;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerClickButtonListener implements Listener {

    @EventHandler
    private void onPlayerClickStoneButton(PlayerInteractEvent e){
        if(e.getClickedBlock() == null){
            return;
        }

        if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK) && e.getClickedBlock().getType().equals(RTPButtonItem.getButton().getType())){
            for(RTPButton rtpButton : RandomTP.buttonsLocations){
                if(rtpButton.getButtonLocation().equals(e.getClickedBlock().getLocation())){
                    RandomTeleport.teleport(e.getPlayer());
                }
            }
        }
    }
}
