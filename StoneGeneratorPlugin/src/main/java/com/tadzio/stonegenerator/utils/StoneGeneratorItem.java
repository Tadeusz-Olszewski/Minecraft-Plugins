package com.tadzio.stonegenerator.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class StoneGeneratorItem {

    public static ItemStack stoneGenerator(){
        ItemStack endStone = new ItemStack(Material.END_STONE);
        ItemMeta endStoneMeta = endStone.getItemMeta();

        endStoneMeta.setDisplayName(ChatColor.DARK_AQUA + "Stone Generator");

        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.DARK_PURPLE + "After placing the block it automatically starts working");

        endStoneMeta.setLore(lore);
        endStone.setItemMeta(endStoneMeta);

        return endStone;
    }

}
