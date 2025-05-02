package com.qetrox.streameroptions.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;

import static com.qetrox.streameroptions.util.StreamerUtil.plugin;

public class SOWhitelistAddEvent {

    /** Add a player to the whitelist
     * @param playerName Name of the player to add to the whitelist
     * @param eventRedeemedBy Name of who redeemed the event
     */
    public static void response (String playerName, String eventRedeemedBy){
        Bukkit.getScheduler().runTask(plugin, new Runnable() {
            @Override
            public void run() {
                try {
                    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "minecraft:whitelist add " + playerName);
                    if (plugin.getConfig().getBoolean("announce_whitelisted_player")) {
                        Bukkit.getServer().broadcastMessage(ChatColor.LIGHT_PURPLE + "[Streamer Options] " + ChatColor.GOLD + eventRedeemedBy + ChatColor.WHITE + " has added " + ChatColor.GOLD + playerName + ChatColor.WHITE + " to the whitelist.");
                    } else {
                        Bukkit.getServer().broadcastMessage(ChatColor.LIGHT_PURPLE + "[Streamer Options] " + ChatColor.GOLD + eventRedeemedBy + ChatColor.WHITE + " has added someone to the whitelist.");
                    }
                } catch (Exception ignored) {}
            }
        });
    }
}
