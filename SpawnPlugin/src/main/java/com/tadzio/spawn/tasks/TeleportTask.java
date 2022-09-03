package com.tadzio.spawn.tasks;

import com.tadzio.spawn.Spawn;
import com.tadzio.spawn.utils.PlayerCooldownTeleport;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class TeleportTask {

    Spawn plugin = Spawn.getPlugin(Spawn.class);

    public static HashMap<UUID, PlayerCooldownTeleport> playersToTeleport = new HashMap<>();

    public static BossBar bossBarCooldown = Bukkit.createBossBar(
            "DON'T MOVE",
            BarColor.RED,
            BarStyle.SOLID
    );

    public void runTimer(){
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
           for(UUID uuid : playersToTeleport.keySet()){
               int cooldownTime;

               cooldownTime = playersToTeleport.get(uuid).getCooldownTime();

               playersToTeleport.get(uuid).setCooldownTime(cooldownTime - 1);

               cooldownTime = playersToTeleport.get(uuid).getCooldownTime();

               bossBarCooldown.setProgress((float) cooldownTime / 5);
               Player player = Bukkit.getPlayer(uuid);
               bossBarCooldown.addPlayer(player);

               if(playersToTeleport.get(uuid).getCooldownTime() == 0){
                   Location spawnLocation = playersToTeleport.get(uuid).getLocationToTeleport();
                   player.teleport(spawnLocation);
                   playersToTeleport.remove(uuid);
                   bossBarCooldown.removePlayer(player);
                   player.sendMessage(ChatColor.GREEN + "Teleported to spawn");
               }
           }
        }, 0, 20L);
    }
}
