package com.qetrox.streameroptions.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Random;
import java.util.UUID;

import static com.qetrox.streameroptions.util.StreamerUtil.plugin;

public class SORandomHotbarItemDropEvent {

    /**
     * Drop a random item from the streamer's hotbar
     * @param p Streamer
     * @param eventRedeemedBy Name of who redeemed the event
     */
    public static void response(Player p, String eventRedeemedBy) {
        Bukkit.getScheduler().runTask(plugin, new Runnable() {
            @Override
            public void run() {
                Random rand = new Random();
                int dropslot = rand.nextInt(9);
                ItemStack item = p.getInventory().getItem(dropslot);
                if (item == null) return;
                p.getWorld().dropItemNaturally(p.getLocation().add(p.getLocation().getDirection()), item);
                p.getInventory().setItem(dropslot, null);
                p.sendMessage(ChatColor.LIGHT_PURPLE + "[Streamer Options] " + ChatColor.GOLD + eventRedeemedBy + ChatColor.WHITE + " has activated " + ChatColor.GOLD + "Drop Item");
            }
        });
    }
}
