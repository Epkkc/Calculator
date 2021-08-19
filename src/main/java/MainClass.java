import calculations.ArabicCalcs;
import calculations.Calculations;
import calculations.RomanCalcs;
import utils.NumberIdentifier;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()){
            throw new Exception("Empty line");
        }
        String inputString = scanner.nextLine();

        String symbol;

        if (inputString.contains("+")){
            symbol = "\\+";
        } else if (inputString.contains("-")){
            symbol = "-";
        } else if (inputString.contains("*")){
            symbol = "\\*";
        } else if (inputString.contains("/")){
            symbol = "/";
        } else{
            throw new Exception("No arithmetic operation");
        }

        String[] numbers = inputString.split(symbol);

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = numbers[i].trim();
        }

        Calculations calculator;

        if (NumberIdentifier.isArabicNumber(numbers[0]) && NumberIdentifier.isArabicNumber(numbers[1])){
            calculator = new ArabicCalcs(numbers[0], numbers[1]);
        } else if (NumberIdentifier.isRomanNumber(numbers[0]) && NumberIdentifier.isRomanNumber(numbers[1])){
            calculator = new RomanCalcs(numbers[0], numbers[1]);
        } else {
            throw new Exception("Wrong numbers format");
        }

        String result = "non result";
        switch (symbol){
            case "\\+":
                result = calculator.addition();
                break;
            case "-":
                result = calculator.substraction();
                break;
            case "\\*":
                result = calculator.multiplication();
                break;
            case "/":
                result = calculator.division();
                break;
        }

        System.out.println(result);

    }
}
