package codewars;

import java.util.Arrays;

public class Spiralizor {

    public static void main(String[] args) {
        spiralize(6);
    }

    public static int[][] spiralize(int size) {
        int index = size;
        int [][] matrix = new int[size][size];
        int iLast = 0;
        int jLast = 0;

        Arrays.stream(matrix).forEach(ints -> Arrays.fill(ints,1));

        for (int i = 1, j = 0; j < index - 1; j++){
            matrix[i][j] = 0;
            iLast = i;
            jLast = j;
        }
        index -= 2;

        while (index > 1){
            for (int i = iLast, j = jLast, k = 0; k < index ;k++, i++){
                matrix[i][j] = 0;
                iLast = i;
                jLast = j;
            }
            for (int i = iLast, j = jLast, k = 0; k < index ;k++, j--){
                matrix[i][j] = 0;
                iLast = i;
                jLast = j;
            }
            index -= 2;
            for (int i = iLast, j = jLast, k = 0; k < index ;k++, i--){
                matrix[i][j] = 0;
                iLast = i;
                jLast = j;
            }
            for (int i = iLast, j = jLast, k = 0; k < index ;k++, j++){
                matrix[i][j] = 0;
                iLast = i;
                jLast = j;
            }
            index -= 2;
        }

        System.out.println(Arrays.deepToString(matrix));

        return matrix;
    }
}
