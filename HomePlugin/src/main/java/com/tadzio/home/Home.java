package com.tadzio.home;

import com.tadzio.home.commands.HomeCommand;
import com.tadzio.home.commands.SethomeCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class Home extends JavaPlugin {
    public static String path;
    @Override
    public void onEnable() {
        getCommand("home").setExecutor(new HomeCommand());
        getCommand("sethome").setExecutor(new SethomeCommand());

        path = getDataFolder().toString() + File.separator;
        File configDirectory = new File(path);

        if(!configDirectory.exists()){
            configDirectory.mkdir();
        }
    }
}
