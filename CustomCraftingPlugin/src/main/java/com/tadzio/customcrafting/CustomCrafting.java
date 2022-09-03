package com.tadzio.customcrafting;

import com.tadzio.customcrafting.recipes.PickaxeRecipes;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomCrafting extends JavaPlugin {

    @Override
    public void onEnable() {

        PickaxeRecipes pickaxeRecipes = new PickaxeRecipes();
        pickaxeRecipes.customPickaxeCrafting();

    }
}
