package hackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class PlusMinusPrecisionRatios {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        if(arr.size() > 100){
            throw new IllegalArgumentException("Array size is not in range");
        }

        if(arr.stream().anyMatch((integer -> integer < -100 || integer > 100))){
            throw new IllegalArgumentException("Elements out of range");
        }

        double countPositive = arr.stream().filter(element -> element > 0).count();
        System.out.printf("%.10f%n", countPositive / arr.size());

        double countNegative = arr.stream().filter(element -> element < 0).count();
        System.out.printf("%.10f%n", countNegative / arr.size());

        double countZeros = arr.stream().filter(element -> element == 0).count();
        System.out.printf("%.10f%n", countZeros / arr.size());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        PlusMinusPrecisionRatios.plusMinus(arr);

        bufferedReader.close();
    }
}
