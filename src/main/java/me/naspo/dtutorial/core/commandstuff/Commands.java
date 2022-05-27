package me.naspo.dtutorial.core.commandstuff;

import me.naspo.dtutorial.DTutorial;
import me.naspo.dtutorial.Utils;
import me.naspo.dtutorial.core.Tutorial;
import me.naspo.dtutorial.filemanagement.DataFiles;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

    private DTutorial plugin;
    private DataFiles dataFiles;
    public Commands(DTutorial plugin, DataFiles dataFiles) {
        this.plugin = plugin;
        this.dataFiles = dataFiles;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("tutorial")) {

            // --- CONSOLE COMMAND STUFF ---

            if (!(sender instanceof Player)) {
                if (args.length == 0) {
                    sender.sendMessage("Did you mean /tutorial reload?");
                    return true;
                }
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("reload")) {
                        sender.sendMessage("Usage: /tutorial reload <config|all>");
                        return true;
                    }
                }
                if (args[0].equalsIgnoreCase("reload")) {
                    if (args[1].equalsIgnoreCase("config")) {
                        Utils.reloadConfigs();
                        sender.sendMessage("dTutorial configuration has been reloaded.");
                    } else if (args[1].equalsIgnoreCase("all")) {
                        Utils.reloadConfigs();
                        dataFiles.reloadAllFiles();
                        sender.sendMessage("All dTutorial files have been reloaded.");
                    } else {
                        sender.sendMessage("Usage: /tutorial reload <config|all>");
                    }
                }
                return true;
            }

            // --- PLAYER COMMAND STUFF ---

            Player player = (Player) sender;

            //Open tutorial gui.
            if (args.length == 0) {
                if (Tutorial.tutorial.containsKey(player.getUniqueId())) {
                    if (!(Tutorial.tutorial.get(player.getUniqueId()).getCompletedOrSkipped())) {
                        player.openInventory(Tutorial.tutorial.get(player.getUniqueId()).getGUI().getInv());
                        return true;
                    }
                }
                //If they are not on the hashmap or have completed/skipped the tutorial, deny them.
                player.sendMessage(Utils.chatColor(Utils.prefix + plugin.getConfig().getString(
                        "messages.not-eligible")));
                return true;
            }

            // --- Reload Command ---

            //Permission check.
            if (args[0].equalsIgnoreCase("reload")) {
                if (!(player.hasPermission("dtutorial.reload"))) {
                    player.sendMessage(Utils.chatColor(Utils.prefix +
                            plugin.getConfig().getString("messages.no-permission")));
                    return true;
                }

                //Bad reload usage check.
                if (args.length == 1) {
                    player.sendMessage(Utils.chatColor(Utils.prefix +
                            plugin.getConfig().getString("messages.bad-reload-usage")));
                    return true;
                }

                //Reload config.
                if (args[1].equalsIgnoreCase("config")) {
                    Utils.reloadConfigs();
                    player.sendMessage(Utils.chatColor(Utils.prefix +
                            plugin.getConfig().getString("messages.reload-config")));

                    //Reload all.
                } else if (args[1].equalsIgnoreCase("all")) {
                    Utils.reloadConfigs();
                    dataFiles.reloadAllFiles();
                    player.sendMessage(Utils.chatColor(Utils.prefix +
                            plugin.getConfig().getString("messages.reload-all")));

                    //Bad reload usage.
                } else {
                    player.sendMessage(Utils.chatColor(Utils.prefix +
                            plugin.getConfig().getString("messages.bad-reload-usage")));
                    return true;
                }
            }
        }

        return false;
    }
}
