package calculations;

import enums.RomanInputNumbersEnum;
import enums.RomanNumbersEnum;

public class RomanCalcs extends Calculations {


    public RomanCalcs(String number1, String number2) {
        super(number1, number2);
    }

    @Override
    public String resultTransformation(int number) throws Exception {
        if (number < 1){
            throw new Exception("The result is less than 1");
        }
        return transformationFromArabicToRoman(number, null);
    }

    @Override
    public int constructorTransformation(String number) {
        for (RomanInputNumbersEnum romanNumber : RomanInputNumbersEnum.values()) {
            if (romanNumber.toString().equals(number)) {
                return romanNumber.getNumber();
            }
        }
        return -1;
    }

    private String transformationFromArabicToRoman(int number, String result) {

        if (result == null) {
            result = "";
        }

        if (number == 0) return result;
        else if (number < 9) {
            switch (number) {
                case 1:
                    return result + "I";
                case 2:
                    return result + "II";
                case 3:
                    return result + "III";
                case 4:
                    return result + "IV";
                case 5:
                    return result + "V";
                case 6:
                    return result + "VI";
                case 7:
                    return result + "VII";
                case 8:
                    return result + "VIII";
            }
        }

        RomanNumbersEnum[] romanNumbers = RomanNumbersEnum.values();

        int index;

        // Определение числа, большего, чем преобразовываемое (верхняя граница)
        for (index = 0; index < romanNumbers.length; index++) {
            if (number <= romanNumbers[index].getNumber()) {
                if (number == romanNumbers[index].getNumber()) return romanNumbers[index].toString();
                break;
            }
        }

        if (number >= (romanNumbers[index - 1].getNumber() + 4 * romanNumbers[index - 2].getNumber()) && romanNumbers[index - 1].getNumber() * 2 == romanNumbers[index].getNumber()
                ||
            number >= romanNumbers[index - 1].getNumber() * 4 && romanNumbers[index - 1].getNumber() * 5 == romanNumbers[index].getNumber()) {

            for (int i = index - 1; i >= 0; i--) {
                if (number <= (romanNumbers[index].getNumber() - romanNumbers[i].getNumber())) {
                    if (number == (romanNumbers[index].getNumber() - romanNumbers[i].getNumber())) {
                        return result + (romanNumbers[i].toString() + romanNumbers[index].toString());
                    }
                    result += romanNumbers[i + 1].toString() + romanNumbers[index].toString();
                    number -= (romanNumbers[index].getNumber() - romanNumbers[i + 1].getNumber());
                    break;
                }
            }
            return transformationFromArabicToRoman(number, result);
        } else {
            result += romanNumbers[index - 1].toString();
            number -= romanNumbers[index - 1].getNumber();
            return transformationFromArabicToRoman(number, result);
        }
    }
}
