package codewars;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TenMinuteWalk {
    /* You live in the city of Cartesia where all roads are laid out in a perfect grid. You arrived ten minutes too early to an appointment,
    so you decided to take the opportunity to go for a short walk. The city provides its citizens with a Walk Generating App on their phones --
    everytime you press the button it sends you an array of one-letter strings representing directions to walk (eg. ['n', 's', 'w', 'e']).
    You always walk only a single block for each letter (direction) and you know it takes you one minute to traverse one city block...

    create a function that will return true if the walk the app gives you will take you exactly ten minutes (you don't want to be early or late!)
    and will, of course, return you to your starting point. Return false otherwise.
    */

    public static void main(String[] args) {
        char[] array = {'n', 's', 'w', 'e', 'n', 's', 'w', 'e', 'n', 's'};
        System.out.println(isWalkValid(array));

        char[] array1 = {'n', 's', 's', 's'};
        System.out.println(isWalkValid(array1));

        char[] array2 = {'n', 'e', 'n', 'e'};
        System.out.println(isWalkValid(array2));

        char[] array3 = {'s', 's', 's', 's'};
        System.out.println(isWalkValid(array3));
    }

    public static boolean isWalkValid(char[] walk){
        Map<Character, Long> collectMap = new String(walk)
                .chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return walk.length == 10 && (collectMap.get('n').equals(collectMap.get('s')) &&
                (collectMap.get('e').equals(collectMap.get('w'))));
    }
}
