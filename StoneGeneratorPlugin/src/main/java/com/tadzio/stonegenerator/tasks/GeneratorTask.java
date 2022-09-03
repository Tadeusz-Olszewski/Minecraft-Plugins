package com.tadzio.stonegenerator.tasks;

import com.tadzio.stonegenerator.StoneGenerator;
import com.tadzio.stonegenerator.utils.StoneGeneratorPlaced;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;

public class GeneratorTask {

    public static void runTimer(){
        Bukkit.getScheduler().scheduleSyncRepeatingTask(StoneGenerator.getInstance(), () -> {
            for(StoneGeneratorPlaced stoneGeneratorPlaced : StoneGenerator.stoneGenerators){
                if(stoneGeneratorPlaced.getDurability() > 50){
                    stoneGeneratorPlaced.getLocationOfGenerator().getBlock().setType(Material.AIR);
                    StoneGenerator.stoneGenerators.remove(stoneGeneratorPlaced);
                    return;
                }

                Location locationToGenerateStone = new Location(
                        stoneGeneratorPlaced.getLocationOfGenerator().getWorld(),
                        stoneGeneratorPlaced.getLocationOfGenerator().getBlockX(),
                        stoneGeneratorPlaced.getLocationOfGenerator().getBlockY() + 1,
                        stoneGeneratorPlaced.getLocationOfGenerator().getBlockZ()
                );

                if(locationToGenerateStone.getBlock().getType().equals(Material.AIR)){
                    locationToGenerateStone.getBlock().setType(Material.STONE);
                    stoneGeneratorPlaced.setDurability(stoneGeneratorPlaced.getDurability() + 1);
                }
            }
        }, 0, 10);
    }

}
