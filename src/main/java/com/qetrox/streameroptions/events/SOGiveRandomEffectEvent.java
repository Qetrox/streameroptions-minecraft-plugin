package com.qetrox.streameroptions.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

import static com.qetrox.streameroptions.util.StreamerUtil.plugin;

public class SOGiveRandomEffectEvent {
    /**
     * Give the player a random effect
     * @param p Streamer
     * @param eventRedeemedBy Name of who redeemed the event
     */
    public static void response (Player p, String eventRedeemedBy){
        Bukkit.getScheduler().runTask(plugin, new Runnable() {
            @Override
            public void run() {
                PotionEffectType[] effects = PotionEffectType.values();
                Random random = new Random();
                PotionEffectType randomEffect = effects[random.nextInt(effects.length)];

                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 5));
                p.sendMessage(ChatColor.LIGHT_PURPLE + "[Streamer Options] " + ChatColor.GOLD + eventRedeemedBy + ChatColor.WHITE + " has activated " + ChatColor.GOLD + "Give Random Effect");

            }
        });
    }
}
