package com.tadzio.clickablemessage;

import com.tadzio.clickablemessage.listeners.PlayerJoinListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class ClickableMessage extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
    }
}
