package com.tadzio.customcrafting.recipes;

import com.tadzio.customcrafting.CustomCrafting;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class PickaxeRecipes {

    private final CustomCrafting plugin = CustomCrafting.getPlugin(CustomCrafting.class);

    public void customPickaxeCrafting(){
        ItemStack diamondPickaxe = new ItemStack(Material.DIAMOND_PICKAXE);

        ItemMeta diamondPickaxeMeta = diamondPickaxe.getItemMeta();
        diamondPickaxeMeta.setDisplayName(ChatColor.GOLD + "SUPER PICKAXE !!!");
        diamondPickaxeMeta.addEnchant(Enchantment.DIG_SPEED, 10, true);
        diamondPickaxe.setItemMeta(diamondPickaxeMeta);

        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(plugin, "Super_pickaxe"), diamondPickaxe);

        recipe.shape(
                " O ",
                "OPO",
                " O "
        );

        recipe.setIngredient('O', Material.OBSIDIAN);
        recipe.setIngredient('P', Material.DIAMOND_PICKAXE);

        Bukkit.addRecipe(recipe);
    }

}
