package codewars;

import java.util.stream.IntStream;

public class BuildTower {

    public static void main(String[] args) {
        towerBuilder(5);
    }

    public static String[] towerBuilder(int nFloors)
    {
        String[] result = new String[nFloors];
        IntStream.rangeClosed(1, nFloors).forEach(value -> result[value-1] = (" ".repeat(nFloors - value) + "*".repeat(2 * value - 1) + " ".repeat(nFloors - value)));
        return result;
    }
}
