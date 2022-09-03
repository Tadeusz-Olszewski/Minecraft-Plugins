package com.tadzio.randomtp.utils;

import com.tadzio.randomtp.RandomTP;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

public class RandomTPLoader {

    private static final YamlConfiguration config = (YamlConfiguration) RandomTP.getInstance().getConfig();
    private static final String MAIN_SECTION = "buttons-locations";

    public static void saveToConfig(){
        config.set(MAIN_SECTION, null);
        config.createSection(MAIN_SECTION);

        for(RTPButton rtpButton : RandomTP.buttonsLocations){
            String sectionName = MAIN_SECTION + "." + rtpButton.getNameOfSectionInConfig();
            int x = rtpButton.getButtonLocation().getBlockX();
            int y = rtpButton.getButtonLocation().getBlockY();
            int z = rtpButton.getButtonLocation().getBlockZ();
            String worldName = rtpButton.getButtonLocation().getWorld().getName();

            config.createSection(sectionName);
            config.set(sectionName + "." + "x", x);
            config.set(sectionName + "." + "y", y);
            config.set(sectionName + "." + "z", z);
            config.set(sectionName + "." + "world", worldName);
        }

        RandomTP.getInstance().saveConfig();
    }

    public static void loadFromConfig(){
        for(String sectionName : config.getConfigurationSection(MAIN_SECTION).getKeys(false)){
            int x = config.getInt(MAIN_SECTION + "." + sectionName + "." + "x");
            int y = config.getInt(MAIN_SECTION + "." + sectionName + "." + "y");
            int z = config.getInt(MAIN_SECTION + "." + sectionName + "." + "z");
            String worldName = config.getString(MAIN_SECTION + "." + sectionName + "." + "world");

            if(Bukkit.getWorld(worldName) != null){
                Location buttonLocation = new Location(Bukkit.getWorld(worldName), x, y, z);
                RTPButton rtpButton = new RTPButton(buttonLocation, sectionName);
                RandomTP.buttonsLocations.add(rtpButton);
            }
        }
    }
}
