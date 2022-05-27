package me.naspo.dtutorial.tutorial;

import me.naspo.dtutorial.Utils;
import me.naspo.dtutorial.core.guis.GUI;
import me.naspo.dtutorial.core.Tutorial;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Objective1 extends Objective {

    public Objective1(UUID uuid, GUI gui) {
        super(uuid, gui);

        name = "Explore Spawn";
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
        gui.completeObjectiveOne(true);
        Tutorial.tutorial.get(uuid).bossBar.setTitle(Utils.chatColor("&aTutorial Step 2 &7- &6/tutorial"));
        Tutorial.tutorial.get(uuid).bossBar.setProgress(0.1);

        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.5f, 1.0f);
        player.sendTitle("&aObjective 1 Complete!", "", 1, 20, 1);
        player.sendMessage(Utils.chatColor(Utils.prefix + "&7You just completed " +
                "objective 1!"));
        player.sendMessage(Utils.chatColor("&7You were given &6$500&7."));
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "eco give " +
                player.getName() + " 500");
    }

    @Override
    public void setCompletedIgnoreRewards() {
        completed = true;
        gui.completeObjectiveOne(true);

        Tutorial.tutorial.get(uuid).bossBar.setTitle(Utils.chatColor("&aTutorial Step 2 &7- &6/tutorial"));
        Tutorial.tutorial.get(uuid).bossBar.setProgress(0.1);
    }

    @Override
    public void setIncomplete() {
        completed = false;
        gui.completeObjectiveOne(false);
    }

}
