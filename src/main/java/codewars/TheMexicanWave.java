package codewars;

/*
In this simple Kata your task is to create a function that turns a string into a Mexican Wave. You will be passed a
string and you must return that string in an array where an uppercase letter is a person standing up.
 */

import java.util.Arrays;
import java.util.stream.IntStream;

public class TheMexicanWave {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(wave("mexican wave")));
    }

    public static String[] wave(String str) {
        return IntStream
                .range(0, str.length())
                .mapToObj(value -> new StringBuilder(str).replace(value,value + 1,String.valueOf(str.charAt(value)).toUpperCase()).toString())
                .filter(s -> !s.equals(str))
                .toArray(String[]::new);
    }
}
