package com.tadzio.custommessage;

import com.tadzio.custommessage.listeners.PlayerJoinListener;
import com.tadzio.custommessage.listeners.PlayerQuitListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomMessage extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerQuitListener(), this);
    }
}
