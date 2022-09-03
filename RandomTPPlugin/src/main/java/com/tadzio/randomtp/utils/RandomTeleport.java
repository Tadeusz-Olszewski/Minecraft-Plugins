package com.tadzio.randomtp.utils;

import com.tadzio.randomtp.RandomTP;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;

import java.util.Random;

public class RandomTeleport {

    private static final int MAX_X = RandomTP.getInstance().getConfig().getInt("max_x");
    private static final int MAX_Z = RandomTP.getInstance().getConfig().getInt("max_z");

    public static void teleport(Player player){
        Random random = new Random();

        int randomX = random.nextInt(MAX_X);
        int randomZ = random.nextInt(MAX_Z);

        World world = Bukkit.getWorld(player.getWorld().getName());
        int randomY = world.getHighestBlockYAt(randomX, randomZ);
        Location randomLocation = new Location(world, randomX, randomY, randomZ);

        Biome biome = randomLocation.getBlock().getBiome();

        if(biome == Biome.OCEAN || biome == Biome.RIVER || biome == Biome.DEEP_OCEAN || biome == Biome.LUKEWARM_OCEAN){
            teleport(player);
        }

        player.teleport(randomLocation);
        player.sendMessage(ChatColor.GREEN + "Teleported");



    }

}
