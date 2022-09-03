package com.tadzio.spawn;

import com.tadzio.spawn.commands.SpawnCommand;
import com.tadzio.spawn.listeners.PlayerMoveListener;
import com.tadzio.spawn.tasks.TeleportTask;
import org.bukkit.plugin.java.JavaPlugin;

public final class Spawn extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("spawn").setExecutor(new SpawnCommand());

        getServer().getPluginManager().registerEvents(new PlayerMoveListener(), this);

        TeleportTask teleport = new TeleportTask();
        teleport.runTimer();
    }
}
