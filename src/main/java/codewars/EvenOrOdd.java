package codewars;

import java.util.Arrays;

public class EvenOrOdd {

    public static String oddOrEven (int[] array) {
        return Arrays.stream(array).sum() % 2 == 0 ? "even" : "odd";
    }
}
