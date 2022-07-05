package hackerRank;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SimpleArraySum {

    public static void main(String[] args) {
        SolutionStream();
        Solution();
    }

    static void Solution(){
        List<Integer> list = Arrays.asList(1,2,3);
        Iterator<Integer> iterator = list.iterator();
        int sum = 0;

        while (iterator.hasNext()){
            sum += iterator.next();
        }

        System.out.println(sum);
    }

    static void SolutionStream(){
        List<Integer> list = Arrays.asList(1,2,3);
        System.out.println(list.stream().mapToInt(Integer::intValue).sum());
    }


}