package com.tadzio.heal;

import com.tadzio.heal.commands.HealCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Heal extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("heal").setExecutor(new HealCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
