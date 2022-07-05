package codewars;

// Write a program that will calculate the number of trailing zeros in a factorial of a given number.
// N! = 1 * 2 * 3 * ... * N

public class TrailingZeros {

    public static void main(String[] args) {
        System.out.println(zeros(14));
    }

    public static int zeros(int n) {
        int countZeros = 0;
        if(n < 0) return -1;

        for(int i = 5; n/i > 0; i *= 5)
        {
            countZeros += n/i;
        }
        return countZeros;
    }
}
