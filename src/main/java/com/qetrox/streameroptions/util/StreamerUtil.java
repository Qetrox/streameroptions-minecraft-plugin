package com.qetrox.streameroptions.util;

import com.qetrox.streameroptions.StreamerOptions;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class StreamerUtil {

    public static Plugin plugin = StreamerOptions.getPlugin(StreamerOptions.class);

    /**
     * Get the list of streamers from the config
     * @return List of streamers
     */
    public static List<String> getStreamers() {
        return plugin.getConfig().getStringList("streamer_uuids");
    }

}
