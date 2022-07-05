package codewars;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class DuplicateEncoder {

    public static void main(String[] args) {
        encode("abb");
    }

    static String encode(String word){
        Map<Character, Integer> map = new HashMap<>();
        word = word.toLowerCase();

        for(int i = 0; i < word.length(); i++){
            if(map.containsKey(word.charAt(i))){
                int value = map.get(word.charAt(i));
                map.remove(word.charAt(i));
                map.put(word.charAt(i), ++value);

            } else {
                map.put(word.charAt(i), 1);
            }
        }

        String output = "";

        for(int i = 0; i < word.length(); i++){
            output += (map.get(word.charAt(i)) > 1) ? ")" : "(";
        }

        return output;
    }

    static String encodeStream(String word){
        return word.toLowerCase()
                .chars()
                .mapToObj(i -> String.valueOf((char)i))
                .map(i -> word.toLowerCase().indexOf(i) == word.toLowerCase().lastIndexOf(i) ? "(" : ")")
                .collect(Collectors.joining());
    }
}
