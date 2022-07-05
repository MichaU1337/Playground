package codewars;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseDigits {

    public static void main(String[] args) {
        digitize(54321);
    }

    public static int[] digitize(long n) {
        List<String> collect = Stream.of(Long.valueOf(n).toString().split("")).collect(Collectors.toList());
        Collections.reverse(collect);
        System.out.println(collect);

        return collect.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static int[] digitizeStream(long n) {
        return new StringBuilder().append(n)
                .reverse()
                .chars()
                .map(Character::getNumericValue)
                .toArray();
    }
}
