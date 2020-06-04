package pl.hikaricode.adeks.antiad.command;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;
import pl.hikaricode.adeks.antiad.annotations.CommandInfo;
import pl.hikaricode.adeks.antiad.basic.AntiAd;


@Getter
@Setter
public abstract class PluginCommand {

    private String name;
    private String[] aliases;
    private String description;
    private String permission;
    private String usage;


    public PluginCommand(){

        CommandInfo info = getClass().getDeclaredAnnotation(CommandInfo.class);
        name = info.name();
        permission = info.permission();
        aliases = info.aliases();
        description = info.description();
        usage = info.usage();
    }


    public void run(Player p, String... args){
        if(permission!=null && (permission.equals("") || p.hasPermission(permission))){
            this.execute(p, args);
            return;
        }
        p.sendMessage(AntiAd.getMessages().getNoPermission().replaceAll("%command%",name));


    }

    public abstract void execute(Player p, String[] args);

}
