package codewars;

import java.util.ArrayList;
import java.util.Collections;

public class SudokuValidator {
    private static int size;
    private static ArrayList<Integer> values;

    public static void main(String[] args) {
        final int[][] validSudoku = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {4, 5, 6, 7, 8, 9, 1, 2, 3},
                {7, 8, 9, 1, 2, 3, 4, 5, 6},
                {2, 3, 4, 5, 6, 7, 8, 9, 1},
                {5, 6, 7, 8, 9, 1, 2, 3, 4},
                {8, 9, 1, 2, 3, 4, 5, 6, 7},
                {3, 4, 5, 6, 7, 8, 9, 1, 2},
                {6, 7, 8, 9, 1, 2, 3, 4, 5},
                {9, 1, 2, 3, 4, 5, 6, 7, 8}
        };
        System.out.println(check(validSudoku));
    }

    public static boolean check(int[][] sudoku) {
        size = sudoku.length;
        values = new ArrayList<>(size);
        return check(sudoku, true) && check(sudoku, false) && blocksCheck(sudoku);
    }

    private static boolean blocksCheck(int[][] sudoku) {
        for (int y = 0; y < size; y += 3) {
            for (int x = 0; x < size; x += 3) {
                for (int j = y; j < y + 3; j++) {
                    for (int i = x; i < x + 3; i++) {
                        values.add(sudoku[j][i]);
                    }
                }

                if (!validateSection()) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean validateSection() {
        if (values.size() != size) {
            return false;
        }

        Collections.sort(values);

        if (values.get(0) != 1) {
            return false;
        }

        for (int i = 1; i < size; i++) {
            if (values.get(i) - values.get(i-1) != 1) {
                return false;
            }
        }
        values.clear();
        return true;
    }

    private static boolean check(int[][] sudoku, boolean isFlipped) {
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                int i;
                int j;

                if (isFlipped) {
                    i = x;
                    j = y;
                } else {
                    i = y;
                    j = x;
                }

                if (sudoku[i][j] == 0) {
                    return false;
                }
                values.add(sudoku[i][j]);
            }

            if (!validateSection()) {
                return false;
            }
        }
        return true;
    }
}
