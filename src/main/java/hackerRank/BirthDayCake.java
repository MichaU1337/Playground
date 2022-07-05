package hackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class BirthDayCake {

    /*
     * Complete the 'birthdayCakeCandles' function below.
     * https://www.hackerrank.com/challenges/birthday-cake-candles/problem
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY candles as parameter.
     */

    public static int birthdayCakeCandles(List<Integer> candles) {

        if(candles.size() < 1 || candles.size() > Math.pow(10, 5)){
            throw new IllegalArgumentException("Number of elements out of range: 1 - 10^5");
        }

        if(Collections.min(candles) < 1 || Collections.max(candles) > Math.pow(10,7)){
            throw new IllegalArgumentException("Elements in the list are not in range: 1 - 10^7");
        }
        int max = Collections.max(candles);

        int count = (int) candles.stream().filter(integer -> integer.equals(max)).count();
        System.out.println(count);
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int candlesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> candles = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        BirthDayCake.birthdayCakeCandles(candles);

        bufferedReader.close();
    }
}
