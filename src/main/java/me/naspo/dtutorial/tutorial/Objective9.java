package me.naspo.dtutorial.tutorial;

import me.naspo.dtutorial.DTutorial;
import me.naspo.dtutorial.Utils;
import me.naspo.dtutorial.core.guis.GUI;
import me.naspo.dtutorial.core.Tutorial;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Objective9 extends Objective {

    public Objective9(UUID uuid, GUI gui) {
        super(uuid, gui);

        name = "Use /store";
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
        gui.completeObjectiveNine(true);
        Tutorial.tutorial.get(uuid).bossBar.setTitle(Utils.chatColor("&aTutorial Step 10 &7- &6/tutorial"));
        Tutorial.tutorial.get(uuid).bossBar.setProgress(0.9);

        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.5f, 1.0f);
        player.sendTitle("Tutorial Objective Complete!", "", 1, 20, 1);
        player.sendMessage(Utils.chatColor(Utils.prefix + "&7You just completed " +
                "objective 9!"));
        player.sendMessage(Utils.chatColor("&7You were given &61x Beta Crate Key&7."));
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "crates give p Beta 1 " +
                player.getName());
    }

    @Override
    public void setCompletedIgnoreRewards() {
        completed = true;
        gui.completeObjectiveNine(true);
        Tutorial.tutorial.get(uuid).bossBar.setTitle(Utils.chatColor("&aTutorial Step 10 &7- &6/tutorial"));
        Tutorial.tutorial.get(uuid).bossBar.setProgress(0.9);
    }

    @Override
    public void setIncomplete() {
        completed = false;
        gui.completeObjectiveNine(false);
    }
}
