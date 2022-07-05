package codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ConnectFourGame {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>(Arrays.asList(
                "A_Red",
                "B_Yellow",
                "C_Red",
                "D_Yellow",
                "A_Red",
                "B_Yellow",
                "A_Red",
                "B_Yellow"
        ));
        whoIsWinner(myList);
    }

    public static String whoIsWinner(List<String> piecesPositionList) {
        List<String> moves = new ArrayList<>();
        piecesPositionList.forEach(s -> {
            moves.add(s.substring(0, 1));
        });
        List<Integer> intMoves = moves.stream().mapToInt(s -> switch (s) {
            case "A" -> 0;
            case "B" -> 1;
            case "C" -> 2;
            case "D" -> 3;
            case "E" -> 4;
            case "F" -> 5;
            case "G" -> 6;
            default -> -1;
        }).boxed().toList();

        Iterator<Integer> intIterator = intMoves.iterator();
        String[][] grid = new String[6][7];

        //initialize array
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                grid[row][col] = " ";
            }
        }

        int turn = 1;
        String player;
        boolean winner = false;

        if (piecesPositionList.get(0).substring(2).equals("Red")) {
            player = "R";
        } else player = "Y";

        //play a turn
        while (!winner && turn <= 42) {
            boolean validPlay;
            int play = -1;
            do {
                display(grid);

                System.out.println("Player " + player + ", choose a column: ");

                if(intIterator.hasNext()){
                    play = intIterator.next();
                }

                //validate play
                if(play >= 0){
                    validPlay = validate(play, grid);

                    //drop the checker
                    for (int row = grid.length - 1; row >= 0; row--) {
                        if (grid[row][play].equals(" ")) {
                            grid[row][play] = player;
                            break;
                        }
                    }
                }
                else break;

            } while (!validPlay);

            //determine if there is a winner
            winner = isWinner(player, grid);

            display(grid);

            if (winner) {
                if (player.equals("R"))
                    return "Red";
                else
                    return "Yellow";
            } else {
                System.out.println("Draw");
            }

            //switch players
            if (player.equals("R")) {
                player = "Y";
            } else {
                player = "R";
            }
            turn++;
        }
        return player;
    }

    public static void display(String[][] grid) {
        System.out.println(" 0 1 2 3 4 5 6");
        for (String[] strings : grid) {
            System.out.print("|");
            for (int col = 0; col < grid[0].length; col++) {
                System.out.print(strings[col]);
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.println(" 0 1 2 3 4 5 6");
        System.out.println();
    }

    public static boolean validate(int column, String[][] grid) {
        //valid column?
        if (column < 0 || column > grid[0].length) {
            return false;
        }

        //full column?
        return grid[0][column].equals(" ");
    }

    public static boolean isWinner(String player, String[][] grid) {
        //check for 4 across
        for (String[] strings : grid) {
            for (int col = 0; col < grid[0].length - 3; col++) {
                if (strings[col].equals(player) &&
                        strings[col + 1].equals(player) &&
                        strings[col + 2].equals(player) &&
                        strings[col + 3].equals(player)) {
                    System.out.println("Winner across: " + player);
                    return true;
                }
            }
        }
        //check for 4 up and down
        for (int row = 0; row < grid.length - 3; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col].equals(player) &&
                        grid[row + 1][col].equals(player) &&
                        grid[row + 2][col].equals(player) &&
                        grid[row + 3][col].equals(player)) {
                    System.out.println("Winner horizontal: " + player);
                    return true;
                }
            }
        }
        //check upward diagonal
        for (int row = 3; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length - 3; col++) {
                if (grid[row][col].equals(player) &&
                        grid[row - 1][col + 1].equals(player) &&
                        grid[row - 2][col + 2].equals(player) &&
                        grid[row - 3][col + 3].equals(player)) {
                    System.out.println("Winner diagonal1: " + player);
                    return true;
                }
            }
        }
        //check downward diagonal
        for (int row = 0; row < grid.length - 3; row++) {
            for (int col = 0; col < grid[0].length - 3; col++) {
                if (grid[row][col].equals(player) &&
                        grid[row + 1][col + 1].equals(player) &&
                        grid[row + 2][col + 2].equals(player) &&
                        grid[row + 3][col + 3].equals(player)) {
                    System.out.println("Winner diagonal2: " + player);
                    return true;
                }
            }
        }
        return false;
    }
}
