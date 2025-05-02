package com.qetrox.streameroptions.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;
import java.util.Random;

import static com.qetrox.streameroptions.util.StreamerUtil.plugin;

public class SOFireworkSpawnEvent {

    /**
     * Spawn a firework show (1-10 fireworks)
     * @param p Streamer
     * @param eventRedeemedBy Name of who redeemed the event
     */
    public static void response(Player p, String eventRedeemedBy) {
        Bukkit.getScheduler().runTask(plugin, new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < Math.round(Math.random() * 9) + 1; i++) {

                    FireworkEffect.Type[] types = FireworkEffect.Type.values();
                    Random random = new Random();
                    FireworkEffect.Type randomType = types[random.nextInt(types.length)];

                    Firework fw = (Firework) p.getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
                    FireworkMeta fwm = fw.getFireworkMeta();
                    fwm.addEffect(FireworkEffect.builder()
                            .flicker(false)
                            .trail(true)
                            .with(randomType)
                            .withColor(
                                    Color.fromRGB(
                                            (int) Math.round(Math.random() * 255),
                                            (int) Math.round(Math.random() * 255),
                                            (int) Math.round(Math.random() * 255)
                                    )
                            )
                            .withFade(
                                    Color.fromRGB(
                                            (int) Math.round(Math.random() * 255),
                                            (int) Math.round(Math.random() * 255),
                                            (int) Math.round(Math.random() * 255)
                                    )
                            )
                            .build()
                    );
                    fwm.setPower(1 + (int) Math.round(Math.random() * 2));
                    fw.setFireworkMeta(fwm);
                }
                p.sendMessage(ChatColor.LIGHT_PURPLE + "[Streamer Options] " + ChatColor.GOLD + eventRedeemedBy + ChatColor.WHITE + " has activated " + ChatColor.GOLD + "Firework Show");
            }
        });
    }

}
