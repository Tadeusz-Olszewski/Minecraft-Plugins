package com.tadzio.worldmanager.utils;

import com.tadzio.worldmanager.WorldManager;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.List;

public class WorldLoader {

    private static final YamlConfiguration config = (YamlConfiguration) WorldManager.getInstance().getConfig();

    public static void loadWorlds(){
        List<String> worldsList = config.getStringList("worlds");

        for(World world : Bukkit.getWorlds()){
            if(!worldsList.contains(world.getName())){
                worldsList.add(world.getName());
            }
        }

        for(String worldName : worldsList){
            if(!Bukkit.getWorlds().contains(Bukkit.getWorld(worldName))){
               new WorldCreator(worldName).createWorld();
            }
        }

        config.set("worlds", worldsList);
        WorldManager.getInstance().saveConfig();
    }

    public static void unloadWorlds(){
        List<String> worldsList = config.getStringList("worlds");

        for(World world : Bukkit.getWorlds()){
            if(!worldsList.contains(world.getName())){
                worldsList.add(world.getName());
            }
        }

        config.set("worlds", worldsList);
        WorldManager.getInstance().saveConfig();
    }
}
