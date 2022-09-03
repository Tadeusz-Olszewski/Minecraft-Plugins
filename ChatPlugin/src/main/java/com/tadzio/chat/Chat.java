package com.tadzio.chat;

import com.tadzio.chat.commands.ChatCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Chat extends JavaPlugin {

    public static boolean chatEnabled = true;

    @Override
    public void onEnable() {
        getCommand("chat").setExecutor(new ChatCommand());
    }
}
