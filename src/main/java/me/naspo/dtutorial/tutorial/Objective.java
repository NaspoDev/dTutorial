package me.naspo.dtutorial.tutorial;

import me.naspo.dtutorial.core.guis.GUI;

import java.util.UUID;

public abstract class Objective {
    protected String name;
    protected boolean completed;

    protected UUID uuid;
    protected GUI gui;

    Objective(UUID uuid, GUI gui) {
        this.uuid = uuid;
        this.gui = gui;

        name = "Unspecified";
        completed = false;
    }

    public abstract boolean isCompleted();

    public abstract String getName();

    public abstract void setCompleted();

    public abstract void setCompletedIgnoreRewards();

    public abstract void setIncomplete();
}
