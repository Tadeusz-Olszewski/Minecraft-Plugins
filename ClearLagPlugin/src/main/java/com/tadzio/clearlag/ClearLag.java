package com.tadzio.clearlag;

import com.tadzio.clearlag.tasks.CLTask;
import org.bukkit.plugin.java.JavaPlugin;

public final class ClearLag extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        CLTask clTask = new CLTask();
        clTask.runTimer();
    }
}
