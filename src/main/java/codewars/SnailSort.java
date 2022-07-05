package codewars;

/*
Given an n x n array, return the array elements arranged from outermost elements to the middle element, traveling clockwise.

array = [[1,2,3],
         [4,5,6],
         [7,8,9]]
snail(array) #=> [1,2,3,6,9,8,7,4,5]
For better understanding, please follow the numbers of the next array consecutively:

array = [[1,2,3],
         [8,9,4],
         [7,6,5]]
snail(array) #=> [1,2,3,4,5,6,7,8,9]
 */

public class SnailSort {

    public static int[] snail(int[][] array) {
        int n = array.length;
        int[] answer = new int[n * n];
        int index = 0;

        for (int i = 0; i < n / 2; i++){
            for(int j = i; j < n - i; j++) answer[index++] = array[i][j];
            for(int j = i + 1; j < n - i; j++) answer[index++] = array[j][n - i - 1];
            for(int j = i + 1; j < n - i; j++) answer[index++] = array[n - i - 1][n - j - 1];
            for(int j = i + 1; j < n - i - 1; j++) answer[index++] = array[n - j - 1][i];
        }

        if(n%2 != 0)
            answer[index++] = array[n/2][n/2];

        return answer;
    }
}
