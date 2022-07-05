package codewars;

import java.util.regex.Pattern;

public class RegexValidatePIN {

    public static void main(String[] args) {
        System.out.println(validatePinShorter("4444"));
    }

    public static boolean validatePin(String pin) {
        return pin.matches("[0-9]{6}|[0-9]{4}");
    }

    public static boolean validatePinShorter(String pin) {
        return pin.matches("\\d{6}|\\d{4}");
    }
}
