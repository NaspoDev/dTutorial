package me.naspo.dtutorial.core.guis;

import me.naspo.dtutorial.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GUI {
    private Inventory inv;
    private ItemStack item;
    private ItemMeta meta;
    private List<String> lore;

    public GUI(Player owner) {
        item = new ItemStack(Material.ORANGE_CONCRETE);
        meta = item.getItemMeta();
        lore = new ArrayList<>();

        setupDefaultInv(owner);
    }

    public GUI() {

    }

    //Create default tutorial inventory.
    private void setupDefaultInv(Player owner) {
        inv = Bukkit.createInventory(owner, 36, Utils.chatColor("&a&lTutorial Menu"));

        //Objective 1
        meta.setDisplayName(Utils.chatColor("&aObjective 1 - IN PROGRESS"));
        setObjectiveOneConstants();

        lore.clear();
        //Objective 2
        item.setType(Material.RED_CONCRETE);
        meta.setDisplayName(Utils.chatColor("&aObjective 2"));
        setObjectiveTwoConstants();

        lore.clear();
        //Objective 3
        meta.setDisplayName(Utils.chatColor("&aObjective 3"));
        setObjectiveThreeConstants();

        lore.clear();
        //Objective 4
        meta.setDisplayName(Utils.chatColor("&aObjective 4"));
        setObjectiveFourConstants();

        lore.clear();
        //Objective 5
        meta.setDisplayName(Utils.chatColor("&aObjective 5"));
        setObjectiveFiveConstants();

        lore.clear();
        //Objective 6
        meta.setDisplayName(Utils.chatColor("&aObjective 6"));
        setObjectiveSixConstants();

        lore.clear();
        //Objective 7
        meta.setDisplayName(Utils.chatColor("&aObjective 7"));
        setObjectiveSevenConstants();

        lore.clear();
        //Objective 8
        meta.setDisplayName(Utils.chatColor("&aObjective 8"));
        setObjectiveEightConstants();

        lore.clear();
        //Objective 9
        meta.setDisplayName(Utils.chatColor("&aObjective 9"));
        setObjectiveNineConstants();

        lore.clear();
        //Objective 10
        meta.setDisplayName(Utils.chatColor("&aObjective 10"));
        setObjectiveTenConstants();

        lore.clear();
        //Skip the Tutorial
        item.setType(Material.BARRIER);
        meta.setDisplayName(Utils.chatColor("&4Skip the Tutorial"));
        setSkipTutorialConstants();

        lore.clear();
        //Set fillers
        item.setType(Material.GRAY_STAINED_GLASS_PANE);
        meta.setDisplayName(" ");
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        for (int i = 0; i < inv.getSize(); i++) {
            if (i < 10) {
                inv.setItem(i, item);
            } else if (i == 17 || i == 18) {
                inv.setItem(i, item);
            } else if (i > 25) {
                inv.setItem(i, item);
            }
        }
    }

    // ------------- OBJECTIVE GUI CONSTANTS -------------
    // (From lore and down)

    private void setObjectiveOneConstants() {
        lore.add("");
        lore.add(Utils.chatColor("&fDetails:"));
        lore.add(Utils.chatColor("&7Discover three unique locations"));
        lore.add(Utils.chatColor("&7at spawn."));
        lore.add("");
        lore.add(Utils.chatColor("&7- Quests NPC"));
        lore.add(Utils.chatColor("&7- Jobs NPC"));
        lore.add(Utils.chatColor("&7- Achievements NPC"));
        lore.add("");
        lore.add(Utils.chatColor("&fRewards:"));
        lore.add(Utils.chatColor("&7- $500"));
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(10, item);
    }

    private void setObjectiveTwoConstants() {
        lore.add("");
        lore.add(Utils.chatColor("&fDetails:"));
        lore.add(Utils.chatColor("&7Use &6/wild &7to enter the wilderness."));
        lore.add("");
        lore.add(Utils.chatColor("&fRewards:"));
        lore.add(Utils.chatColor("&7- $500"));
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(11, item);
    }

    private void setObjectiveThreeConstants() {
        lore.add("");
        lore.add(Utils.chatColor("&fDetails:"));
        lore.add(Utils.chatColor("&7Set a home with &6/sethome <name>&7."));
        lore.add(Utils.chatColor("&7Example: &6/sethome base&7."));
        lore.add("");
        lore.add(Utils.chatColor("&fRewards:"));
        lore.add(Utils.chatColor("&7- $500"));
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(12, item);
    }

    private void setObjectiveFourConstants() {
        lore.add("");
        lore.add(Utils.chatColor("&fDetails:"));
        lore.add(Utils.chatColor("&7Claim some land with the &6golden"));
        lore.add(Utils.chatColor("&6shovel&7, or with &6/claim&7."));
        lore.add("");
        lore.add(Utils.chatColor("&fRewards:"));
        lore.add(Utils.chatColor("&7- $500"));
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(13, item);
    }

    private void setObjectiveFiveConstants() {
        lore.add("");
        lore.add(Utils.chatColor("&fDetails:"));
        lore.add(Utils.chatColor("&7View the PlayerWarps with &6/pwarp&7."));
        lore.add("");
        lore.add(Utils.chatColor("&fRewards:"));
        lore.add(Utils.chatColor("&7- $500"));
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(14, item);
    }

    private void setObjectiveSixConstants() {
        lore.add("");
        lore.add(Utils.chatColor("&fDetails:"));
        lore.add(Utils.chatColor("&7Visit &6/warp resource&7."));
        lore.add("");
        lore.add(Utils.chatColor("&fRewards:"));
        lore.add(Utils.chatColor("&7- $500"));
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(15, item);
    }

    private void setObjectiveSevenConstants() {
        lore.add("");
        lore.add(Utils.chatColor("&fDetails:"));
        lore.add(Utils.chatColor("&7Visit &6/warp crates&7."));
        lore.add("");
        lore.add(Utils.chatColor("&fRewards:"));
        lore.add(Utils.chatColor("&7- $500"));
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(16, item);
    }

    private void setObjectiveEightConstants() {
        lore.add("");
        lore.add(Utils.chatColor("&fDetails:"));
        lore.add(Utils.chatColor("&7Use &6/store&7."));
        lore.add("");
        lore.add(Utils.chatColor("&fRewards:"));
        lore.add(Utils.chatColor("&7- $500"));
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(19, item);
    }

    private void setObjectiveNineConstants() {
        lore.add("");
        lore.add(Utils.chatColor("&fDetails:"));
        lore.add(Utils.chatColor("&7Voting gives you awesome rewards!"));
        lore.add(Utils.chatColor("&7See the vote menu with &6/vote&7."));
        lore.add("");
        lore.add(Utils.chatColor("&fRewards:"));
        lore.add(Utils.chatColor("&7- $500"));
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(20, item);
    }

    private void setObjectiveTenConstants() {
        lore.add("");
        lore.add(Utils.chatColor("&fDetails:"));
        lore.add(Utils.chatColor("&7Use &6/help &7to access the help menu."));
        lore.add("");
        lore.add(Utils.chatColor("&7The help menu contains important server"));
        lore.add(Utils.chatColor("&7information. Reference it whenever you"));
        lore.add(Utils.chatColor("&7need help!"));
        lore.add("");
        lore.add(Utils.chatColor("&fRewards:"));
        lore.add(Utils.chatColor("&7- $500"));
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(21, item);
    }

    private void setSkipTutorialConstants() {
        lore.add("");
        lore.add(Utils.chatColor("&cThis is not recommended!"));
        lore.add("");
        lore.add(Utils.chatColor("&7The tutorial provides important"));
        lore.add(Utils.chatColor("&7fundamental info about the server"));
        lore.add(Utils.chatColor("&7to help you get started. It's also"));
        lore.add(Utils.chatColor("&7super easy to complete and rewards you!"));
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(25, item);
    }

    //------------ UPDATING PROGRESS STATUS FOR OBJECTIVES ------------

    public void completeObjectiveOne(boolean completed) {
        if (completed) {
            lore.clear();
            item.setType(Material.LIME_CONCRETE);
            meta.setDisplayName(Utils.chatColor("&aObjective 1 - COMPLETED"));
            setObjectiveOneConstants();

            lore.clear();
            item.setType(Material.ORANGE_CONCRETE);
            meta.setDisplayName(Utils.chatColor("&aObjective 2 - IN PROGRESS"));
            setObjectiveTwoConstants();

        } else {
            lore.clear();
            item.setType(Material.ORANGE_CONCRETE);
            meta.setDisplayName(Utils.chatColor("&aObjective 1 - IN PROGRESS"));
            setObjectiveOneConstants();
        }
    }

    public void completeObjectiveTwo(boolean completed) {
        if (completed) {
            lore.clear();
            item.setType(Material.LIME_CONCRETE);
            meta.setDisplayName(Utils.chatColor("&aObjective 2 - COMPLETED"));
            setObjectiveTwoConstants();

            lore.clear();
            item.setType(Material.ORANGE_CONCRETE);
            meta.setDisplayName(Utils.chatColor("&aObjective 3 - IN PROGRESS"));
            setObjectiveThreeConstants();

        } else {
            if (this.inv.getItem(10).getType().equals(Material.LIME_CONCRETE)) {
                lore.clear();
                item.setType(Material.ORANGE_CONCRETE);
                meta.setDisplayName(Utils.chatColor("&aObjective 2 - IN PROGRESS"));
                setObjectiveTwoConstants();
            } else {
                lore.clear();
                item.setType(Material.RED_CONCRETE);
                meta.setDisplayName(Utils.chatColor("&aObjective 2"));
                setObjectiveTwoConstants();
            }
        }
    }

    public void completeObjectiveThree(boolean completed) {
        if (completed) {
            lore.clear();
            item.setType(Material.LIME_CONCRETE);
            meta.setDisplayName(Utils.chatColor("&aObjective 3 - COMPLETED"));
            setObjectiveThreeConstants();

            lore.clear();
            item.setType(Material.ORANGE_CONCRETE);
            meta.setDisplayName(Utils.chatColor("&aObjective 4 - IN PROGRESS"));
            setObjectiveFourConstants();

        } else {
            if (this.inv.getItem(11).getType().equals(Material.LIME_CONCRETE)) {
                lore.clear();
                item.setType(Material.ORANGE_CONCRETE);
                meta.setDisplayName(Utils.chatColor("&aObjective 3 - IN PROGRESS"));
                setObjectiveThreeConstants();
            } else {
                lore.clear();
                item.setType(Material.RED_CONCRETE);
                meta.setDisplayName(Utils.chatColor("&aObjective 3"));
                setObjectiveThreeConstants();
            }
        }

    }

    public void completeObjectiveFour(boolean completed) {
        if (completed) {
            lore.clear();
            item.setType(Material.LIME_CONCRETE);
            meta.setDisplayName(Utils.chatColor("&aObjective 4 - COMPLETED"));
            setObjectiveFourConstants();

            lore.clear();
            item.setType(Material.ORANGE_CONCRETE);
            meta.setDisplayName(Utils.chatColor("&aObjective 5 - IN PROGRESS"));
            setObjectiveFiveConstants();

        } else {
            if (this.inv.getItem(12).getType().equals(Material.LIME_CONCRETE)) {
                lore.clear();
                item.setType(Material.ORANGE_CONCRETE);
                meta.setDisplayName(Utils.chatColor("&aObjective 4 - IN PROGRESS"));
                setObjectiveFourConstants();
            } else {
                lore.clear();
                item.setType(Material.RED_CONCRETE);
                meta.setDisplayName(Utils.chatColor("&aObjective 4"));
                setObjectiveFourConstants();
            }
        }

    }

    public void completeObjectiveFive(boolean completed) {
        if (completed) {
            lore.clear();
            item.setType(Material.LIME_CONCRETE);
            meta.setDisplayName(Utils.chatColor("&aObjective 5 - COMPLETED"));
            setObjectiveFiveConstants();

            lore.clear();
            item.setType(Material.ORANGE_CONCRETE);
            meta.setDisplayName(Utils.chatColor("&aObjective 6 - IN PROGRESS"));
            setObjectiveSixConstants();

        } else {
            if (this.inv.getItem(13).getType().equals(Material.LIME_CONCRETE)) {
                lore.clear();
                item.setType(Material.ORANGE_CONCRETE);
                meta.setDisplayName(Utils.chatColor("&aObjective 5 - IN PROGRESS"));
                setObjectiveFiveConstants();
            } else {
                lore.clear();
                item.setType(Material.RED_CONCRETE);
                meta.setDisplayName(Utils.chatColor("&aObjective 5"));
                setObjectiveFiveConstants();
            }
        }

    }

    public void completeObjectiveSix(boolean completed) {
        if (completed) {
            lore.clear();
            item.setType(Material.LIME_CONCRETE);
            meta.setDisplayName(Utils.chatColor("&aObjective 6 - COMPLETED"));
            setObjectiveSixConstants();

            lore.clear();
            item.setType(Material.ORANGE_CONCRETE);
            meta.setDisplayName(Utils.chatColor("&aObjective 7 - IN PROGRESS"));
            setObjectiveSevenConstants();

        } else {
            if (this.inv.getItem(14).getType().equals(Material.LIME_CONCRETE)) {
                lore.clear();
                item.setType(Material.ORANGE_CONCRETE);
                meta.setDisplayName(Utils.chatColor("&aObjective 6 - IN PROGRESS"));
                setObjectiveSixConstants();
            } else {
                lore.clear();
                item.setType(Material.RED_CONCRETE);
                meta.setDisplayName(Utils.chatColor("&aObjective 6"));
                setObjectiveSixConstants();
            }
        }
    }

    public void completeObjectiveSeven(boolean completed) {
        if (completed) {
            lore.clear();
            item.setType(Material.LIME_CONCRETE);
            meta.setDisplayName(Utils.chatColor("&aObjective 7 - COMPLETED"));
            setObjectiveSevenConstants();

            lore.clear();
            item.setType(Material.ORANGE_CONCRETE);
            meta.setDisplayName(Utils.chatColor("&aObjective 8 - IN PROGRESS"));
            setObjectiveEightConstants();

        } else {
            if (this.inv.getItem(15).getType().equals(Material.LIME_CONCRETE)) {
                lore.clear();
                item.setType(Material.ORANGE_CONCRETE);
                meta.setDisplayName(Utils.chatColor("&aObjective 7 - IN PROGRESS"));
                setObjectiveSevenConstants();
            } else {
                lore.clear();
                item.setType(Material.RED_CONCRETE);
                meta.setDisplayName(Utils.chatColor("&aObjective 7"));
                setObjectiveSevenConstants();
            }
        }
    }

    public void completeObjectiveEight(boolean completed) {
        if (completed) {
            lore.clear();
            item.setType(Material.LIME_CONCRETE);
            meta.setDisplayName(Utils.chatColor("&aObjective 8 - COMPLETED"));
            setObjectiveEightConstants();

            lore.clear();
            item.setType(Material.ORANGE_CONCRETE);
            meta.setDisplayName(Utils.chatColor("&aObjective 9 - IN PROGRESS"));
            setObjectiveNineConstants();

        } else {
            if (this.inv.getItem(16).getType().equals(Material.LIME_CONCRETE)) {
                lore.clear();
                item.setType(Material.ORANGE_CONCRETE);
                meta.setDisplayName(Utils.chatColor("&aObjective 8 - IN PROGRESS"));
                setObjectiveEightConstants();
            } else {
                lore.clear();
                item.setType(Material.RED_CONCRETE);
                meta.setDisplayName(Utils.chatColor("&aObjective 8"));
                setObjectiveEightConstants();
            }
        }
    }

    public void completeObjectiveNine(boolean completed) {
        if (completed) {
            lore.clear();
            item.setType(Material.LIME_CONCRETE);
            meta.setDisplayName(Utils.chatColor("&aObjective 9 - COMPLETED"));
            setObjectiveNineConstants();

            lore.clear();
            item.setType(Material.ORANGE_CONCRETE);
            meta.setDisplayName(Utils.chatColor("&aObjective 10 - IN PROGRESS"));
            setObjectiveTenConstants();

        } else {
            if (this.inv.getItem(19).getType().equals(Material.LIME_CONCRETE)) {
                lore.clear();
                item.setType(Material.ORANGE_CONCRETE);
                meta.setDisplayName(Utils.chatColor("&aObjective 9 - IN PROGRESS"));
                setObjectiveNineConstants();
            } else {
                lore.clear();
                item.setType(Material.RED_CONCRETE);
                meta.setDisplayName(Utils.chatColor("&aObjective 9"));
                setObjectiveNineConstants();
            }
        }

    }

    public void completeObjectiveTen(boolean completed) {
        if (completed) {
            lore.clear();
            item.setType(Material.LIME_CONCRETE);
            meta.setDisplayName(Utils.chatColor("&aObjective 10 - COMPLETED"));
            setObjectiveTenConstants();

        } else {
            if (this.inv.getItem(20).getType().equals(Material.LIME_CONCRETE)) {
                lore.clear();
                item.setType(Material.ORANGE_CONCRETE);
                meta.setDisplayName(Utils.chatColor("&aObjective 10 - IN PROGRESS"));
                setObjectiveTenConstants();
            } else {
                lore.clear();
                item.setType(Material.RED_CONCRETE);
                meta.setDisplayName(Utils.chatColor("&aObjective 10"));
                setObjectiveTenConstants();
            }
        }
    }

    //Getters
    public Inventory getInv() {
        return inv;
    }
}
