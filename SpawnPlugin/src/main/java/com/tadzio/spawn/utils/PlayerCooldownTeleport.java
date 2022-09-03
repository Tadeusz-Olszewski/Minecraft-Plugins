package com.tadzio.spawn.utils;

import org.bukkit.Location;

public class PlayerCooldownTeleport {

    private int cooldownTime;
    private Location locationToTeleport;

    public PlayerCooldownTeleport(int cooldownTime, Location locationToTeleport){
        this.cooldownTime = cooldownTime;
        this.locationToTeleport = locationToTeleport;
    }

    public int getCooldownTime(){
        return cooldownTime;
    }

    public void setCooldownTime(int cooldownTime){
        this.cooldownTime = cooldownTime;
    }

    public Location getLocationToTeleport(){
        return locationToTeleport;
    }
}
