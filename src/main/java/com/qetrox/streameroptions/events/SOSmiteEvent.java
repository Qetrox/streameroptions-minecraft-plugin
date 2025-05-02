package com.qetrox.streameroptions.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import static com.qetrox.streameroptions.util.StreamerUtil.plugin;

public class SOSmiteEvent {

    /** Strike lightning at the player
     * @param p Streamer
     * @param eventRedeemedBy Name of who redeemed the event
     */
    public static void response(Player p, String eventRedeemedBy) {
        Bukkit.getScheduler().runTask(plugin, new Runnable() {
            @Override
            public void run() {
                p.getWorld().spawnEntity(p.getLocation(), EntityType.LIGHTNING);
                p.sendMessage(ChatColor.LIGHT_PURPLE + "[Streamer Options] " + ChatColor.GOLD + eventRedeemedBy + ChatColor.WHITE + " has activated " + ChatColor.GOLD + "Lightning Strike");
            }
        });
    }

}
