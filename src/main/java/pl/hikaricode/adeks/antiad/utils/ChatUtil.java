package pl.hikaricode.adeks.antiad.utils;

public class ChatUtil {

    public static String change(String msg){
        msg = msg.replace('&', '§').replaceAll(">>", "»").replaceAll("<<", "«").replaceAll("\\n","\n");
        return msg;
    }

}
