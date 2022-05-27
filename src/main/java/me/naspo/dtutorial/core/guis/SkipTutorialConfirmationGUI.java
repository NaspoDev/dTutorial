package me.naspo.dtutorial.core.guis;

import me.naspo.dtutorial.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class SkipTutorialConfirmationGUI {
    private Inventory inv;
    private ItemStack item;
    private ItemMeta meta;
    private List<String> lore;

    public SkipTutorialConfirmationGUI() {
        item = new ItemStack(Material.GREEN_CONCRETE);
        meta = item.getItemMeta();
        lore = new ArrayList<>();

        setupInv();
    }

    //Create the inventory.
    private void setupInv() {
        inv = Bukkit.createInventory(null, 9, Utils.chatColor("&c&lAre you sure?"));

        //Confirm skip
        meta.setDisplayName(Utils.chatColor("&aSkip The Tutorial"));
        lore.add("");
        lore.add(Utils.chatColor("&7Yes I am sure I want"));
        lore.add(Utils.chatColor("&7to skip the tutorial."));

        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(3, item);

        lore.clear();
        //Cancel skip
        item.setType(Material.RED_CONCRETE);
        meta.setDisplayName(Utils.chatColor("&cCancel"));
        lore.add("");
        lore.add(Utils.chatColor("&7Never mind, I don't want"));
        lore.add(Utils.chatColor("&7to skip the tutorial."));

        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(5, item);

        lore.clear();
        //Set fillers
        item.setType(Material.GRAY_STAINED_GLASS_PANE);
        meta.setDisplayName(" ");
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);

        inv.setItem(0, item);
        inv.setItem(1, item);
        inv.setItem(2, item);
        inv.setItem(4, item);
        inv.setItem(6, item);
        inv.setItem(7, item);
        inv.setItem(8, item);
    }

    //Getters
    public Inventory getInv() {
        return inv;
    }
}
