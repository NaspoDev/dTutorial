package me.naspo.dtutorial.core.guis;

import me.naspo.dtutorial.DTutorial;
import me.naspo.dtutorial.Utils;
import me.naspo.dtutorial.core.Tutorial;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class GUIEvents implements Listener {

    private GUI gui;
    private SkipTutorialConfirmationGUI skipTutorialConfirmationGUI;
    private DTutorial plugin;
    public GUIEvents(GUI gui, SkipTutorialConfirmationGUI skipTutorialConfirmationGUI, DTutorial plugin) {
        this.gui = gui;
        this.skipTutorialConfirmationGUI = skipTutorialConfirmationGUI;
        this.plugin = plugin;
    }

    //Denying click event for main gui, and checking for skip tutorial input.
    @EventHandler
    private void onClickMainGUI(InventoryClickEvent event) {
        if (event.getInventory().equals(
                Tutorial.tutorial.get(event.getWhoClicked().getUniqueId()).getGUI().getInv())) {
            event.setCancelled(true);

            if (event.getCurrentItem() != null) {
                if (event.getCurrentItem().getType().equals(Material.BARRIER)) {
                    if (event.getCurrentItem().getItemMeta().getDisplayName().contains("Skip the Tutorial")) {
                        if (event.getCurrentItem().getItemMeta().hasLore()) {
                            event.getWhoClicked().closeInventory();
                            event.getWhoClicked().openInventory(skipTutorialConfirmationGUI.getInv());
                            return;
                        }
                    }
                }
            }
            event.getWhoClicked().closeInventory();
        }
    }

    //Denying click event for skip confirmation gui, and checking for skip confirmation input.
    @EventHandler
    private void onClickSkipConfirmationGUI(InventoryClickEvent event) {
        if (event.getInventory().equals(skipTutorialConfirmationGUI.getInv())) {
            event.setCancelled(true);

            //Checking for skip confirmation.
            if (event.getCurrentItem() != null) {
                if (event.getCurrentItem().getType().equals(Material.GREEN_CONCRETE)) {
                    if (event.getCurrentItem().getItemMeta().getDisplayName().contains("Skip The Tutorial")) {
                        if (event.getCurrentItem().getItemMeta().hasLore()) {
                            event.getWhoClicked().closeInventory();
                            skipTheTutorial((Player) event.getWhoClicked());
                        }
                    }
                    return;
                }

                //Checking for cancel skip (do not skip) input.
                if (event.getCurrentItem().getType().equals(Material.RED_CONCRETE)) {
                    if (event.getCurrentItem().getItemMeta().getDisplayName().contains("Cancel")) {
                        if (event.getCurrentItem().getItemMeta().hasLore()) {
                            event.getWhoClicked().closeInventory();
                        }
                    }
                }
            }

        }
    }

    //Actually skips the tutorial. (Logic).
    private void skipTheTutorial(Player player) {
        Tutorial.tutorial.get(player.getUniqueId()).setCompletedOrSkipped(true);
        player.sendMessage(Utils.chatColor(Utils.prefix +
                plugin.getConfig().getString("messages.tutorial-was-skipped")));
        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_PLACE, 0.5f, 1.0f);
    }
}
