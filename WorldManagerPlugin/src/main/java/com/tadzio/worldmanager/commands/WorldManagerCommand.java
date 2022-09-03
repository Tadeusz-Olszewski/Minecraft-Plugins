package com.tadzio.worldmanager.commands;

import com.tadzio.worldmanager.WorldManager;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.checkerframework.checker.units.qual.C;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class WorldManagerCommand implements CommandExecutor {

    private static final YamlConfiguration config = (YamlConfiguration) WorldManager.getInstance().getConfig();

    private void help(CommandSender sender) {
        sender.sendMessage(ChatColor.GOLD + "================================");
        sender.sendMessage(ChatColor.GREEN + "/wm list - show worlds");
        sender.sendMessage(ChatColor.GREEN + "/wm tp <world name> - teleport to world");
        sender.sendMessage(ChatColor.GREEN + "/wm delete <world name> - delete world");
        sender.sendMessage(ChatColor.GREEN + "/wm create <world name> <world type> - create new world");
        sender.sendMessage(ChatColor.GOLD + "================================");
    }

    private boolean hasPermission(CommandSender sender, String permission) {
        if (sender.hasPermission("wm.*") || sender.hasPermission(permission)) {
            return true;
        }

        sender.sendMessage(ChatColor.RED + "You don't have permission");
        return false;
    }

    private void deleteDir(File file){
        File[] contents = file.listFiles();
        if(contents != null){
            for(File f : contents){
                if(!Files.isSymbolicLink(f.toPath())){
                    deleteDir(f);
                }
            }
        }
        file.delete();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 0) {
            if (!hasPermission(sender, "wm.help")) {
                return false;
            }

            help(sender);
            return false;
        } else if (args.length == 1) {
            if (args[0].equalsIgnoreCase("list")) {
                if (!hasPermission(sender, "wm.list")) {
                    return false;
                }

                sender.sendMessage(ChatColor.GREEN + "Worlds:");
                for (String world : config.getStringList("worlds")) {
                    TextComponent wName = new TextComponent(world);

                    TextComponent teleport = new TextComponent(ChatColor.translateAlternateColorCodes('&', " &7[&a+&7]"));
                    teleport.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(ChatColor.GREEN + "Click to teleport")));
                    teleport.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/wm tp " + world));

                    TextComponent deleteWorld = new TextComponent(ChatColor.translateAlternateColorCodes('&', " &7[&4X&7]"));
                    deleteWorld.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(ChatColor.RED + "Click to delete the world")));
                    deleteWorld.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/wm delete " + world));

                    sender.spigot().sendMessage(wName, teleport, deleteWorld);
                }

                return true;
            }
        } else if (args.length == 2) {
            if (args[0].equalsIgnoreCase("tp")) {
                if(!(sender instanceof Player)){
                    sender.sendMessage(ChatColor.RED + "You must be a player");
                    return false;
                }

                if (!hasPermission(sender, "wm.tp")) {
                    return false;
                }

                String worldName = args[1];

                if (!config.getStringList("worlds").contains(worldName)) {
                    sender.sendMessage(ChatColor.RED + "World " + ChatColor.WHITE + worldName + ChatColor.RED + " isn't exist");
                    return false;
                }

                World world = Bukkit.getWorld(worldName);
                Location locationToTeleport = new Location(world, 0, world.getHighestBlockYAt(0 ,0), 0);

                Player player = (Player) sender;
                player.teleport(locationToTeleport);
                player.sendMessage(ChatColor.GREEN + "Teleported to " + ChatColor.WHITE + worldName);
                return true;
            } else if(args[0].equalsIgnoreCase("delete")){
                if (!hasPermission(sender, "wm.delete")) {
                    return false;
                }

                String worldName = args[1];

                if (!config.getStringList("worlds").contains(worldName)) {
                    sender.sendMessage(ChatColor.RED + "World " + ChatColor.WHITE + worldName + ChatColor.RED + " isn't exist");
                    return false;
                }

                Bukkit.unloadWorld(worldName, false);

                File worldFile = new File(worldName);
                deleteDir(worldFile);

                List<String> worldsList = config.getStringList("worlds");
                worldsList.remove(worldName);

                config.set("worlds", worldsList);
                WorldManager.getInstance().saveConfig();

                sender.sendMessage(ChatColor.GREEN + "World " + ChatColor.WHITE + worldName + ChatColor.GREEN + " has been deleted");
                return true;
            }
        } else if (args.length == 3){
            if(args[0].equalsIgnoreCase("create")){
                if (!hasPermission(sender, "wm.create")) {
                    return false;
                }

                String worldName = args[1];
                String worldType = args[2];

                if(worldName.length() > 16){
                    sender.sendMessage(ChatColor.RED + "Name of the world is too long (Max 16 characters)");
                    return false;
                }

                if (config.getStringList("worlds").contains(worldName)) {
                    sender.sendMessage(ChatColor.RED + "World " + ChatColor.WHITE + worldName + ChatColor.RED + " exist");
                    return false;
                }

                List<String> worldTypes = new ArrayList<>();
                for(WorldType worldTypesFromBukkit : WorldType.values()){
                    worldTypes.add(worldTypesFromBukkit.toString());
                }

                if(!worldTypes.contains(worldType.toUpperCase())){
                    sender.sendMessage(ChatColor.RED + "This world type is not allowed");
                    sender.sendMessage(ChatColor.GREEN + "Allowed world types:");

                    for(String worldTypesAllowed : worldTypes){
                        sender.sendMessage(worldTypesAllowed);
                    }

                    return false;
                }

                try{
                    sender.sendMessage(ChatColor.GREEN + "Generating world...");
                    WorldCreator worldCreator = new WorldCreator(worldName);
                    worldCreator.environment(World.Environment.NORMAL);
                    worldCreator.type(WorldType.valueOf(worldType.toUpperCase()));
                    worldCreator.createWorld();
                } catch (Exception e){
                    sender.sendMessage(ChatColor.RED + "Critical error");
                    e.printStackTrace();
                    return false;
                }

                List<String> worldsList = config.getStringList("worlds");
                worldsList.add(worldName);

                config.set("worlds", worldsList);
                WorldManager.getInstance().saveConfig();

                sender.sendMessage(ChatColor.GREEN + "World " + ChatColor.WHITE + worldName + ChatColor.GREEN + " has been created");
                return true;
            }
        }

        return false;
    }
}
