package me.naspo.dtutorial.core;

import me.naspo.dtutorial.DTutorial;
import me.naspo.dtutorial.filemanagement.DataFiles;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;
import java.util.UUID;

//Manages the tutorial hashmap.
public class Tutorial implements Listener {
    public static HashMap<UUID, PlayerStats> tutorial; //Stores new players eligible for the tutorial.

    private DTutorial plugin;
    private DataFiles dataFiles;

    public Tutorial(DTutorial plugin, DataFiles dataFiles) {
        this.plugin = plugin;
        this.dataFiles = dataFiles;

        tutorial = new HashMap<>();
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        //If they aren't on the hashmap, check if they haven't played before, then add them.
        if (!(tutorial.containsKey(player.getUniqueId()))) {
            if (!player.hasPlayedBefore()) {
                tutorial.put(player.getUniqueId(), new PlayerStats(player, plugin));
                //If they have played before, restore their data from their file.
            } else {
                dataFiles.restoreData(player);
            }
            return;
        }
        //If they are on the hashmap, make sure they haven't skipped/completed, then add them to their bossbar.
        if (!(tutorial.get(player.getUniqueId()).getCompletedOrSkipped())) {
            tutorial.get(player.getUniqueId()).bossBar.addPlayer(player);
        }
    }
}
