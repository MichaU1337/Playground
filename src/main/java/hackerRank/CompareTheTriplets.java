package hackerRank;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CompareTheTriplets {

    public static void main(String[] args) {
        Solution(Arrays.asList(1,2,3), Arrays.asList(4,5,6));
    }

    static List<Integer> Solution(List<Integer> a, List<Integer> b){

        Integer[] ArrayAlice = a.toArray(new Integer[0]);
        Integer[] ArrayBob = b.toArray(new Integer[0]);
        int[] result = new int[2];

        if(Arrays.stream(ArrayAlice).anyMatch(value -> value < 0)){
            throw new IllegalArgumentException("Please provide proper values greater than 0");
        }

        if(ArrayAlice.length == 0 || ArrayBob.length == 0){
            throw new NullPointerException("Please provide proper non empty lists");
        }

        if((ArrayAlice.length != 3) ||  ArrayBob.length != 3){
            throw new IllegalArgumentException("Please provide lists with 3 elements");
        }

        int index = 0;
        while (index <= 2){
            if(ArrayAlice[index] > ArrayBob[index]){
                result[0]++;
            }
            if(ArrayAlice[index] < ArrayBob[index]){
                result[1]++;
            }
            index++;
        }
        System.out.println(Arrays.toString(ArrayAlice) + " " + Arrays.toString(ArrayBob));

        System.out.println(Arrays.toString(result));
        return Arrays.stream(result).boxed().collect(Collectors.toList());
    }
}
