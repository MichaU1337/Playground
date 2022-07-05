package codewars;

import java.util.Arrays;

public class SquareSumN {

    public static void main(String[] args) {
        int[] asd = {2,3};
        System.out.println(squareSum(asd));
    }

    public static int squareSum(int[] n)
    {
        return Arrays.stream(n).map(s -> s * s).sum();
    }
}
