package pl.hikaricode.adeks.antiad.basic;

import lombok.Getter;
import lombok.Setter;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import pl.hikaricode.adeks.antiad.abstracts.Filter;
import pl.hikaricode.adeks.antiad.abstracts.Searcher;

import pl.hikaricode.adeks.antiad.checker.Checker;
import pl.hikaricode.adeks.antiad.command.CommandRegister;
import pl.hikaricode.adeks.antiad.commands.AntiAdCommand;
import pl.hikaricode.adeks.antiad.commands.AdInfoCommand;
import pl.hikaricode.adeks.antiad.filters.EASYFilter;
import pl.hikaricode.adeks.antiad.listeners.AntiAdListeners;
import pl.hikaricode.adeks.antiad.searcher.EASYSearcher;
import pl.hikaricode.adeks.antiad.searcher.LCSSearcher;
import pl.hikaricode.adeks.antiad.searcher.SPECIALSearcher;
import pl.hikaricode.adeks.antiad.utils.PluginMessages;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;

public class AntiAd extends JavaPlugin {

    @Getter
    @Setter
    public static AntiAd plugin; // tak wiem, iż może być AntiAd.getPlugin(this)
    @Getter
    @Setter
    public static PluginMessages messages;

    public void example1Load(){ // <- oj ale brzydko, nie ma spacji przed {
        File f = new File("plugins/"+AntiAd.getPlugin().getDataFolder().getName()+"/examples/EASYChecker.adeks");
        YamlConfiguration c = YamlConfiguration.loadConfiguration(f);

        List<String> filters = new ArrayList<String>();
        filters.add("EASY");

        List<String> searchers = new ArrayList<String>();
        searchers.add("EASY");

        List<String> ads = new ArrayList<String>();
        ads.add("coremaxpl");
        ads.add("dragonsurvivaleu");
        ads.add("hcpl");
        ads.add("mcpl");
        ads.add("enchpl");
        ads.add("tasrvcom");

        List<String> types = new ArrayList<String>();
        types.add("chat");
        types.add("command");

        c.set("filters", filters);
        c.set("searchers", searchers);
        c.set("ads", ads);
        c.set("types", types);
        try {
            c.save(f);
        }catch (Exception ignored){} // intelka xd
    }
    private void example2Load() {
        File f = new File("plugins/"+AntiAd.getPlugin().getDataFolder().getName()+"/examples/LCSChecker.adeks");
        YamlConfiguration c = YamlConfiguration.loadConfiguration(f);

        List<String> filters = new ArrayList<String>();
        filters.add("EASY");

        List<String> searchers = new ArrayList<String>();
        searchers.add("LCS");

        List<String> ads = new ArrayList<String>();
        ads.add("coremaxpl");
        ads.add("dragonsurvivaleu");
        ads.add("enchpl");
        ads.add("tasrvcom");
        ads.add("hcpl");
        ads.add("mcpl");
        ads.add("enchpl");
        ads.add("tasrvcom");

        List<String> types = new ArrayList<String>();
        types.add("anvil");

        c.set("filters", filters);
        c.set("searchers", searchers);
        c.set("ads", ads);
        c.set("types", types);
        try {
            c.save(f);
        }catch (Exception ignored){}
    }
    private void example3Load() {
        File f = new File("plugins/"+AntiAd.getPlugin().getDataFolder().getName()+"/examples/SPECIALChecker.adeks");
        YamlConfiguration c = YamlConfiguration.loadConfiguration(f);

        List<String> filters = new ArrayList<String>();
        List<String> searchers = new ArrayList<String>();
        searchers.add("SPECIAL");
        List<String> ads = new ArrayList<String>();
        List<String> types = new ArrayList<String>();
        types.add("chat");
        types.add("command");

        c.set("filters", filters);
        c.set("searchers", searchers);
        c.set("ads", ads);
        c.set("types", types);
        try {
            c.save(f);
        }catch (Exception ignored){}
    }

    public void onEnable(){


        saveDefaultConfig();

        plugin = this;
        messages = new PluginMessages();

        CommandRegister reg = new CommandRegister();

        Bukkit.getLogger().log(Level.WARNING, "Nie poprawne uzycie pluginu HikariAntiAd moze skutkowac zablokowaniem wszystkich wiadomosci lub nieblokowaniem reklam");
        Bukkit.getLogger().log(Level.WARNING, "Przykladowe rozwiazania w folderze examples moga blokowac czesc wiadomosci napisanych przez graczy [Z testów wiadomo ,że mała jest na to szansa]");

        reg.register(new AdInfoCommand());
        reg.register(new AntiAdCommand());

        Filter.addFilters(new EASYFilter());

        Searcher.addSearchers(new EASYSearcher(),
                              new LCSSearcher(),
                              new SPECIALSearcher());


        File folder = new File("plugins/"+this.getDataFolder().getName()+"/checkers");
        if(!folder.exists()) folder.mkdirs();
        File exfolder = new File("plugins/"+this.getDataFolder().getName()+"/examples"); // piekne nazewnictwo xDDDDD
        if(!exfolder.exists()) exfolder.mkdirs(); // fast

        this.example1Load();
        this.example2Load();
        this.example3Load();

        for(String file: Objects.requireNonNull(folder.list())){
            Checker.getCheckerList().add(new Checker(file));
        }

        Bukkit.getPluginManager().registerEvents(new AntiAdListeners(), this);

    }



    public void onDisable(){

    }


}
