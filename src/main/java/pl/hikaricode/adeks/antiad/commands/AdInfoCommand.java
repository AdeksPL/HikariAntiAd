package pl.hikaricode.adeks.antiad.commands;

import org.bukkit.entity.Player;
import pl.hikaricode.adeks.antiad.abstracts.Filter;
import pl.hikaricode.adeks.antiad.abstracts.Searcher;
import pl.hikaricode.adeks.antiad.annotations.CommandInfo;
import pl.hikaricode.adeks.antiad.basic.AntiAd;
import pl.hikaricode.adeks.antiad.command.PluginCommand;


@CommandInfo(name = "adinfo",
            description = "Informacje, spis filtrow oraz searcherow",
            aliases = {"filters", "searchers"},
            permission = "hikari.adinfo",
            usage = "/info" )
public class AdInfoCommand extends PluginCommand {
    @Override
    public void execute(Player p, String[] args) {

        StringBuilder filters = new StringBuilder();
        Filter.getFilters().forEach(filter ->  filters.append(filter.getName()).append(", "));
        String filtersStrList = filters.substring(0, filters.length() - 2);


        final StringBuilder searchers = new StringBuilder();
        Searcher.getSearchers().forEach(searcher -> searchers.append(searcher.getName()).append(", ")); // lambda jest wolniejsza o 10 razy od fora (o ile nie wiecej)
        String searcherStrList = searchers.substring(0, searchers.length() - 2);

        p.sendMessage(
                AntiAd.getMessages().getInfoMessage()
                .replaceAll("%filters%", filtersStrList)
                .replaceAll("%searchers%", searcherStrList)
        ); // do tego pewnie by sie dalo przyczepić - można zmienić wiadomości zaraz po loadzie :)

    }
}
