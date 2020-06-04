package pl.hikaricode.adeks.antiad.abstracts;

import lombok.Getter;
import lombok.Setter;
import pl.hikaricode.adeks.antiad.annotations.SearcherInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Getter
@Setter
public abstract class Searcher {

    private String name;

    private static List<Searcher> searchers = new ArrayList<>();

    public static Searcher getSearcher(String sear) {

        return searchers.stream().filter(sr -> sr.getName().equalsIgnoreCase(sear)).findFirst().orElse(null);
    }

    public static void addSearchers(Searcher... sear) {
        searchers.addAll(Arrays.asList(sear));
    }

    public static List<Searcher> getSearchers() {
        return searchers;
    }

    public abstract boolean isAd(String msg, List<String> list);

    public Searcher(){
        name = getClass().getDeclaredAnnotation(SearcherInfo.class).name();
    }

}
