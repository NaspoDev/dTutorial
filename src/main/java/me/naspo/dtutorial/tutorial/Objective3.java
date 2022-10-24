package me.naspo.dtutorial.tutorial;

import me.naspo.dtutorial.Utils;
import me.naspo.dtutorial.core.guis.GUI;
import me.naspo.dtutorial.core.Tutorial;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Objective3 extends Objective {

    public Objective3(UUID uuid, GUI gui) {
        super(uuid, gui);

        name = "Set a home";
        completed = false;
    }

    @Override
    public boolean isCompleted() {
        return completed;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setCompleted() {
        Player player = Bukkit.getPlayer(uuid);

        completed = true;
        gui.completeObjectiveThree(true);
        Tutorial.tutorial.get(uuid).bossBar.setTitle(Utils.chatColor("&aTutorial Step 4 &7- &6/tutorial"));
        Tutorial.tutorial.get(uuid).bossBar.setProgress(0.3);

        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.5f, 1.0f);
        player.sendTitle("Objective 3 Complete!", "", 5, 30, 5);
        player.sendMessage(Utils.chatColor(Utils.prefix + "&7You just completed " +
                "objective 3!"));
        player.sendMessage(Utils.chatColor("&7You were given &61x Builder Crate Key&7."));
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "crates give p Builder 1 " +
                player.getName());
    }

    @Override
    public void setCompletedIgnoreRewards() {
        completed = true;
        gui.completeObjectiveThree(true);
        Tutorial.tutorial.get(uuid).bossBar.setTitle(Utils.chatColor("&aTutorial Step 4 &7- &6/tutorial"));
        Tutorial.tutorial.get(uuid).bossBar.setProgress(0.3);
    }

    @Override
    public void setIncomplete() {
        completed = false;
        gui.completeObjectiveThree(false);
    }
}
