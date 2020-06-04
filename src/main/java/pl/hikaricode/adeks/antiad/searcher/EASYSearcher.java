package pl.hikaricode.adeks.antiad.searcher;

import pl.hikaricode.adeks.antiad.abstracts.Searcher;
import pl.hikaricode.adeks.antiad.annotations.SearcherInfo;

import java.util.List;


@SearcherInfo(name = "EASY")
public class EASYSearcher extends Searcher {
    @Override
    public boolean isAd(String msg, List<String> list) {
        boolean contains = false;
        for(String s:list)
                contains = contains || msg.contains(s);
        return contains;
    }
}
