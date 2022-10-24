package me.naspo.dtutorial;

import me.naspo.dtutorial.core.commandstuff.Commands;
import me.naspo.dtutorial.core.guis.GUI;
import me.naspo.dtutorial.core.ObjectiveManager;
import me.naspo.dtutorial.core.Tutorial;
import me.naspo.dtutorial.core.commandstuff.TabCompleter;
import me.naspo.dtutorial.core.guis.GUIEvents;
import me.naspo.dtutorial.core.guis.SkipTutorialConfirmationGUI;
import me.naspo.dtutorial.filemanagement.DataFiles;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class DTutorial extends JavaPlugin {
    private Utils utils;

    private DataFiles dataFiles;
    private Tutorial tutorial;
    private Commands commands;
    private TabCompleter tabCompleter;
    private ObjectiveManager objectiveManager;

    private GUI gui;
    private SkipTutorialConfirmationGUI skipTutorialConfirmationGUI;
    private GUIEvents guiEvents;

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();

        dependencyCheck();

        this.getLogger().info("dTutorial has been enabled!");

        instantiateClasses();
        registerEvents();
        registerCommands();
    }

    @Override
    public void onDisable() {
       this.getLogger().info("dTutorial has been disabled!");

       if (!(Tutorial.tutorial.isEmpty())) {
           dataFiles.saveData();
       }
    }

    private void dependencyCheck() {
        //Essentials check
        if (this.getServer().getPluginManager().getPlugin("Essentials") == null) {
            this.getLogger().log(Level.SEVERE, "The Essentials plugin could not be located and is a " +
                    "dependant of this plugin!");
            this.getLogger().log(Level.SEVERE, "Disabling plugin.");
            this.getServer().getPluginManager().disablePlugin(this);
        }

        //GriefPrevention check
        if (this.getServer().getPluginManager().getPlugin("GriefPrevention") == null) {
            this.getLogger().log(Level.SEVERE, "The GriefPrevention plugin could not be located and is a " +
                    "dependant of this plugin!");
            this.getLogger().log(Level.SEVERE, "Disabling plugin.");
            this.getServer().getPluginManager().disablePlugin(this);
        }

        //CrazyCrates check
        if (this.getServer().getPluginManager().getPlugin("CrazyCrates") == null) {
            this.getLogger().log(Level.SEVERE, "The CrazyCrates plugin could not be located and is a " +
                    "dependant of this plugin!");
            this.getLogger().log(Level.SEVERE, "Disabling plugin.");
            this.getServer().getPluginManager().disablePlugin(this);
        }

        //LuckPerms check
        if (this.getServer().getPluginManager().getPlugin("LuckPerms") == null) {
            this.getLogger().log(Level.SEVERE, "The LuckPerms plugin could not be located and is a " +
                    "dependant of this plugin!");
            this.getLogger().log(Level.SEVERE, "Disabling plugin.");
            this.getServer().getPluginManager().disablePlugin(this);
        }
    }

    private void instantiateClasses() {
        utils = new Utils(this);
        dataFiles = new DataFiles(this);
        tutorial = new Tutorial(this, dataFiles);
        commands = new Commands(this, dataFiles);
        tabCompleter = new TabCompleter();
        objectiveManager = new ObjectiveManager(this);

        gui = new GUI();
        skipTutorialConfirmationGUI = new SkipTutorialConfirmationGUI();
        guiEvents = new GUIEvents(gui, skipTutorialConfirmationGUI, this);
    }

    private void registerEvents() {
        this.getServer().getPluginManager().registerEvents(tutorial, this);
        this.getServer().getPluginManager().registerEvents(objectiveManager, this);
        this.getServer().getPluginManager().registerEvents(guiEvents, this);
    }

    private void registerCommands() {
        this.getCommand("tutorial").setExecutor(commands);
        this.getCommand("tutorial").setTabCompleter(tabCompleter);
    }
}
