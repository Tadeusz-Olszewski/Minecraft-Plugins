package com.tadzio.stonegenerator.listeners;

import com.tadzio.stonegenerator.StoneGenerator;
import com.tadzio.stonegenerator.utils.StoneGeneratorItem;
import com.tadzio.stonegenerator.utils.StoneGeneratorPlaced;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlayerPlaceGeneratorListener implements Listener {

    @EventHandler
    private void onPlayerPlaceGenerator(BlockPlaceEvent e){
        if(!e.getItemInHand().hasItemMeta()){
            return;
        }

        if(e.getItemInHand().getItemMeta().getDisplayName().equals(StoneGeneratorItem.stoneGenerator().getItemMeta().getDisplayName())){
            Location placedGeneratorLocation = e.getBlockPlaced().getLocation();
            String configSectionName = System.currentTimeMillis() + "";

            StoneGeneratorPlaced stoneGeneratorPlaced = new StoneGeneratorPlaced(0, placedGeneratorLocation, configSectionName);
            StoneGenerator.stoneGenerators.add(stoneGeneratorPlaced);

            e.getPlayer().sendMessage(ChatColor.GREEN + "Generator has been created");
        }
    }

}
