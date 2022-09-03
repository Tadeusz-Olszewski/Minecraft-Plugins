package com.tadzio.randomtp.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class RTPButtonItem {

    public static ItemStack getButton(){
        ItemStack stoneButton = new ItemStack(Material.STONE_BUTTON);
        ItemMeta stoneButtonMeta = stoneButton.getItemMeta();

        stoneButtonMeta.setDisplayName(ChatColor.DARK_AQUA + "RTP Button");
        stoneButton.setItemMeta(stoneButtonMeta);

        return stoneButton;
    }

}
