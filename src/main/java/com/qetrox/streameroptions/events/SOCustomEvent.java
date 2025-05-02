package com.qetrox.streameroptions.events;

import com.qetrox.streameroptions.util.StreamerUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginLogger;

import java.util.UUID;

import static com.qetrox.streameroptions.util.StreamerUtil.plugin;

public class SOCustomEvent {
    /**
     * Responds to a custom command event
     * when detecting %streamer% is will execute the command for every streamer, if not it will just run the command.
     *
     * @param command Command to run
     */
    public static void response(String command) {
        if (command.contains("%streamer%")) {
            Bukkit.getScheduler().runTask(plugin, new Runnable() {
                @Override
                public void run() {
                    StreamerUtil.getStreamers().forEach(streamer -> {
                        Player p = Bukkit.getPlayer(UUID.fromString(streamer));
                        if(p != null) {
                            String privCommand = command.replace("%streamer%", p.getName());
                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), privCommand);
                        } else {
                            PluginLogger.getLogger("StreamerOptions").warning("Streamer " + streamer + " is not online. Skipping event.");
                        }
                    });
                }
            });
            } else{
                Bukkit.getScheduler().runTask(plugin, new Runnable() {
                    @Override
                    public void run() {
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), command);
                    }
                });
            }
        }

    }
