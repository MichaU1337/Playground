package codewars;

import java.util.List;
import java.util.stream.Collectors;

public class ListFiltering {



    public static List<Object> filterList(final List<Object> list) {
        return list.stream().filter(o -> !o.getClass().equals(String.class)).collect(Collectors.toList());
    }

    public static List<Object> filterList2(final List<Object> list) {
        return list.stream()
                .filter(e -> e instanceof Integer)
                .collect(Collectors.toList());
    }
}
