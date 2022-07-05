package codewars;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FindNeedle {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("qwe");
        list.add("needle");
        Object[] objects = list.toArray();
        findNeedle(objects);
    }

    public static String findNeedle(Object[] haystack) {
        return IntStream.range(0, haystack.length)
                .filter(i -> haystack[i] == "needle")
                .mapToObj(i -> "found the needle at position " + i)
                .findFirst().get();
    }

    public static String findNeedle2(Object[] haystack) {
        return String.format("found the needle at position %d", java.util.Arrays.asList(haystack).indexOf("needle"));
    }
}
