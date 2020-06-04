package pl.hikaricode.adeks.antiad.annotations;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface FilterInfo {
    String name();
}
