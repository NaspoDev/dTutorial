package me.naspo.dtutorial.filemanagement;

import me.naspo.dtutorial.DTutorial;
import me.naspo.dtutorial.Utils;
import me.naspo.dtutorial.core.PlayerStats;
import me.naspo.dtutorial.core.Tutorial;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;

public class DataFiles {
    private File dir;
    private File[] dirListings;
    private File playerFile;
    private YamlConfiguration playerConfig;

    private DTutorial plugin;
    public DataFiles(DTutorial plugin) {
        this.plugin = plugin;

        mkdirs();
    }

    //Creates the PlayerData folder.
    private void mkdirs() {
        dir = new File(plugin.getDataFolder(), "PlayerData");
        if (!(dir.exists())) {
            try {
                dir.mkdirs();
            } catch (Exception e) {
                plugin.getLogger().log(Level.SEVERE, "Could not create PlayerData folder! The plugin functionally" +
                        "will not work without it!");
                plugin.getLogger().log(Level.SEVERE, "Disabling plugin.");
                plugin.getLogger().log(Level.SEVERE, Arrays.toString(e.getStackTrace()));
                plugin.getServer().getPluginManager().disablePlugin(plugin);
                return;
            }
        }
        if (dir.isDirectory()) {
            dirListings = dir.listFiles();
        }
    }

    //Save completion status of each objective to the player's data file.
    public void saveData() {
        for (Map.Entry<UUID, PlayerStats> entry : Tutorial.tutorial.entrySet()) {

            //Initialize and create the file if it doesnt exist.
            playerFile = new File(dir, entry.getKey() + ".yml");
            if (!(playerFile.exists())) {
                try {
                    playerFile.createNewFile();
                } catch (IOException e) {
                    plugin.getLogger().log(Level.WARNING, "Could not create playerdata file for player uuid " + entry.getKey());
                    e.printStackTrace();
                    return;
                }
            }

            //Write the data to the file.
            playerConfig = YamlConfiguration.loadConfiguration(playerFile);
            for (int i = 0; i < entry.getValue().numberOfObjectives(); i++) {
                playerConfig.set("objective-stats.objective" + (i + 1), entry.getValue().getObjective(i).isCompleted());
            }
            playerConfig.set("completed-or-skipped", entry.getValue().getCompletedOrSkipped());

            try {
                playerConfig.save(playerFile);
            } catch (IOException e) {
                plugin.getLogger().log(Level.WARNING, "Could not save playerdata for player uuid " + entry.getKey());
                e.printStackTrace();
            }
        }
    }

    //Restores data from a player's file to the hashmap.
    public void restoreData(Player player) {
        if (dir.length() == 0) {
            return;
        }

        //Finding the player's file.
        Arrays.stream(dirListings)
                .filter(file -> file.getName().startsWith(player.getUniqueId().toString()))
                .findFirst()
                .ifPresent(file -> {
                    playerConfig = YamlConfiguration.loadConfiguration(file);

                    //If player has completed or skipped tutorial, do not add them to the hashmap.
                    if (playerConfig.getBoolean("completed-or-skipped")) {
                        return;
                    }

                    //Otherwise, they are still working on the tutorial. Add them to the hashmap.
                    UUID uuid = UUID.fromString(Utils.removeExtension(file.getName()));

                    Tutorial.tutorial.put(uuid,
                            new PlayerStats(player, plugin));

                    //Add their stats to the hashmap.
                    playerConfig.getConfigurationSection("objective-stats").getKeys(false).forEach(key -> {
                        if (playerConfig.getBoolean("objective-stats." + key)) {
                            Tutorial.tutorial.get(uuid).getObjective(
                                            Integer.parseInt(key.replaceAll("objective", "")) - 1)
                                    .setCompletedIgnoreRewards();
                        }
                    });
                });
    }

    //Updates data from all files whose player is also in the hashmap to the hashmap.
    public void reloadAllFiles() {
        if (dir.length() == 0) {
            return;
        }

        for (File file : dirListings) {
            if (Tutorial.tutorial.containsKey(UUID.fromString(Utils.removeExtension(file.getName())))) {
                UUID uuid = UUID.fromString(Utils.removeExtension(file.getName()));
                playerConfig = YamlConfiguration.loadConfiguration(file);

                //If completed-or-skipped is marked true or false, update the hashmap.
                if (playerConfig.getBoolean("completed-or-skipped")) {
                    Tutorial.tutorial.get(uuid).setCompletedOrSkipped(true);
                    continue;
                } else {
                    Tutorial.tutorial.get(uuid).setCompletedOrSkipped(false);
                }

                //Update their stats to the hashmap.
                playerConfig.getConfigurationSection("objective-stats").getKeys(false).forEach(key -> {
                    if (playerConfig.getBoolean("objective-stats." + key)) {
                        Tutorial.tutorial.get(uuid).getObjective(
                                        Integer.parseInt(key.replaceAll("objective", "")) - 1)
                                .setCompletedIgnoreRewards();
                    } else {
                        Tutorial.tutorial.get(uuid).getObjective(
                                        Integer.parseInt(key.replaceAll("objective", "")) - 1)
                                .setIncomplete();
                    }
                });
            }
        }
    }

}
