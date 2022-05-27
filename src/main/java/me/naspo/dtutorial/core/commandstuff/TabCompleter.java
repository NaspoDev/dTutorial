package me.naspo.dtutorial.core.commandstuff;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class TabCompleter implements org.bukkit.command.TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("tutorial")) {
            if (sender.hasPermission("tutorial.reload")) {

                //TabCompleter args for 1st arg
                List<String> arguments1 = new ArrayList<>();
                arguments1.add("reload");

                //TabCompleter args for 2nd arg
                List<String> arguments2 = new ArrayList<>();
                arguments2.add("config");
                arguments2.add("all");

                //Logic for 1st arg
                List<String> result = new ArrayList<>();
                if (args.length == 1) {
                    for (String s : arguments1) {
                        if (s.toLowerCase().startsWith(args[0].toLowerCase())) {
                            result.add(s);
                        }
                    }
                    return result;
                }

                //Logic for 2nd arg
                if (args.length == 2) {
                    for (String s : arguments2) {
                        if (s.toLowerCase().startsWith(args[1].toLowerCase())) {
                            result.add(s);
                        }
                    }
                    return result;
                }
            }
        }
        return null;
    }
}
