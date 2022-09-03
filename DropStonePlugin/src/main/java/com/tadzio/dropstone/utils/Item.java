package com.tadzio.dropstone.utils;

public class Item {

    private final int chance;
    private final String material;
    private final String message;

    public Item(int chance, String material, String message){
        this.chance = chance;
        this.material = material;
        this.message = message;
    }

    public int getChance() {
        return chance;
    }

    public String getMessage() {
        return message;
    }

    public String getMaterial() {
        return material;
    }
}
