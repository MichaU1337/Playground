package codewars;

import java.util.Arrays;

public class HighestLowest {

    public static void main(String[] args) {
        System.out.println(highAndLow("1 2 3 3 4 5 6"));
    }

    public static String highAndLow(String numbers) {
        return Arrays.stream(numbers.split(" ")).mapToInt(Integer::valueOf).max().getAsInt() + " " + Arrays.stream(numbers.split(" ")).mapToInt(Integer::valueOf).min().getAsInt();
    }
}
