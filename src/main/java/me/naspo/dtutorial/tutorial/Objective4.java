package me.naspo.dtutorial.tutorial;

import me.naspo.dtutorial.Utils;
import me.naspo.dtutorial.core.guis.GUI;
import me.naspo.dtutorial.core.Tutorial;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Objective4 extends Objective {

    public Objective4(UUID uuid, GUI gui) {
        super(uuid, gui);

        name = "Claim land";
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
        gui.completeObjectiveFour(true);
        Tutorial.tutorial.get(uuid).bossBar.setTitle(Utils.chatColor("&aTutorial Step 5 &7- &6/tutorial"));
        Tutorial.tutorial.get(uuid).bossBar.setProgress(0.4);

        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.5f, 1.0f);
        player.sendTitle("Objective 4 Complete!", "", 5, 30, 5);
        player.sendMessage(Utils.chatColor(Utils.prefix + "&7You just completed " +
                "objective 4!"));
        player.sendMessage(Utils.chatColor("&7You were given &61 Golden Apple&7."));
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "give " +
                player.getName() + " golden_apple 1");
    }

    @Override
    public void setCompletedIgnoreRewards() {
        completed = true;
        gui.completeObjectiveFour(true);
        Tutorial.tutorial.get(uuid).bossBar.setTitle(Utils.chatColor("&aTutorial Step 5 &7- &6/tutorial"));
        Tutorial.tutorial.get(uuid).bossBar.setProgress(0.4);
    }

    @Override
    public void setIncomplete() {
        completed = false;
        gui.completeObjectiveFour(false);
    }
}
