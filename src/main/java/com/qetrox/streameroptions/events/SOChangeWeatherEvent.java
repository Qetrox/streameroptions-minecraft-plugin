package com.qetrox.streameroptions.events;

import com.qetrox.streameroptions.SO.SOWeatherType;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;

import static com.qetrox.streameroptions.util.StreamerUtil.plugin;

public class SOChangeWeatherEvent {

    /**
     * Change the weather in the world
     * @param p Streamer
     * @param eventRedeemedBy Name of who redeemed the event
     * @param weatherType Type of weather
     */
    public static void response(Player p, String eventRedeemedBy, SOWeatherType weatherType) {
        Bukkit.getScheduler().runTask(plugin, new Runnable() {

            String weatherString = "Clear";

            @Override
            public void run() {
                World world = p.getWorld();
                if(weatherType == SOWeatherType.CLEAR) {
                    world.setStorm(false);
                    world.setThundering(false);
                    weatherString = "Clear";
                }
                if(weatherType == SOWeatherType.RAIN) {
                    world.setStorm(true);
                    world.setThundering(false);
                    weatherString = "Raining";
                }
                if(weatherType == SOWeatherType.STORM) {
                    world.setStorm(true);
                    world.setThundering(true);
                    weatherString = "Storming";
                }

                p.sendMessage(ChatColor.LIGHT_PURPLE + "[Streamer Options] " + ChatColor.GOLD + eventRedeemedBy + ChatColor.WHITE + " has changed the weather to " + ChatColor.GOLD + weatherString);
            }
        });
    }

}