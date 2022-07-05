package codewars;

import java.util.Arrays;
import java.util.stream.Collectors;

public class AbbreviateTwoWords {

    public static void main(String[] args) {
        System.out.println(abbrevName("Michal Mier"));
    }

    public static String abbrevName(String name) {
        return Arrays.stream(name.split("\\s+"))
                .map(s -> s.toUpperCase().charAt(0))
                .map(String::valueOf)
                .limit(2)
                .collect(Collectors.joining("."));
    }
}
