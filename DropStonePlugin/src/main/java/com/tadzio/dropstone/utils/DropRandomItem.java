package com.tadzio.dropstone.utils;

import com.tadzio.dropstone.config.ConfigDrop;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class DropRandomItem {

    private static int generate(){
        Random random = new Random();

        return random.nextInt(100) + 1;
    }

    public static void dropItem(Player player){
        int chance = generate();

        for(Item item : ConfigDrop.getItemsToDrop()){
            int chanceOnDrop = item.getChance();
            if(chanceOnDrop >= chance){
                player.getLocation().getWorld().dropItemNaturally(player.getLocation(), new ItemStack(Material.valueOf(item.getMaterial())));
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', item.getMessage()));
            }
        }
    }

}
