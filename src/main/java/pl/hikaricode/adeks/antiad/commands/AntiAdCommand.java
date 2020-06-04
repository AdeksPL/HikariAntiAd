package pl.hikaricode.adeks.antiad.commands;

import org.bukkit.entity.Player;
import pl.hikaricode.adeks.antiad.abstracts.Filter;
import pl.hikaricode.adeks.antiad.abstracts.Searcher;
import pl.hikaricode.adeks.antiad.annotations.CommandInfo;
import pl.hikaricode.adeks.antiad.command.PluginCommand;


@CommandInfo(name = "antiad",
            description = "O pluginie hikariantiad",
            aliases = {},
            permission = "",
            usage = "/antiad" )
public class AntiAdCommand extends PluginCommand {
    @Override
    public void execute(Player p, String[] args) {
        p.sendMessage("§c§m----------§f    §8[§cHikariAntiAd§8]    §c§m----------");
        p.sendMessage("");
        p.sendMessage("§7Plugin §cHikariAntiAd §7stworzyl §cAdeksPL");
        p.sendMessage("§7Wersja §8[§a1.0-SNAPSHOT§8]");
        p.sendMessage("");
        p.sendMessage("§c§m----------§f    §8[§cHikariAntiAd§8]    §c§m----------"); // nie ma replace, jaka szkoda

    }
}
