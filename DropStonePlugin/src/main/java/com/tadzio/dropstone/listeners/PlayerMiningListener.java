package com.tadzio.dropstone.listeners;

import com.tadzio.dropstone.utils.DropRandomItem;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class PlayerMiningListener implements Listener {

    @EventHandler
    private void onPlayerMiningStone(BlockBreakEvent e){
        if(e.getBlock().getType() == Material.STONE){
            DropRandomItem.dropItem(e.getPlayer());
        }
    }
}
