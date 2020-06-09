package pl.hikaricode.adeks.antiad.searcher;

import pl.hikaricode.adeks.antiad.abstracts.Searcher;
import pl.hikaricode.adeks.antiad.annotations.SearcherInfo;

import java.util.List;

    @SearcherInfo(name = "SPECIAL")
    public class SPECIALSearcher extends Searcher {


        @Override
        public boolean isAd(String msg, List<String> list) {

            // tak, dalo sie lepiej to zrobic lecz jestem leniem :)
            String alphabet = "\"abcdefghijklmnoprstuwyzxqvABCDEFGHIJKLMNOPRSTUQWXYZV0123456789łąęĄŁĘÓó!@#$%^&*()_+=-{}[]:|;\'\\<>?,./ `";
            int tmp = 1;
            for (char c:msg.toCharArray()){
                if (!alphabet.contains(c+"")) return true;
                tmp ++;
            }
            return false;
        }
    }

