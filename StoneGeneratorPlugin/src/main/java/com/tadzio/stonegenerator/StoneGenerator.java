package com.tadzio.stonegenerator;

import com.tadzio.stonegenerator.listeners.PlayerDestroyGeneratorListener;
import com.tadzio.stonegenerator.listeners.PlayerPlaceGeneratorListener;
import com.tadzio.stonegenerator.recipes.StoneGeneratorRecipe;
import com.tadzio.stonegenerator.tasks.GeneratorTask;
import com.tadzio.stonegenerator.utils.StoneGeneratorLoader;
import com.tadzio.stonegenerator.utils.StoneGeneratorPlaced;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class StoneGenerator extends JavaPlugin {

    private static StoneGenerator instance;

    public static final List<StoneGeneratorPlaced> stoneGenerators = new ArrayList<>();

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        instance = this;
        StoneGeneratorLoader.loadGenerators();
        getServer().getPluginManager().registerEvents(new PlayerDestroyGeneratorListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerPlaceGeneratorListener(), this);
        StoneGeneratorRecipe.createRecipe();
        GeneratorTask.runTimer();
    }

    @Override
    public void onDisable() {
        StoneGeneratorLoader.saveGeneratorsToConfig();
    }

    public static StoneGenerator getInstance(){
        return instance;
    }
}
