package com.qetrox.streameroptions.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static com.qetrox.streameroptions.util.StreamerUtil.plugin;

public class SOGiveEffectDarknessEvent {
    /**
     * Give the player darkness
     * @param p Streamer
     * @param eventRedeemedBy Name of who redeemed the event
     */
    public static void response (Player p, String eventRedeemedBy){
        Bukkit.getScheduler().runTask(plugin, new Runnable() {
            @Override
            public void run() {
                p.addPotionEffect(new PotionEffect(PotionEffectType.DARKNESS, 100, 2));
                p.sendMessage(ChatColor.LIGHT_PURPLE + "[Streamer Options] " + ChatColor.GOLD + eventRedeemedBy + ChatColor.WHITE + " has activated " + ChatColor.GOLD + "Give Darkness");

            }
        });
    }
}
