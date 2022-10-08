package me.naspo.dtutorial.core;

import com.earth2me.essentials.Essentials;
import me.ryanhamshire.GriefPrevention.events.ClaimCreatedEvent;
import net.ess3.api.events.UserWarpEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.UUID;

//Where all tutorial objectives are managed.
public class ObjectiveManager implements Listener {
    private Essentials ess;

    public ObjectiveManager() {
        ess = (Essentials) Bukkit.getPluginManager().getPlugin("Essentials");
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();

        if (Tutorial.tutorial.containsKey(player.getUniqueId())) {
            String label = event.getMessage();

            //Objective 1 - Explore spawn.
            if (label.equalsIgnoreCase("/achievements")) {
                objectiveOne(player);
                return;
            }

            //Objective 2 - Use /wild.
            if (label.equalsIgnoreCase("/wild") || label.equalsIgnoreCase("/rtp")) {
                objectiveTwo(player);
                return;
            }

            //Objective 3 - Set a home with /sethome.
            if (label.startsWith("/sethome")) {
                if (ess.getUser(player).getHomes().size() >= 1) {
                    objectiveThree(player);
                    return;
                }
            }

            //Objective 5 - View the PlayerWarps with /pwarp.
            if (label.equalsIgnoreCase("/pwarp")) {
                objectiveFive(player);
                return;
            }

            //Objective 9 - Use /store.
            if (label.equalsIgnoreCase("/store")) {
                objectiveNine(player);
                return;
            }

            //Objective 10 - Voting gives you awesome rewards! See the vote menu with /vote.
            if (label.equalsIgnoreCase("/vote")) {
                objectiveTen(player);
            }
        }
    }

    //------------ OBJECTIVE COMPLETION LOGIC ------------

    //Objective 1 completion check.
    private void objectiveOne(Player player) {
        if (!(Tutorial.tutorial.get(player.getUniqueId()).getObjective(0).isCompleted())) {
            Tutorial.tutorial.get(player.getUniqueId()).getObjective(0).setCompleted();
        }
    }

    //Objective 2 completion check.
    private void objectiveTwo(Player player) {
        if (!(Tutorial.tutorial.get(player.getUniqueId()).getObjective(1).isCompleted())) {
            if (!(Tutorial.tutorial.get(player.getUniqueId()).getObjective(0).isCompleted())) {
                return;
            }
            Tutorial.tutorial.get(player.getUniqueId()).getObjective(1).setCompleted();
        }
    }

    //Objective 3 completion check.
    private void objectiveThree(Player player) {
        if (!(Tutorial.tutorial.get(player.getUniqueId()).getObjective(2).isCompleted())) {
            if (!(Tutorial.tutorial.get(player.getUniqueId()).getObjective(1).isCompleted())) {
                return;
            }
            Tutorial.tutorial.get(player.getUniqueId()).getObjective(2).setCompleted();
        }
    }

    //Objective 4 - Claim some land with the golden shovel, or with /claim.
    //Objective 4 completion check.
    @EventHandler
    private void objectiveFour(ClaimCreatedEvent event) {
        UUID uuid = event.getClaim().getOwnerID();
        if (Tutorial.tutorial.containsKey(uuid)) {
            if (!(Tutorial.tutorial.get(uuid).getObjective(3).isCompleted())) {
                if (!(Tutorial.tutorial.get(uuid).getObjective(2).isCompleted())) {
                    return;
                }
                Tutorial.tutorial.get(uuid).getObjective(3).setCompleted();
            }
        }
    }

    //Objective 5 completion check.
    private void objectiveFive(Player player) {
        if (!(Tutorial.tutorial.get(player.getUniqueId()).getObjective(4).isCompleted())) {
            if (!(Tutorial.tutorial.get(player.getUniqueId()).getObjective(3).isCompleted())) {
                return;
            }
            Tutorial.tutorial.get(player.getUniqueId()).getObjective(4).setCompleted();
        }
    }

    //Objective 6 - Visit /warp town.
    //Objective 6 completion check.
    @EventHandler
    private void objectiveSix(UserWarpEvent event) {
        if (event.getWarp().equalsIgnoreCase("town")) {
            if (Tutorial.tutorial.containsKey(event.getUser().getUUID())) {
                if (!(Tutorial.tutorial.get(event.getUser().getUUID()).getObjective(5).isCompleted())) {
                    if (!(Tutorial.tutorial.get(event.getUser().getUUID()).getObjective(4).isCompleted())) {
                        return;
                    }
                    Tutorial.tutorial.get(event.getUser().getUUID()).getObjective(5).setCompleted();
                }
            }
        }
    }

    //Objective 7 - Visit /warp resource.
    //Objective 7 completion check.
    @EventHandler
    private void objectiveSeven(UserWarpEvent event) {
        if (event.getWarp().equalsIgnoreCase("resource")) {
            if (Tutorial.tutorial.containsKey(event.getUser().getUUID())) {
                if (!(Tutorial.tutorial.get(event.getUser().getUUID()).getObjective(6).isCompleted())) {
                    if (!(Tutorial.tutorial.get(event.getUser().getUUID()).getObjective(5).isCompleted())) {
                        return;
                    }
                    Tutorial.tutorial.get(event.getUser().getUUID()).getObjective(6).setCompleted();
                }
            }
        }
    }

    //Objective 8 - Visit /warp crates.
    //Objective 8 completion check.
    @EventHandler
    private void objectiveEight(UserWarpEvent event) {
        if (event.getWarp().equalsIgnoreCase("crates")) {
            if (Tutorial.tutorial.containsKey(event.getUser().getUUID())) {
                if (!(Tutorial.tutorial.get(event.getUser().getUUID()).getObjective(7).isCompleted())) {
                    if (!(Tutorial.tutorial.get(event.getUser().getUUID()).getObjective(6).isCompleted())) {
                        return;
                    }
                    Tutorial.tutorial.get(event.getUser().getUUID()).getObjective(7).setCompleted();
                }
            }
        }
    }

    //Objective 9 completion check.
    private void objectiveNine(Player player) {
        if (!(Tutorial.tutorial.get(player.getUniqueId()).getObjective(8).isCompleted())) {
            if (!(Tutorial.tutorial.get(player.getUniqueId()).getObjective(7).isCompleted())) {
                return;
            }
            Tutorial.tutorial.get(player.getUniqueId()).getObjective(8).setCompleted();
        }
    }

    //Objective 10 completion check.
    private void objectiveTen(Player player) {
        if (!(Tutorial.tutorial.get(player.getUniqueId()).getObjective(9).isCompleted())) {
            if (!(Tutorial.tutorial.get(player.getUniqueId()).getObjective(8).isCompleted())) {
                return;
            }
            Tutorial.tutorial.get(player.getUniqueId()).getObjective(9).setCompleted();
        }
    }
}
