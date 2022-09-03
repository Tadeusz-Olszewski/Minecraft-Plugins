package com.tadzio.commandsign;

import com.tadzio.commandsign.listeners.PlayerClickListener;
import com.tadzio.commandsign.listeners.PlayerSignListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class CommandSign extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerSignListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerClickListener(), this);
    }
}
