package com.qetrox.streameroptions.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import static com.qetrox.streameroptions.util.StreamerUtil.plugin;

public class SORandomTeleportEvent {

    /** Teleport the player to a random location
     * @param p Streamer
     * @param eventRedeemedBy Name of who redeemed the event
     */
    public static void response(Player p, String eventRedeemedBy) {
        Bukkit.getScheduler().runTask(plugin, new Runnable() {
            @Override
            public void run() {
                Location l = p.getLocation();
                l.setX(l.getX() + (Math.random() * 20) - 10);
                l.setY(l.getY() + (Math.random() * 20) - 10);
                if(l.getY() < -60) l.setY(-60); // Prevents the player from falling into the void
                l.setZ(l.getZ() + (Math.random() * 20) - 10);
                p.teleport(l);
                p.sendMessage(ChatColor.LIGHT_PURPLE + "[Streamer Options] " + ChatColor.GOLD + eventRedeemedBy + ChatColor.WHITE + " has activated " + ChatColor.GOLD + "Random Teleport");

            }
        });
    }
}
