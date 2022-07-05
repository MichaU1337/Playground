package hackerRank;

import java.util.Arrays;
import java.util.List;

public class DiagonalDifferenceMatrix {

    public static int diagonalDifference(List<List<Integer>> arr) {

        int principal = 0, secondary = 0;

        for (int i = 0; i < arr.size(); i++){
            System.out.println(arr.get(i));
            principal += arr.get(i).get(i);
            secondary += arr.get(i).get(arr.size() - i - 1);
        }

        System.out.println(principal);
        System.out.println(secondary);

        return Math.abs(principal - secondary);
    }

    public static void main(String[] args) {
        System.out.println(diagonalDifference(Arrays.asList(Arrays.asList(11,2,4), Arrays.asList(4,5,6), Arrays.asList(10,8,-12))));
    }
}
