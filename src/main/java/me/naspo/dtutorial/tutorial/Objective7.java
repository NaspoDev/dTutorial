package me.naspo.dtutorial.tutorial;

import me.naspo.dtutorial.Utils;
import me.naspo.dtutorial.core.guis.GUI;
import me.naspo.dtutorial.core.Tutorial;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Objective7 extends Objective {

    public Objective7(UUID uuid, GUI gui) {
        super(uuid, gui);

        name = "/warp resource";
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
        gui.completeObjectiveSeven(true);
        Tutorial.tutorial.get(uuid).bossBar.setTitle(Utils.chatColor("&aTutorial Step 8 &7- &6/tutorial"));
        Tutorial.tutorial.get(uuid).bossBar.setProgress(0.7);

        Bukkit.getPlayerExact(player.getName()).playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.5f, 1.0f);
        Bukkit.getPlayerExact(player.getName()).sendTitle("Objective 7 Complete!", "", 5, 30, 5);
        Bukkit.getPlayerExact(player.getName()).sendMessage(Utils.chatColor(Utils.prefix + "&7You just completed " +
                "objective 7!"));
        Bukkit.getPlayerExact(player.getName()).sendMessage(Utils.chatColor("&7You were given &61x Engineer Crate Key&7."));
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "crates give p Engineer 1 " +
                player.getName());
    }

    @Override
    public void setCompletedIgnoreRewards() {
        completed = true;
        gui.completeObjectiveSeven(true);
        Tutorial.tutorial.get(uuid).bossBar.setTitle(Utils.chatColor("&aTutorial Step 8 &7- &6/tutorial"));
        Tutorial.tutorial.get(uuid).bossBar.setProgress(0.7);
    }

    @Override
    public void setIncomplete() {
        completed = false;
        gui.completeObjectiveSeven(false);
    }
}
