package hackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Staircase {

    /*
     * Complete the 'staircase' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void staircase(int n) {
        if(n > 100 || n < 0){
            throw new IllegalArgumentException("Input out of valid range");
        }

        int hashNumber = 1;
        int spaceNumber = n-1;
        String hash = "#";
        String space = " ";

        while (hashNumber <= n){
            System.out.println(space.repeat(spaceNumber) + hash.repeat(hashNumber));
            hashNumber++;
            spaceNumber--;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Staircase.staircase(n);

        bufferedReader.close();
    }
}