package hackerRank;

    /**  https://www.geeksforgeeks.org/count-substrings-with-same-first-and-last-characters/
    *
    */

public class CodilityTest {

    static final int MAX_CHAR = 26;
    static int result;
    static int lowestResult;

    //Non optimal - just a working solution
    static int countSubstringWithEqualEndsVersion1(String s) {
        int n = s.length();
        result = n;
        if(result < lowestResult){
            lowestResult = result;
        }

        for (int i = 0; i < n; i++) {
            if (result <= 1) {
                break;
            }
            for (int length = 2; length <= n - i; length++) {
                String substring = s.substring(i, i + length);

                if (checkEquality(substring)) {
                    String stringResult = s.replace(substring, "");

                    int resultLength = stringResult.length();

                    if (resultLength < result) {
                        result = resultLength;
                    }

                    if (resultLength == 0) {
                        lowestResult = 0;
                        break;
                    }
                    countSubstringWithEqualEndsVersion1(stringResult);
                    System.out.println(stringResult);
                }
            }
        }
        return lowestResult;
    }

    static boolean checkEquality(String s) {
        return (s.charAt(0) == s.charAt(s.length() - 1));
    }

    static int countSubstringWithEqualEndsVersion2(String s) {
        int result = 0;
        int n = s.length();

        // Calculating frequency of each character in the string.
        int[] count =  new int[MAX_CHAR];
        for (int i = 0; i < n; i++){
            count[s.charAt(i)-'a']++;
        }

        // Computing result using counts
        for (int i = 0; i < MAX_CHAR; i++)
            result += (count[i] * (count[i] + 1) / 2);

        return result;
    }

    public static void main(String[] args)
    {
        String s = "abcab";
        lowestResult = s.length();
        System.out.println(countSubstringWithEqualEndsVersion1(s));
        System.out.println(countSubstringWithEqualEndsVersion2(s));
    }
}


