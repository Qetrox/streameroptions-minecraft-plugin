package com.qetrox.streameroptions;

import com.qetrox.streameroptions.commands.StreamerCommand;
import com.qetrox.streameroptions.commands.StreamerTabCompleter;
import com.qetrox.streameroptions.util.SSEUtil;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Logger;

public final class StreamerOptions extends JavaPlugin {

    Plugin plugin = this;

    /**
     * Called when the plugin is enabled.
     */
    @Override
    public void onEnable() {

        Logger logger = getLogger();

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        if(!plugin.getConfig().getBoolean("enabled")) {
            logger.info("Streamer Options is disabled in config.yml. Disabling plugin...");
            Bukkit.getPluginManager().disablePlugin(plugin);
            return;
        }

        Bukkit.getScheduler().runTaskAsynchronously(plugin, new Runnable() {
            @Override
            public void run() {
                try {
                    SSEUtil.receiveEvents();
                } catch (URISyntaxException | IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        getCommand("streamer").setExecutor(new StreamerCommand());
        getCommand("streamer").setTabCompleter(new StreamerTabCompleter());
    }

    /**
     *
     */
    @Override
    public void onDisable() {
        SSEUtil.stopLoop();
    }
}
