package com.tadzio.stonegenerator.listeners;

import com.tadzio.stonegenerator.StoneGenerator;
import com.tadzio.stonegenerator.utils.StoneGeneratorPlaced;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class PlayerDestroyGeneratorListener implements Listener {

    @EventHandler
    private void onPlayerDestroyGenerator(BlockBreakEvent e){
        if(e.getBlock().getType().equals(Material.END_STONE)){
            Location destroyBlockLocation = e.getBlock().getLocation();

            for(StoneGeneratorPlaced stoneGeneratorPlaced : StoneGenerator.stoneGenerators){
                if(stoneGeneratorPlaced.getLocationOfGenerator().equals(destroyBlockLocation)){
                    StoneGenerator.stoneGenerators.remove(stoneGeneratorPlaced);
                    e.getPlayer().sendMessage(ChatColor.GREEN + "Generator has been destroyed");
                    break;
                }
            }
        }
    }
}
