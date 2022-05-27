package me.naspo.dtutorial.core;

import me.naspo.dtutorial.DTutorial;
import me.naspo.dtutorial.Utils;
import me.naspo.dtutorial.core.guis.GUI;
import me.naspo.dtutorial.tutorial.*;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

//Stats object class, stores player tutorial statistics.
public class PlayerStats {
    private List<Objective> objectives;
    private boolean completedOrSkipped;
    public BossBar bossBar;

    protected GUI gui;
    protected Player player;
    protected DTutorial plugin;

    public PlayerStats(Player player, DTutorial plugin) {
        this.plugin = plugin;
        this.player = player;

        gui = new GUI(player);

        setupBossBar();

        objectives = new ArrayList<>();
        completedOrSkipped = false;

        setupObjectives();
    }

    private void setupObjectives() {
        objectives.add(new Objective1(player.getUniqueId(), gui));
        objectives.add(new Objective2(player.getUniqueId(), gui));
        objectives.add(new Objective3(player.getUniqueId(), gui));
        objectives.add(new Objective4(player.getUniqueId(), gui));
        objectives.add(new Objective5(player.getUniqueId(), gui));
        objectives.add(new Objective6(player.getUniqueId(), gui));
        objectives.add(new Objective7(player.getUniqueId(), gui));
        objectives.add(new Objective8(player.getUniqueId(), gui));
        objectives.add(new Objective9(player.getUniqueId(), gui));
        objectives.add(new Objective10(player.getUniqueId(), gui, plugin));
    }

    private void setupBossBar() {
        bossBar = Bukkit.createBossBar(
                Utils.chatColor("&aTutorial Step 1 &7- &6/tutorial"),
                BarColor.BLUE,
                BarStyle.SEGMENTED_10);
        bossBar.setProgress(0);

        bossBar.addPlayer(player);
    }

    //getters
    public Objective getObjective(int objective) {
        return objectives.get(objective);
    }

    public int numberOfObjectives() {
        return objectives.size();
    }

    public GUI getGUI() {
        return gui;
    }

    public boolean getCompletedOrSkipped() {
        return completedOrSkipped;
    }

    //setters
    public void setCompletedOrSkipped(Boolean value) {
        if (value) {
            completedOrSkipped = true;
            if (bossBar.getPlayers().contains(player)) {
                bossBar.removePlayer(player);
            }
        } else {
            completedOrSkipped = false;
            if (!(bossBar.getPlayers().contains(player))) {
                bossBar.addPlayer(player);
            }
        }
    }
}
