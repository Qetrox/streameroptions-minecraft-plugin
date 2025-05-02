package com.qetrox.streameroptions.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.qetrox.streameroptions.SO.SOEvent;
import com.qetrox.streameroptions.SO.SOEventType;
import com.qetrox.streameroptions.SO.SOWeatherType;
import com.qetrox.streameroptions.events.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginLogger;

import java.util.Objects;
import java.util.UUID;

public class EventUtil {

    /**
     * Responds to events received from the Streamer Options servers.
     * @param eventString The event string received from the Streamer Options servers.
     * @implNote This method should only be called from the SSEUtil class.
     */
    public static void receiveEvents(String eventString) {
        if(eventString.startsWith("data: ")) {
            Gson gson = new Gson();
            JsonObject event = gson.fromJson(eventString.replaceFirst("data: ", ""), JsonObject.class);

            if(Objects.equals(event.toString(), "{\"status\":\"connected\"}")) {
                PluginLogger.getLogger("StreamerOptions").info("Successfully connected to Streamer Options servers.");
                return;
            }

            if(event.get("type").getAsString().toUpperCase().equals("CUSTOM_COMMAND")) {
                SOCustomEvent.response(event.get("command").getAsString());
                return;
            }

            SOEvent soEvent = new SOEvent(
                    SOEventType.valueOf(event.get("type").getAsString().toUpperCase()),
                    event.get("redeemed_by").getAsString()
            );

            if(soEvent.eventType() == SOEventType.SPAWN_ZOMBIE) {
                StreamerUtil.getStreamers().forEach(streamer -> {
                    Player p = Bukkit.getPlayer(UUID.fromString(streamer));
                    if(p != null) {
                        SOZombieAttackEvent.response(p, soEvent.redeemedBy());
                    } else {
                        PluginLogger.getLogger("StreamerOptions").warning("Streamer " + streamer + " is not online. Skipping event.");
                    }
                });
                return;
            }
            if(soEvent.eventType() == SOEventType.SPAWN_IRON_GOLEM) {
                StreamerUtil.getStreamers().forEach(streamer -> {
                    Player p = Bukkit.getPlayer(UUID.fromString(streamer));
                    if(p != null) {
                        SOIronGolemSpawnEvent.response(p, soEvent.redeemedBy());
                    } else {
                        PluginLogger.getLogger("StreamerOptions").warning("Streamer " + streamer + " is not online. Skipping event.");
                    }
                });
                return;
            }
            if(soEvent.eventType() == SOEventType.SPAWN_LIGHTNING) {
                StreamerUtil.getStreamers().forEach(streamer -> {
                    Player p = Bukkit.getPlayer(UUID.fromString(streamer));
                    if(p != null) {
                        SOSmiteEvent.response(p, soEvent.redeemedBy());
                    } else {
                        PluginLogger.getLogger("StreamerOptions").warning("Streamer " + streamer + " is not online. Skipping event.");
                    }
                });
                return;
            }
            if(soEvent.eventType() == SOEventType.SPAWN_FIREWORK) {
                StreamerUtil.getStreamers().forEach(streamer -> {
                    Player p = Bukkit.getPlayer(UUID.fromString(streamer));
                    if(p != null) {
                        SOFireworkSpawnEvent.response(p, soEvent.redeemedBy());
                    } else {
                        PluginLogger.getLogger("StreamerOptions").warning("Streamer " + streamer + " is not online. Skipping event.");
                    }
                });
                return;
            }

            if(soEvent.eventType() == SOEventType.GIVE_EFFECT_NAUSEA) {
                StreamerUtil.getStreamers().forEach(streamer -> {
                    Player p = Bukkit.getPlayer(UUID.fromString(streamer));
                    if(p != null) {
                        SOGiveEffectNauseaEvent.response(p, soEvent.redeemedBy());
                    } else {
                        PluginLogger.getLogger("StreamerOptions").warning("Streamer " + streamer + " is not online. Skipping event.");
                    }
                });
                return;
            }
            if(soEvent.eventType() == SOEventType.GIVE_EFFECT_DARKNESS) {
                StreamerUtil.getStreamers().forEach(streamer -> {
                    Player p = Bukkit.getPlayer(UUID.fromString(streamer));
                    if(p != null) {
                        SOGiveEffectDarknessEvent.response(p, soEvent.redeemedBy());
                    } else {
                        PluginLogger.getLogger("StreamerOptions").warning("Streamer " + streamer + " is not online. Skipping event.");
                    }
                });
                return;
            }
            if(soEvent.eventType() == SOEventType.GIVE_EFFECT_SPEED) {
                StreamerUtil.getStreamers().forEach(streamer -> {
                    Player p = Bukkit.getPlayer(UUID.fromString(streamer));
                    if(p != null) {
                        SOGiveEffectSpeedEvent.response(p, soEvent.redeemedBy());
                    } else {
                        PluginLogger.getLogger("StreamerOptions").warning("Streamer " + streamer + " is not online. Skipping event.");
                    }
                });
                return;
            }
            if(soEvent.eventType() == SOEventType.RANDOM_EFFECT) {
                StreamerUtil.getStreamers().forEach(streamer -> {
                    Player p = Bukkit.getPlayer(UUID.fromString(streamer));
                    if(p != null) {
                        SOGiveRandomEffectEvent.response(p, soEvent.redeemedBy());
                    } else {
                        PluginLogger.getLogger("StreamerOptions").warning("Streamer " + streamer + " is not online. Skipping event.");
                    }
                });
                return;
            }
            if(soEvent.eventType() == SOEventType.RANDOM_TELEPORT_RANGE) {
                StreamerUtil.getStreamers().forEach(streamer -> {
                    Player p = Bukkit.getPlayer(UUID.fromString(streamer));
                    if(p != null) {
                        SORandomTeleportEvent.response(p, soEvent.redeemedBy());
                    } else {
                        PluginLogger.getLogger("StreamerOptions").warning("Streamer " + streamer + " is not online. Skipping event.");
                    }
                });
                return;
            }
            if(soEvent.eventType() == SOEventType.RANDOM_HOTBAR_ITEM_DROP) {
                StreamerUtil.getStreamers().forEach(streamer -> {
                    Player p = Bukkit.getPlayer(UUID.fromString(streamer));
                    if(p != null) {
                        SORandomHotbarItemDropEvent.response(p, soEvent.redeemedBy());
                    } else {
                        PluginLogger.getLogger("StreamerOptions").warning("Streamer " + streamer + " is not online. Skipping event.");
                    }
                });
                return;
            }
            if(soEvent.eventType() == SOEventType.CREEPER_PLAY_SOUND) {
                StreamerUtil.getStreamers().forEach(streamer -> {
                    Player p = Bukkit.getPlayer(UUID.fromString(streamer));
                    if(p != null) {
                        SOCreeperPlaySoundEvent.response(p, soEvent.redeemedBy());
                    } else {
                        PluginLogger.getLogger("StreamerOptions").warning("Streamer " + streamer + " is not online. Skipping event.");
                    }
                });
                return;
            }
            if(soEvent.eventType() == SOEventType.CHANGE_WEATHER) {
                StreamerUtil.getStreamers().forEach(streamer -> {
                    Player p = Bukkit.getPlayer(UUID.fromString(streamer));
                    if(p != null) {
                        SOChangeWeatherEvent.response(p, soEvent.redeemedBy(), SOWeatherType.valueOf(event.get("weather_type").getAsString().toUpperCase()));
                    } else {
                        PluginLogger.getLogger("StreamerOptions").warning("Streamer " + streamer + " is not online. Skipping event.");
                    }
                });
                return;
            }
            if(soEvent.eventType() == SOEventType.WHITELIST_ADD) {
                SOWhitelistAddEvent.response(event.get("minecraft_username").getAsString(), soEvent.redeemedBy());
            }

            PluginLogger.getLogger("StreamerOptions").info(event.toString());
        }
    }

}
