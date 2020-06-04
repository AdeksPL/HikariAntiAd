package pl.hikaricode.adeks.antiad.searcher;

import pl.hikaricode.adeks.antiad.abstracts.Searcher;
import pl.hikaricode.adeks.antiad.annotations.SearcherInfo;

import java.util.List;


@SearcherInfo(name = "LCS")
public class LCSSearcher extends Searcher {
    @Override
    public boolean isAd(String msg, List<String> list) {

        //
        // Algorytm LCS
        //

        // Wiekszosc ignorantow powie ze to syf kod
        for(String s:list){
            if(s.length() > msg.length()) continue;
            else if(s.length() == msg.length())
                if(s.equals(msg)) return true;
                else continue;

            //na chacie mozna umiescic 100 znakow wiec byte wystarczy (zakres -128,127)
            byte[][] c = new byte[s.length()+1][msg.length()+1];

            for(int i = 1 ;i <= s.length(); i++){
                for(int j = 1; j <= msg.length(); j++){
                    if(s.charAt(i-1) == msg.charAt(j-1))
                        c[i][j] = (byte) (c[i-1][j-1] + 1);
                    else
                        c[i][j] = (byte) Math.max(c[i-1][j], c[i][j-1]);
                }
            }
            if(s.length() == c[s.length()][msg.length()]) return true;
        }


        return false;
    }
}
