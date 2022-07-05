package hackerRank;

import java.util.Arrays;
import java.util.List;

public class VeryBigSum {

    public static void main(String[] args) {
        SolutionStream();
    }

    static void SolutionStream(){
        List<Integer> list = Arrays.asList(1,2,3);
        System.out.println(list.stream().mapToLong(Integer::longValue).sum());
    }
}