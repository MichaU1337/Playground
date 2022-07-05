package codewars;

/*
    You are given an array(list) strarr of strings and an integer k. Your task is to return the first longest string consisting of k consecutive strings taken in the array.

    strarr = ["tree", "foling", "trashy", "blue", "abcdef", "uvwxyz"], k = 2

    Concatenate the consecutive strings of strarr by 2, we get:

    treefoling   (length 10)  concatenation of strarr[0] and strarr[1]
    folingtrashy ("      12)  concatenation of strarr[1] and strarr[2]
    trashyblue   ("      10)  concatenation of strarr[2] and strarr[3]
    blueabcdef   ("      10)  concatenation of strarr[3] and strarr[4]
    abcdefuvwxyz ("      12)  concatenation of strarr[4] and strarr[5]

    Two strings are the longest: "folingtrashy" and "abcdefuvwxyz".
    The first that came is "folingtrashy" so
    longest_consec(strarr, 2) should return "folingtrashy".

    In the same way:
    longest_consec(["zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"], 2) --> "abigailtheta"
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConsecutiveStrings {

    public static void main(String[] args) {
        String[] arr = {"tree", "foling", "trashy", "blue", "abcdef", "uvwxyz"};
        System.out.println(longestConsec(arr, 2));
        System.out.println(longestConsecWithStreams(arr, 2));
    }

    public static String longestConsec(String[] strarr, int k) {
        String result = "";
        for(int i = 0; i < strarr.length - k + 1; i++){
            StringBuilder builder = new StringBuilder();
            for(int j = 0; j < k; j++){
                String append = builder.append(strarr[i + j]).toString();
                if(append.length() > result.length()){
                    result = append;
                }
            }
        }
        return result;
    }

    // Using streams...
    public static String longestConsecWithStreams(String[] strarr, int k){
        if (k <= 0) {
            return "";
        }

        return IntStream.rangeClosed(0, strarr.length - k)
                .mapToObj(i -> Arrays.stream(strarr, i, i + k).collect(Collectors.joining()))
                .max(Comparator.comparingInt(String::length))
                .orElse("");
    }
}
