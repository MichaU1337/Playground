package codewars;

public class PangramChecker {
    public static void main(String[] args) {
        System.out.println(checkSentence("Two driven jocks help fax my big quiz"));
        System.out.println(checkSentence("You shall not pass!"));

        System.out.println(checkSentenceStream("Two driven jocks help fax my big quiz"));
        System.out.println(checkSentenceStream("You shall not pass!"));
    }

    public static boolean checkSentence(String sentence){
        if (sentence == null){
            return false;
        }
        boolean[] alphabetMarker = new boolean[26];

        int alphabetIndex;
        sentence = sentence.toUpperCase();

        for(int i = 0; i < sentence.length(); i++){
            if('A' <= sentence.charAt(i) && sentence.charAt(i) <= 'Z'){
                alphabetIndex = sentence.charAt(i) - 'A';
                alphabetMarker[alphabetIndex] = true;
            }
        }
        for (boolean index : alphabetMarker){
            if(!index){
                return false;
            }
        }
        return true;
    }

    public static boolean checkSentenceStream(String sentence){
        return sentence.chars().map(Character::toLowerCase).filter(Character::isAlphabetic).distinct().count() == 26;
    }
}