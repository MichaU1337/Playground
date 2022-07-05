package codewars;

public class ParseIntReloaded {

    public static void main(String[] args) {
        parseStringToInt("seven hundred eighty-three thousand nine hundred and nineteen");
    }

    public static int parseIntToString(String numStr) {
        StringBuilder sb = new StringBuilder();
        String[] oneToTen = {"fakeZero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] tens = {"fakeTen", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] everyTenth = {"fakeZero", "fakeTen", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String[] number = numStr.split("");

        if (number.length == 6) {
            sb.append(oneToTen[Integer.parseInt(number[0])]).append(" hundred ");
            if(Integer.parseInt(number[1]) == 1){
                sb.append(tens[Integer.parseInt(number[2])]).append(" thousand ");
            }
            else {
                sb.append(everyTenth[Integer.parseInt(number[1])]).append("-").append(oneToTen[Integer.parseInt(number[2])]).append(" thousand ");
            }

            sb.append(oneToTen[Integer.parseInt(number[3])]).append(" hundred ");
            if(Integer.parseInt(number[4]) == 1){
                sb.append(" and ").append(tens[Integer.parseInt(number[5])]);
            }
            else {
                sb.append(everyTenth[Integer.parseInt(number[4])]).append("-").append(oneToTen[Integer.parseInt(number[5])]);
            }
        }

        if (number.length == 5) {
            if(Integer.parseInt(number[0]) == 1){
                sb.append(tens[Integer.parseInt(number[1])]).append(" thousand ");
            }
            else {
                sb.append(everyTenth[Integer.parseInt(number[0])]).append("-").append(oneToTen[Integer.parseInt(number[1])]).append(" thousand ");
            }

            sb.append(oneToTen[Integer.parseInt(number[2])]).append(" hundred ");
            if(Integer.parseInt(number[3]) == 1){
                sb.append("and ").append(tens[Integer.parseInt(number[4])]);
            }
            else {
                sb.append(everyTenth[Integer.parseInt(number[3])]).append("-").append(oneToTen[Integer.parseInt(number[4])]);
            }
        }

        if (number.length == 4) {
            sb.append(oneToTen[Integer.parseInt(number[0])]).append(" thousand ");

            sb.append(oneToTen[Integer.parseInt(number[1])]).append(" hundred ");
            if(Integer.parseInt(number[2]) == 1){
                sb.append("and ").append(tens[Integer.parseInt(number[3])]);
            }
            else {
                sb.append(everyTenth[Integer.parseInt(number[2])]).append("-").append(oneToTen[Integer.parseInt(number[3])]);
            }
        }

        if (number.length == 3) {
            sb.append(oneToTen[Integer.parseInt(number[0])]).append(" hundred ");
            if(Integer.parseInt(number[1]) == 1){
                sb.append("and ").append(tens[Integer.parseInt(number[2])]);
            }
            else {
                sb.append(everyTenth[Integer.parseInt(number[1])]).append("-").append(oneToTen[Integer.parseInt(number[2])]);
            }
        }

        if (number.length == 2) {
            if(Integer.parseInt(number[0]) == 1){
                sb.append(tens[Integer.parseInt(number[1])]);
            }
            else {
                sb.append(everyTenth[Integer.parseInt(number[0])]).append("-").append(oneToTen[Integer.parseInt(number[1])]);
            }
        }

        if (number.length == 1) {
            sb.append(oneToTen[Integer.parseInt(number[0])]);
        }

        System.out.println(sb);
        return -1;
    }
    public static int parseStringToInt(String numStr) {
        String input = numStr;

        int result = 0;
        int finalResult = 0;

        input = input.replace("-", " ");
        input = input.toLowerCase().replace(" and", " ");
        String[] splittedParts = input.trim().split("\\s+");

        for (String str : splittedParts) {
            if (str.equalsIgnoreCase("zero")) {
                result += 0;
            } else if (str.equalsIgnoreCase("one")) {
                result += 1;
            } else if (str.equalsIgnoreCase("two")) {
                result += 2;
            } else if (str.equalsIgnoreCase("three")) {
                result += 3;
            } else if (str.equalsIgnoreCase("four")) {
                result += 4;
            } else if (str.equalsIgnoreCase("five")) {
                result += 5;
            } else if (str.equalsIgnoreCase("six")) {
                result += 6;
            } else if (str.equalsIgnoreCase("seven")) {
                result += 7;
            } else if (str.equalsIgnoreCase("eight")) {
                result += 8;
            } else if (str.equalsIgnoreCase("nine")) {
                result += 9;
            } else if (str.equalsIgnoreCase("ten")) {
                result += 10;
            } else if (str.equalsIgnoreCase("eleven")) {
                result += 11;
            } else if (str.equalsIgnoreCase("twelve")) {
                result += 12;
            } else if (str.equalsIgnoreCase("thirteen")) {
                result += 13;
            } else if (str.equalsIgnoreCase("fourteen")) {
                result += 14;
            } else if (str.equalsIgnoreCase("fifteen")) {
                result += 15;
            } else if (str.equalsIgnoreCase("sixteen")) {
                result += 16;
            } else if (str.equalsIgnoreCase("seventeen")) {
                result += 17;
            } else if (str.equalsIgnoreCase("eighteen")) {
                result += 18;
            } else if (str.equalsIgnoreCase("nineteen")) {
                result += 19;
            } else if (str.equalsIgnoreCase("twenty")) {
                result += 20;
            } else if (str.equalsIgnoreCase("thirty")) {
                result += 30;
            } else if (str.equalsIgnoreCase("forty")) {
                result += 40;
            } else if (str.equalsIgnoreCase("fifty")) {
                result += 50;
            } else if (str.equalsIgnoreCase("sixty")) {
                result += 60;
            } else if (str.equalsIgnoreCase("seventy")) {
                result += 70;
            } else if (str.equalsIgnoreCase("eighty")) {
                result += 80;
            } else if (str.equalsIgnoreCase("ninety")) {
                result += 90;
            } else if (str.equalsIgnoreCase("hundred")) {
                result *= 100;
            } else if (str.equalsIgnoreCase("thousand")) {
                result *= 1000;
                finalResult += result;
                result = 0;
            } else if(str.equalsIgnoreCase("million")) {
                result *= 1000000;
                finalResult += result;
                result=0;
            }
        }

        finalResult += result;
        System.out.println(finalResult);

        return finalResult;
    }
}
