package pl.hikaricode.adeks.antiad.abstracts;

import lombok.Getter;
import lombok.Setter;
import pl.hikaricode.adeks.antiad.annotations.FilterInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public abstract class Filter {


    private String name;

    private static List<Filter> filters = new ArrayList<Filter>();

    public static Filter getFilter(String filter) {
        return filters.stream().filter(f -> f.getName().equalsIgnoreCase(filter)).findFirst().orElse(null);
    }

    public static List<Filter> getFilters() {
        return filters;
    }
    public static void addFilters(Filter... filter) {
        filters.addAll(Arrays.asList(filter));
    }

    public abstract String use(String ad);

    public Filter(){
        FilterInfo info = getClass().getDeclaredAnnotation(FilterInfo.class);
        this.name = info.name();
    }

}
