package pl.hikaricode.adeks.antiad.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.Arrays;
import java.util.List;

public class BukkitCommand extends Command {

    private PluginCommand command;


    BukkitCommand(PluginCommand c) {
        super(c.getName(), c.getDescription(), c.getUsage(), Arrays.asList(c.getAliases()));
        command = c;
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
            if(sender instanceof Player) {
                this.command.run((Player)sender, args);
                return true;
            }
            sender.sendMessage("Nie jestes graczem");
            return false;
    }
}
