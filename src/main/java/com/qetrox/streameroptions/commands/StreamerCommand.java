package com.qetrox.streameroptions.commands;

import com.qetrox.streameroptions.StreamerOptions;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.List;


public class StreamerCommand implements CommandExecutor {

    public static Plugin plugin = StreamerOptions.getPlugin(StreamerOptions.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length == 0) {
            sender.sendMessage("/streamer <add | remove | list> [player]");
            return true;
        } else
        if(args.length == 1) {
            if(args[0].equals("add")) {
                sender.sendMessage("/streamer <add | remove | list> [player]");
                return true;
            }
            if(args[0].equals("remove")) {
                sender.sendMessage("/streamer <add | remove | list> [player]");
                return true;
            }
            if(args[0].equals("list")) {
                sender.sendMessage(ChatColor.LIGHT_PURPLE + "[Streamer Options] " + ChatColor.WHITE + "Streamers:");
                for (String s : plugin.getConfig().getStringList("streamer_uuids") ) {
                    sender.sendMessage("- " + ChatColor.GOLD + Bukkit.getOfflinePlayer(java.util.UUID.fromString(s)).getName());
                }
                return true;
            }
        } else
        if(args.length == 2) {
            if(args[0].equals("add")) {
                if(sender.hasPermission("streameroptions.changestreamer")) {

                    Player p = Bukkit.getPlayer(args[1]);
                    if(p == null) {
                        sender.sendMessage(ChatColor.LIGHT_PURPLE + "[Streamer Options] " + ChatColor.WHITE + "Player not found.");
                        return true;
                    }

                    List<String> streamers = plugin.getConfig().getStringList("streamer_uuids");
                    if(streamers.contains(p.getUniqueId().toString())) {
                        sender.sendMessage(ChatColor.LIGHT_PURPLE + "[Streamer Options] " + ChatColor.WHITE + "Player is already a streamer.");
                        return true;
                    }
                    streamers.add(p.getUniqueId().toString());
                    plugin.getConfig().set("streamer_uuids", streamers);
                    plugin.saveConfig();
                    sender.sendMessage(ChatColor.LIGHT_PURPLE + "[Streamer Options] " + ChatColor.WHITE + "Added " + args[1] + " to streamers.");
                } else {
                    sender.sendMessage(ChatColor.LIGHT_PURPLE + "[Streamer Options] " + ChatColor.WHITE + "You don't have permission to do that.");
                }
                return true;
            }
            if(args[0].equals("remove")) {
                if(sender.hasPermission("streameroptions.changestreamer")) {

                    Player p = Bukkit.getPlayer(args[1]);
                    if(p == null) {
                        sender.sendMessage(ChatColor.LIGHT_PURPLE + "[Streamer Options] " + ChatColor.WHITE + "Player not found.");
                        return true;
                    }

                    List<String> streamers = plugin.getConfig().getStringList("streamer_uuids");

                    if(!streamers.contains(p.getUniqueId().toString())) {
                        sender.sendMessage(ChatColor.LIGHT_PURPLE + "[Streamer Options] " + ChatColor.WHITE + "Player is not a streamer.");
                        return true;
                    }

                    streamers.remove(p.getUniqueId().toString());
                    plugin.getConfig().set("streamer_uuids", streamers);
                    plugin.saveConfig();
                    sender.sendMessage(ChatColor.LIGHT_PURPLE + "[Streamer Options] " + ChatColor.WHITE + "Removed " + args[1] + " from streamers.");
                } else {
                    sender.sendMessage(ChatColor.LIGHT_PURPLE + "[Streamer Options] " + ChatColor.WHITE + "You don't have permission to do that.");
                }
                return true;
            }
            if(args[0].equals("list")) {
                sender.sendMessage(ChatColor.LIGHT_PURPLE + "[Streamer Options] " + ChatColor.WHITE + "Streamers:");
                for (String s : plugin.getConfig().getStringList("streamer_uuids") ) {
                    sender.sendMessage("- " + ChatColor.GOLD + Bukkit.getOfflinePlayer(java.util.UUID.fromString(s)).getName());
                }
                return true;
            }
        } else {
            sender.sendMessage("/streamer <add | remove | list> [player]");
            return true;
        }

        return true;
    }
}
