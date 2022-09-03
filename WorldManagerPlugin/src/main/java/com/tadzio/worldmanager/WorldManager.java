package com.tadzio.worldmanager;

import com.tadzio.worldmanager.commands.WorldManagerCommand;
import com.tadzio.worldmanager.utils.WorldLoader;
import org.bukkit.plugin.java.JavaPlugin;
public final class WorldManager extends JavaPlugin {

    private static WorldManager instance;

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        instance = this;
        WorldLoader.loadWorlds();
        getCommand("worldmanager").setExecutor(new WorldManagerCommand());
    }

    @Override
    public void onDisable() {
        WorldLoader.unloadWorlds();
    }

    public static WorldManager getInstance(){
        return instance;
    }
}
