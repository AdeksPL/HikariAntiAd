package pl.hikaricode.adeks.antiad.filters;

import pl.hikaricode.adeks.antiad.abstracts.Filter;
import pl.hikaricode.adeks.antiad.annotations.FilterInfo;


@FilterInfo(name = "EASY")
public class EASYFilter extends Filter {

    private String alfabet = "abcdefghijklmnoprstuwxyzvq"; // polish

    @Override
    public String use(String reklama) { // polish
        reklama = reklama.toLowerCase();
        StringBuilder clear = new StringBuilder();
        for(char c: reklama.toCharArray()) if(alfabet.contains(c+"")) clear.append(c);
        return clear.toString();
    }
}
