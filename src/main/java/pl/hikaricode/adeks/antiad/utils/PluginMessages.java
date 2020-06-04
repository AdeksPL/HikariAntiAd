package pl.hikaricode.adeks.antiad.utils;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.configuration.file.FileConfiguration;
import pl.hikaricode.adeks.antiad.basic.AntiAd;

@Getter
@Setter
public class PluginMessages {

    private final FileConfiguration config;

    private final String noAdMessage;
    private final String infoMessage;
    private final String adminSeeMessage;

    private final String noPermission;



    public PluginMessages() {
        this.config = AntiAd.getPlugin().getConfig();
        this.noAdMessage = ChatUtil.change(this.config.getString("NoAdMessage"));
        this.infoMessage = ChatUtil.change(this.config.getString("InfoMessage"));
        this.adminSeeMessage = ChatUtil.change(this.config.getString("AdminSeeMessage"));
        this.noPermission = ChatUtil.change(this.config.getString("NoPermission"));
    }


}
