package codewars;

/* You will be given a number and you will need to return it as a string in Expanded Form. For example:

    Kata.expandedForm(12); # Should return "10 + 2"
    Kata.expandedForm(42); # Should return "40 + 2"
    Kata.expandedForm(70304); # Should return "70000 + 300 + 4"

    Expanded Form: Writing a number to show the value of each digit.
    It is shown as a sum of each digit multiplied by its matching place value (ones, tens, hundreds, etc.)
    For example: 4.265 = 4 × 1.000 + 2 × 100 + 6 × 10 + 5 × 1
 */

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExpandedForm {

    public static void main(String[] args) {
        System.out.println(expandedForm(70304));
        System.out.println(expandedFormStream(70304));
    }

    public static String expandedForm(int num)
    {
        StringBuilder builder = new StringBuilder();
        int temp = num;
        int i = 1;

        do{
            if((temp % 10) * i != 0){
                builder.insert(0, (temp % 10) * i);
                builder.insert(0, " + ");
            }
            temp /= 10;
            i *= 10;
        } while  (temp > 0);
        builder.replace(0,3,"");

        return builder.toString();
    }

    public static String expandedFormStream(int num)
    {
        return IntStream.range(0, String.valueOf(num).length())
                .mapToObj(x -> String.valueOf(Character.getNumericValue(String.valueOf(num).charAt(x) ) * (int)Math.pow(10, String.valueOf(num).substring(x).length()-1)))
                .filter(x -> !x.equals("0"))
                .collect(Collectors.joining(" + "));
    }
}
