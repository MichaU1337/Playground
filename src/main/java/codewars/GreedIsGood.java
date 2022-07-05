package codewars;

/*
Greed is a dice game played with five six-sided dice. Your mission, should you choose to accept it, is to score a throw
according to these rules. You will always be given an array with five six-sided dice values.

Three 1's => 1000 points
 Three 6's =>  600 points
 Three 5's =>  500 points
 Three 4's =>  400 points
 Three 3's =>  300 points
 Three 2's =>  200 points
 One   1   =>  100 points
 One   5   =>   50 point

A single die can only be counted once in each roll. For example, a given "5" can only count as part of a triplet
(contributing to the 500 points) or as a single 50 points, but not both in the same roll.

Example scoring
Throw       Score
 ---------   ------------------
 5 1 3 4 1   250:  50 (for the 5) + 2 * 100 (for the 1s)
 1 1 1 3 1   1100: 1000 (for three 1s) + 100 (for the other 1)
 2 4 4 5 4   450:  400 (for three 4s) + 50 (for the 5)
 */

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class GreedIsGood {

    public static void main(String[] args) {
        int[] array = {2,4,4,5,4};
        greedy(array);
    }

    public static int greedy(int[] dice){
        int score = 0;
        List<Integer> allDices = Arrays.stream(dice).boxed().toList();

        Optional<Map.Entry<Integer, Long>> first = Arrays.stream(dice).boxed().collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()))
                .entrySet().stream().filter(integerLongEntry -> integerLongEntry.getValue() >= 3).findFirst();

        if (first.isPresent()) {
            Integer key = first.get().getKey();
            switch (key){
                case 1 -> score += 1000;
                case 6 -> score += 600;
                case 5 -> score += 500;
                case 4 -> score += 400;
                case 3 -> score += 300;
                case 2 -> score += 200;
            }

            allDices.stream().filter(integer -> integer.equals(key)).peek(allDices::remove);
            if(allDices.contains(1)){
                score += 100;
                System.out.println(score);
            }

            if(allDices.contains(5)){
                score += 50;
                System.out.println(score);
            }
        }

        else{
            score += 100 * Arrays.stream(dice).boxed().filter(integer -> integer == 1).count();
            score += 50 * Arrays.stream(dice).boxed().filter(integer -> integer == 5).count();
        }
        System.out.println(score);
        return score;
    }

    public int greedy2(int[] dice){
        int total=0;

        int[] diceOccur = {0,0,0,0,0,0,0};
        for(int j: dice) diceOccur[j]++;

        for(int i=1; i<diceOccur.length; i++) {
            if(i==1) {
                total += (diceOccur[i] > 2? 1000+(diceOccur[1]-3)*100: diceOccur[1]*100);
            } else
            if(i==5) {
                total += (diceOccur[i] > 2? 500+(diceOccur[5]-3)*50: diceOccur[5]*50);
            } else {
                total += (diceOccur[i] > 2? i*100: 0);
            }
        }

        return total;
    }
}
