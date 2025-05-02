package com.qetrox.streameroptions.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class StreamerTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 1) {
            List<String> o = new ArrayList<>();
            o.add("add");
            o.add("remove");
            o.add("list");
            return o;
        }
        if (args.length == 2) {
            List<String> o = new ArrayList<>();
            for (OfflinePlayer p : Bukkit.getServer().getOfflinePlayers()) {
                o.add(p.getName());
            }
            return o;
        }
        return null;
    }
}
