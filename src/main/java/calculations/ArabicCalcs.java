package calculations;

public class ArabicCalcs extends Calculations {

    public ArabicCalcs(String number1, String number2) {
        super(number1, number2);
    }

    @Override
    public String transformation(int number) {
        return String.valueOf(number);
    }

    @Override
    public int constructorTransformation(String number) {
        return Integer.parseInt(number);
    }
}
