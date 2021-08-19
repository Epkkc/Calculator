package utils;

import enums.RomanInputNumbersEnum;

public class NumberIdentifier {

    public static boolean isArabicNumber(String number) {
        int intNumber;
        try {
            intNumber = Integer.parseInt(number);
        } catch (NumberFormatException exception) {
            return false;
        }
        return intNumber >= 1 && intNumber <= 10;
    }

    public static boolean isRomanNumber(String number) {
        for (RomanInputNumbersEnum romanNumber : RomanInputNumbersEnum.values()) {
            if (romanNumber.toString().equals(number)) {
                return true;
            }
        }
        return false;
    }
}
