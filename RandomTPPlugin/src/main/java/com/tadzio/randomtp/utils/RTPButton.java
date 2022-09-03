package com.tadzio.randomtp.utils;

import org.bukkit.Location;

public class RTPButton {

    private Location buttonLocation;
    private String nameOfSectionInConfig;

    public RTPButton(Location buttonLocation, String nameOfSectionInConfig){
        this.buttonLocation = buttonLocation;
        this.nameOfSectionInConfig = nameOfSectionInConfig;
    }

    public String getNameOfSectionInConfig() {
        return nameOfSectionInConfig;
    }

    public Location getButtonLocation() {
        return buttonLocation;
    }
}
