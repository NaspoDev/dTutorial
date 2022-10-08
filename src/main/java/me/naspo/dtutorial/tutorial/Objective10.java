package me.naspo.dtutorial.tutorial;

import me.naspo.dtutorial.DTutorial;
import me.naspo.dtutorial.Utils;
import me.naspo.dtutorial.core.guis.GUI;
import me.naspo.dtutorial.core.Tutorial;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Objective10 extends Objective {

    private DTutorial plugin;

    public Objective10(UUID uuid, GUI gui, DTutorial plugin) {
        super(uuid, gui);
        this.plugin = plugin;

        name = "Use /vote";
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
        gui.completeObjectiveTen(true);
        Tutorial.tutorial.get(uuid).bossBar.setTitle(Utils.chatColor("&aTutorial Complete!"));
        Tutorial.tutorial.get(uuid).bossBar.setProgress(1.0);

        Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
            @Override
            public void run() {
                Tutorial.tutorial.get(uuid).bossBar.removePlayer(player);
            }
        }, 60L);

        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.5f, 1.0f);
        player.sendTitle("Tutorial Objective Complete!", "", 1, 20, 1);
        player.sendMessage(Utils.chatColor(Utils.prefix + "&7You just completed " +
                "objective 10!"));
        player.sendMessage(Utils.chatColor("&7You were given &6Coal rank for one week&7."));
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "lp user " +
                player.getName() + " parent addtemp coal 7d");

        player.sendMessage(Utils.chatColor(Utils.prefix + "&7You completed the tutorial! " +
                "If you ever need help, use &6/help&7. Have fun!"));

        Tutorial.tutorial.get(player.getUniqueId()).setCompletedOrSkipped(true);
    }

    @Override
    public void setCompletedIgnoreRewards() {
        Player player = Bukkit.getPlayer(uuid);

        completed = true;
        gui.completeObjectiveTen(true);
        Tutorial.tutorial.get(uuid).bossBar.setTitle(Utils.chatColor("&aTutorial Complete!"));
        Tutorial.tutorial.get(uuid).bossBar.setProgress(1.0);

        Tutorial.tutorial.get(player.getUniqueId()).setCompletedOrSkipped(true);
    }

    @Override
    public void setIncomplete() {
        completed = false;
        gui.completeObjectiveTen(false);
    }
}
