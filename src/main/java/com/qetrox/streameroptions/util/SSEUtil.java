package com.qetrox.streameroptions.util;

import org.bukkit.plugin.PluginLogger;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.stream.Stream;

import static com.qetrox.streameroptions.util.StreamerUtil.plugin;

public class SSEUtil {

    private static boolean continueLoop = true;

    private static Stream<String> lines;

    public static void stopLoop() {
        continueLoop = false;
        lines.close();
        PluginLogger.getLogger("StreamerOptions").info("Successfully disconnected from Streamer Options servers.");
    }

    /**
     * Receives events from Streamer Options servers.
     * @throws URISyntaxException if the URI is invalid
     * @throws IOException if an I/O error occurs
     * @throws InterruptedException if the operation is interrupted
     * @implNote This should be called in a separate thread.
     */
    public static void receiveEvents() throws URISyntaxException, IOException, InterruptedException {
        var uri = new URI("https://streameroptions.com/events/minecraft/" + plugin.getConfig().getString("token"));
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(uri).GET().build();

        try {
            while (continueLoop) {
                try {
                    PluginLogger.getLogger("StreamerOptions").info("Attempting to create connection to Streamer Options servers...");
                    lines = client.send(request, HttpResponse.BodyHandlers.ofLines()).body();
                    lines.forEach(EventUtil::receiveEvents);
                } catch (Exception e) {
                    System.err.println(e);
                    PluginLogger.getLogger("StreamerOptions").warning("Connection to Streamer Options servers lost. Retrying in 5 seconds...");
                    Thread.sleep(5000);
                    continue;
                }
            }
        } catch (Exception e) {
            PluginLogger.getLogger("StreamerOptions").warning("An error occurred while attempting to connect to Streamer Options servers.");
            e.printStackTrace();
        }
    }
}
