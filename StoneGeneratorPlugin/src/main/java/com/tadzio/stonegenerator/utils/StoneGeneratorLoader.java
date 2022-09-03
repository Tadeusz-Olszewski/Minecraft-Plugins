package com.tadzio.stonegenerator.utils;

import com.tadzio.stonegenerator.StoneGenerator;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

public class StoneGeneratorLoader {

    private static final YamlConfiguration config = (YamlConfiguration) StoneGenerator.getInstance().getConfig();

    public static void saveGeneratorsToConfig(){
        config.set("stone-generators", null);
        config.createSection("stone-generators");
        for(StoneGeneratorPlaced stoneGeneratorPlaced : StoneGenerator.stoneGenerators){
            String sectionName = "stone-generators" + "." + stoneGeneratorPlaced.getNameOfSectionInConfig();

            config.createSection(sectionName);
            config.getConfigurationSection(sectionName).set("x", stoneGeneratorPlaced.getLocationOfGenerator().getBlockX());
            config.getConfigurationSection(sectionName).set("y", stoneGeneratorPlaced.getLocationOfGenerator().getBlockY());
            config.getConfigurationSection(sectionName).set("z", stoneGeneratorPlaced.getLocationOfGenerator().getBlockZ());
            config.getConfigurationSection(sectionName).set("world", stoneGeneratorPlaced.getLocationOfGenerator().getWorld().getName());
            config.getConfigurationSection(sectionName).set("durability", stoneGeneratorPlaced.getDurability());
        }

        StoneGenerator.getInstance().saveConfig();
    }

    public static void loadGenerators(){
        for(String configSectionName : config.getConfigurationSection("stone-generators").getKeys(false)){
            String sectionName = "stone-generators" + "." + configSectionName;

            int x = config.getConfigurationSection(sectionName).getInt("x");
            int y = config.getConfigurationSection(sectionName).getInt("y");
            int z = config.getConfigurationSection(sectionName).getInt("z");
            String world = config.getConfigurationSection(sectionName).getString("world");
            int durability = config.getConfigurationSection(sectionName).getInt("durability");

            Location generatorLocation = new Location(Bukkit.getWorld(world), x, y, z);
            StoneGeneratorPlaced stoneGeneratorPlaced = new StoneGeneratorPlaced(durability, generatorLocation, sectionName);
            StoneGenerator.stoneGenerators.add(stoneGeneratorPlaced);
        }

        StoneGenerator.getInstance().saveConfig();
    }

}
