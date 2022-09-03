package com.tadzio.magictools;

import com.tadzio.magictools.commands.MagicToolsCommand;
import com.tadzio.magictools.listeners.PlayerClickMouseListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class MagicTools extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("magictools").setExecutor(new MagicToolsCommand());
        Bukkit.getPluginManager().registerEvents(new PlayerClickMouseListener(), this);
    }
}
