package com.tadzio.helpcommand;

import com.tadzio.helpcommand.commands.HelpCMD;
import org.bukkit.plugin.java.JavaPlugin;

public final class HelpCommand extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("help").setExecutor(new HelpCMD());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
