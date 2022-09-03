package com.tadzio.chestgui;

import com.tadzio.chestgui.listeners.PlayerClickInventoryListener;
import com.tadzio.chestgui.listeners.PlayerInteractListener;
import com.tadzio.chestgui.listeners.PlayerJoinListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class ChestGUI extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerInteractListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerClickInventoryListener(), this);
    }
}
