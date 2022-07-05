package codewars;

public class StringEnding {

    public static void main(String[] args) {
        System.out.println(stringEndsWith("Hello World","ld"));
        System.out.println(stringEndsWith("Hello World"," World"));

    }

    public static boolean stringEndsWith(String str, String ending) {
        return str.endsWith(ending);
    }
}
