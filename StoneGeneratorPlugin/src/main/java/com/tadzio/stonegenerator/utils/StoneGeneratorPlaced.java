package com.tadzio.stonegenerator.utils;


import org.bukkit.Location;

public class StoneGeneratorPlaced {

    private int durability;
    private final Location locationOfGenerator;
    private final String nameOfSectionInConfig;

    public StoneGeneratorPlaced(int durability, Location locationOfGenerator, String nameOfSectionInConfig){
        this.durability = durability;
        this.locationOfGenerator = locationOfGenerator;
        this.nameOfSectionInConfig = nameOfSectionInConfig;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability){
        this.durability = durability;
    }

    public Location getLocationOfGenerator() {
        return locationOfGenerator;
    }

    public String getNameOfSectionInConfig() {
        return nameOfSectionInConfig;
    }
}
