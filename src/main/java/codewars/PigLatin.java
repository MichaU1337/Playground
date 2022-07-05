package codewars;

import java.util.Arrays;
import java.util.stream.Collectors;

// Move the first letter of each word to the end of it, then add "ay" to the end of the word. Leave punctuation marks
// untouched.

public class PigLatin {

    public static void main(String[] args) {
        pigIt("Pig latin is cool");
    }

    public static String pigIt(String str) {
        if(str.length() == 0)return "";
        if(str.length() == 1)return str.concat("ay");
        int i = 0, j = i+1;
        StringBuilder sb = new StringBuilder();

        while(j < str.length()) {
            if(str.charAt(j) == ' ') {
                sb.append(str, i+1, j).append(str.charAt(i)).append("ay ");
                i = j+1;
                j = i+1;
            }else {
                j++;
            }
        }

        Character ch = str.charAt(i);
        if(Character.isAlphabetic(str.charAt(i))) {
            sb.append(str, i+1, j).append(str.charAt(i)).append("ay");
            i = j+1;
            j = i+1;
        }else {
            sb.append(str, i, j);
        }

        return sb.toString();
    }

    public static String pigItUsingStreams(String str) {
        return Arrays.stream(str.trim().split(" "))
                .map(v -> v.matches("[a-zA-Z]+") ? v.substring(1).concat(v.substring(0, 1)).concat("ay") : v)
                .collect(Collectors.joining(" "));
    }

    public static String pigItShortestVersion(String str) {
        return str.replaceAll("(\\w)(\\w*)", "$2$1ay");
    }
}
