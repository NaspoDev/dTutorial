package me.naspo.dtutorial.tutorial;

import me.naspo.dtutorial.Utils;
import me.naspo.dtutorial.core.guis.GUI;
import me.naspo.dtutorial.core.Tutorial;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Objective5 extends Objective {

    public Objective5(UUID uuid, GUI gui) {
        super(uuid, gui);

        name = "Use /pwarp";
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
        gui.completeObjectiveFive(true);
        Tutorial.tutorial.get(uuid).bossBar.setTitle(Utils.chatColor("&aTutorial Step 6 &7- &6/tutorial"));
        Tutorial.tutorial.get(uuid).bossBar.setProgress(0.5);

        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.5f, 1.0f);
        player.sendTitle("Objective 5 Complete!", "", 5, 30, 5);
        player.sendMessage(Utils.chatColor(Utils.prefix + "&7You just completed " +
                "objective 5!"));
        player.sendMessage(Utils.chatColor("&7You were given &6$1,000&7."));
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "eco give " +
                player.getName() + " 1000");
    }

    @Override
    public void setCompletedIgnoreRewards() {
        completed = true;
        gui.completeObjectiveFive(true);
        Tutorial.tutorial.get(uuid).bossBar.setTitle(Utils.chatColor("&aTutorial Step 6 &7- &6/tutorial"));
        Tutorial.tutorial.get(uuid).bossBar.setProgress(0.5);
    }

    @Override
    public void setIncomplete() {
        completed = false;
        gui.completeObjectiveFive(false);
    }
}
