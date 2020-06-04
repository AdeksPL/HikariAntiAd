package pl.hikaricode.adeks.antiad.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//trolololo programisci nie ma tego drugiego
@Retention(RetentionPolicy.RUNTIME)
public @interface CommandInfo {
    String name();
    String description();
    String[] aliases();
    String permission();
    String usage();
}
