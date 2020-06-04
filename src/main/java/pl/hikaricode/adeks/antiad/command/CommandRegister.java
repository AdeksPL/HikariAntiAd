package pl.hikaricode.adeks.antiad.command;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.plugin.SimplePluginManager;
import pl.hikaricode.adeks.antiad.basic.AntiAd;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

@Getter
public class CommandRegister {
    private CommandMap commandMap;


    public CommandRegister(){
        try {
            Method m = Arrays.asList(Bukkit.class.getDeclaredMethods())
                    .stream()
                    .filter(method -> method.getName().equalsIgnoreCase("getCommandMap"))
                    .findFirst()
                    .orElse(null);

            if (m != null)
                this.commandMap = Bukkit.getCommandMap();
            else {
                SimplePluginManager simplePluginManager = (SimplePluginManager) AntiAd.getPlugin().getServer().getPluginManager();
                Field field = SimplePluginManager.class.getDeclaredField("commandMap");
                field.setAccessible(true);
                this.commandMap = (CommandMap) field.get(simplePluginManager);
                field.setAccessible(false);
            }
        }catch (Exception e){
            AntiAd.getPlugin().getLogger().warning("Pluginu HikariAntiAd nie udalo sie zaladowac, zaktualizuj silnik na spigot");
        }

    }


    public void register(PluginCommand cmd){
        commandMap.register(cmd.getName(), new BukkitCommand(cmd));
    }

}
