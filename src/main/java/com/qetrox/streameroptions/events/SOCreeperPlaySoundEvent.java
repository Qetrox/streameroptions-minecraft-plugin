package com.qetrox.streameroptions.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import static com.qetrox.streameroptions.util.StreamerUtil.plugin;

public class SOCreeperPlaySoundEvent {
    /**
     * Plays a creeper sound to the player
     * @param p Streamer
     * @param eventRedeemedBy Name of who redeemed the event
     */
    public static void response(Player p, String eventRedeemedBy) {
        p.playSound(p.getLocation(), Sound.ENTITY_CREEPER_PRIMED, 1F, 1F);
        Bukkit.getScheduler().runTaskAsynchronously(plugin, new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    p.sendMessage(ChatColor.LIGHT_PURPLE + "[Streamer Options] " + ChatColor.GOLD + eventRedeemedBy + ChatColor.WHITE + " has activated " + ChatColor.GOLD + "Creeper Scare");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

}
