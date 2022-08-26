package Task10020;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Конвертер систем счислений
*/

public class Solution {
    private static final List<Character> LETTERS = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f');

    public static void main(String[] args) {
        Number number = new Number(NumberSystemType._10, "15");
        Number result = convertNumberToOtherNumberSystem(number, NumberSystemType._2);
        System.out.println(result);    //expected 110

        number = new Number(NumberSystemType._16, "6df");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._8);
        System.out.println(result);    //expected 3337

        number = new Number(NumberSystemType._16, "abcdefabcdef");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._16);
        System.out.println(result);    //expected abcdefabcdef

    }

    public static Number convertNumberToOtherNumberSystem(Number number, NumberSystem expectedNumberSystem) {
        if (!isNumberCorrect(number)) {
            throw new NumberFormatException();
        }

        if (number.getNumberSystem() == expectedNumberSystem) {
            return number;
        }

        Number numberInTen;
        if (number.getNumberSystem() == NumberSystemType._10) {
            numberInTen = number;
        } else {
            numberInTen = calcNumberInTensSystem(number);
        }

        return numberInExpected(numberInTen, expectedNumberSystem);
    }

    private static boolean isNumberCorrect(Number number) {
        int base = number.getNumberSystem().getNumberSystemIntValue();
        if (number.getDigit() == null || number.getDigit().isEmpty()) {
            return false;
        }
        String digit = number.getDigit().toLowerCase();

        Integer value = null;
        try {
            value = Integer.parseInt(number.getDigit());
        } catch (NumberFormatException ignore) {
        }
        if ((value == null || value < 0) && base <= 10) {
            return false;
        }
        List<Character> allowedLetters = new ArrayList<>();
        for (int i = 0; i < base - 10; i++) {
            allowedLetters.add(LETTERS.get(i));
        }
        boolean result = true;
        for (int i = 0; i < digit.length(); i++) {
            char symbol = digit.charAt(i);
            if (!Character.isLetterOrDigit(symbol) ||
                    (Character.isDigit(symbol) && symbol - 48 > base - 1) ||
                    (Character.isLetter(symbol) && !allowedLetters.contains(symbol)) ) {
                result = false;
                break;
            }
        }
        return result;
    }

    private static Number calcNumberInTensSystem(Number number) {
        int base = number.getNumberSystem().getNumberSystemIntValue();
        String digit = number.getDigit().toLowerCase();
        int pow = digit.length() - 1;
        BigInteger result = BigInteger.ZERO;
        for (int i = 0; i < digit.length(); i++) {
            char symbol = digit.charAt(i);
            int value = (Character.isLetter(symbol)) ? LETTERS.indexOf(symbol) + 10 : symbol - 48;
            result = result.add(BigInteger.valueOf(value).multiply(calcPow(base, pow)));
            pow--;
        }
        return new Number(NumberSystemType._10, result.toString());
    }

    private static BigInteger calcPow(int value, int pow) {
        BigInteger result = BigInteger.ONE;
        for (int i = 0; i < pow; i++) {
            result = result.multiply(BigInteger.valueOf(value));
        }
        return result;
    }

    private static Number numberInExpected(Number numberInTen, NumberSystem expectedNumberSystem) {
        BigInteger base = BigInteger.valueOf(expectedNumberSystem.getNumberSystemIntValue());
        BigInteger value = new BigInteger(numberInTen.getDigit());
        StringBuilder digit = new StringBuilder();
        while (value.compareTo(base) >= 0) {
            BigInteger mod = value.mod(base);
            digit.insert(0, modToString(mod));
            value = value.divide(base);
        }
        digit.insert(0, modToString(value));
        return new Number(expectedNumberSystem, digit.toString());
    }

    private static String modToString(BigInteger bigInteger) {
        int value = bigInteger.intValue();
        return (value < 10) ? String.valueOf(value) : String.valueOf(LETTERS.get(value - 10));
    }
}
