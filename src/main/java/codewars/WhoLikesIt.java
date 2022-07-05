package codewars;

/*
[]                                -->  "no one likes this"
["Peter"]                         -->  "Peter likes this"
["Jacob", "Alex"]                 -->  "Jacob and Alex like this"
["Max", "John", "Mark"]           -->  "Max, John and Mark like this"
["Alex", "Jacob", "Mark", "Max"]  -->  "Alex, Jacob and 2 others like this"
 */

public class WhoLikesIt {

    public static void main(String[] args) {
        String[] names0 = {};
        String[] names1 = {"one"};
        String[] names2 = {"one", "two"};
        String[] names4 = {"one", "two", "three", "four"};

        System.out.println(whoLikesIt(names0));
        System.out.println(whoLikesIt(names1));
        System.out.println(whoLikesIt(names2));
        System.out.println(whoLikesIt(names4));
    }

    public static String whoLikesIt(String... names) {
        return switch (names.length) {
            case 0 -> "no one likes this";
            case 1 -> names[0] + " likes this";
            case 2 -> names[0] + " and " + names[1] + " like this";
            case 3 -> names[0] + ", " + names[1] + " and " + names[2] + " like this";
            default -> names[0] + ", " + names[1] + " and " + (names.length - 2) + " others like this";
        };
    }
}
