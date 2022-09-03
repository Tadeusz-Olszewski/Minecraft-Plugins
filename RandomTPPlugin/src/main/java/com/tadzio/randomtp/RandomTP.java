package com.tadzio.randomtp;

import com.tadzio.randomtp.commands.RandomTPCommand;
import com.tadzio.randomtp.listeners.PlayerClickButtonListener;
import com.tadzio.randomtp.listeners.PlayerDestroyButtonListener;
import com.tadzio.randomtp.listeners.PlayerPlaceButtonListener;
import com.tadzio.randomtp.utils.RTPButton;
import com.tadzio.randomtp.utils.RandomTPLoader;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class RandomTP extends JavaPlugin {

    private static RandomTP instance;
    public static List<RTPButton> buttonsLocations = new ArrayList<>();

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        instance = this;
        RandomTPLoader.loadFromConfig();
        getCommand("rtp").setExecutor(new RandomTPCommand());
        getServer().getPluginManager().registerEvents(new PlayerPlaceButtonListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerDestroyButtonListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerClickButtonListener(), this);
    }

    @Override
    public void onDisable() {
        RandomTPLoader.saveToConfig();
    }

    public static RandomTP getInstance() {
        return instance;
    }
}
