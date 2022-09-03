package com.tadzio.dropstone;

import com.tadzio.dropstone.config.ConfigDrop;
import com.tadzio.dropstone.listeners.PlayerMiningListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class DropStone extends JavaPlugin {

    private static DropStone instance;

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        instance = this;
        getServer().getPluginManager().registerEvents(new PlayerMiningListener(), this);
        ConfigDrop.loadConfig();
    }

    public static DropStone getInstance(){
        return instance;
    }
}
