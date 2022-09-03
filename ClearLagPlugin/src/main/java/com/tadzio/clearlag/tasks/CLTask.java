package com.tadzio.clearlag.tasks;

import com.tadzio.clearlag.ClearLag;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;

import java.util.List;

public class CLTask {

    ClearLag plugin = ClearLag.getPlugin(ClearLag.class);

    private final int CLEAR_TIME = plugin.getConfig().getInt("clear-time");
    private final String CLEAR_FIRST_MESSAGE = plugin.getConfig().getString("clear-first-message");
    private final String CLEAR_SECOND_MESSAGE = plugin.getConfig().getString("clear-second-message");
    private final String CLEAR_THIRD_MESSAGE = plugin.getConfig().getString("clear-third-message");
    private final String CLEARED_ITEMS_MESSAGE = plugin.getConfig().getString("cleared-items-message");

    private int iteration;
    private int clearedItems;

    World world = plugin.getServer().getWorld("world");

    public void runTimer(){
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
            iteration++;
            switch (CLEAR_TIME - iteration){
                case 15:
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', CLEAR_FIRST_MESSAGE));
                    break;
                case 10:
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', CLEAR_SECOND_MESSAGE));
                    break;
                case 5:
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', CLEAR_THIRD_MESSAGE));
                    break;
                case 0:
                    List<Entity> entityList = world.getEntities();
                    for(Entity current : entityList){
                        if(current instanceof Item){
                            clearedItems++;
                            current.remove();
                        }
                    }
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', CLEARED_ITEMS_MESSAGE).replace("{ITEMS_AMOUNT}", ""+clearedItems));
                    clearedItems = 0;
                    iteration = 0;
                    break;
                default:
                    break;
            }
        }, 0, 20L);
    }
}
