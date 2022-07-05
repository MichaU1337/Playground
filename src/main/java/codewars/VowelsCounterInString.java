package codewars;

import java.util.List;

public class VowelsCounterInString {

    public static void main(String[] args) {
        System.out.println(getCount("hello world"));
    }

    public static int getCount(String str) {
        List<String> vowelList = List.of("a", "e", "i", "o", "u");
        return (int) str.chars().mapToObj(i -> String.valueOf((char) i)).filter(vowelList::contains).count();
    }

    public static int getCountRegex(String str) {
        return str.replaceAll("(?i)[^aeiou]", "").length();
    }
}
