package codewars;

import java.util.Arrays;

public class FindUniqueNumber {

    public static void main(String[] args) {
        double[] qwe = {1,2,2};
        System.out.println(findUniq(qwe));
    }

    public static double findUniq(double arr[]) {
        if(arr[0] == arr[1]){
            return Arrays.stream(arr).filter(value -> value != arr[0]).boxed().findFirst().get();
        }
        else {
            if(arr[1] == arr[2]){
                return arr[0];
            }
            else return arr[1];
        }
    }
}
