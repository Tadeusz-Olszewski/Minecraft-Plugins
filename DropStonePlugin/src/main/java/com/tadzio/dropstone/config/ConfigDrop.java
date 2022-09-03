package com.tadzio.dropstone.config;

import com.tadzio.dropstone.DropStone;
import com.tadzio.dropstone.utils.Item;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.ArrayList;
import java.util.List;

public class ConfigDrop {

    private static final List<Item> itemsToDrop = new ArrayList<>();

    public static List<Item> getItemsToDrop(){
        return itemsToDrop;
    }

    public static void loadConfig(){
        YamlConfiguration config = (YamlConfiguration) DropStone.getInstance().getConfig();

        for(String itemFromConfig : config.getKeys(false)){
            int chance = config.getConfigurationSection(itemFromConfig).getInt("chance");
            String message = config.getConfigurationSection(itemFromConfig).getString("message");
            Item item = new Item(chance, itemFromConfig, message);
            itemsToDrop.add(item);
        }
    }
}
