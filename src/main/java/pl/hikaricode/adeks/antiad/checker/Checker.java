package pl.hikaricode.adeks.antiad.checker;

import lombok.Getter;
import org.bukkit.configuration.file.YamlConfiguration;
import pl.hikaricode.adeks.antiad.abstracts.Filter;
import pl.hikaricode.adeks.antiad.abstracts.Searcher;
import pl.hikaricode.adeks.antiad.basic.AntiAd;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Checker {

    private String checkerName;
    private List<String> filters;
    private List<String> searchers;
    private List<String> ads;
    private List<String> types;


    public Checker(String checker){

        this.checkerName = checker;
        File f = new File("plugins/"+AntiAd.getPlugin().getDataFolder().getName()+"/checkers/"+checker); // potem musze dodac te foldery
        YamlConfiguration c = YamlConfiguration.loadConfiguration(f);

        this.filters = c.getStringList("filters");
        this.searchers = c.getStringList("searchers");
        this.ads = c.getStringList("ads");
        this.types = c.getStringList("types");
    }

    public boolean isAd(String ad){
        for(String filter:filters){ // nie ma spacji po for ani przed nawiasem
            Filter f = Filter.getFilter(filter);
            ad = f.use(ad);
        }

        boolean check = false;
        for(String sear:searchers){ // nie ma spacji po for ani przed nawiasem
            Searcher s = Searcher.getSearcher(sear);
            check = check || s.isAd(ad,ads);
        }
        return check;
    }

    @Getter
    private static List<Checker> checkerList = new ArrayList<>();

    public static List<Checker> getCheckers() {
        return checkerList;
    }
}
