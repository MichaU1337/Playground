package codewars;

import java.util.Arrays;

public class StringSplitPair {

    public static void main(String[] args) {
        // #1 substring
        System.out.println(Arrays.toString(stringSplitV1("HelloWorld")));
        System.out.println(Arrays.toString(stringSplitV1("HelloWorlds")));

        // #2 regex
        System.out.println(Arrays.toString(stringSplitV2("HelloWorld")));
        System.out.println(Arrays.toString(stringSplitV2("HelloWorlds")));
    }

    public static String[] stringSplitV1(String s) {
        if (s.length() % 2 != 0){
            s += "_";
        }
        String[] result = new String[(s.length() / 2)];
        for(int i = 0, j = 0; i < s.length(); i += 2, j++){
            result[j] = s.substring(i, i + 2);
        }
        return result;
    }

    public static String[] stringSplitV2(String s){
        s = (s.length() % 2 == 0) ? s : s + "_";
        return s.split("(?<=\\G.{2})");
    }
}