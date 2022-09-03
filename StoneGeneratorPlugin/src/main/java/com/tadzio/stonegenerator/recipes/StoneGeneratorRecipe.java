package com.tadzio.stonegenerator.recipes;

import com.tadzio.stonegenerator.StoneGenerator;
import com.tadzio.stonegenerator.utils.StoneGeneratorItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;

public class StoneGeneratorRecipe {

    public static void createRecipe(){
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(StoneGenerator.getInstance(), "stone_generator"),  StoneGeneratorItem.stoneGenerator());

        recipe.shape(
                "SSS",
                "SES",
                "SSS"
        );

        recipe.setIngredient('S', Material.STONE);
        recipe.setIngredient('E', Material.ENDER_PEARL);

        Bukkit.addRecipe(recipe);
    }

}
