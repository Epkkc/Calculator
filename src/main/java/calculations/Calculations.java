package calculations;

public abstract class Calculations {

    private final int number1;
    private final int number2;

    public Calculations(String number1, String number2) {
        this.number1 = constructorTransformation(number1);
        this.number2 = constructorTransformation(number2);
    }

    public String addition() throws Exception {
        return resultTransformation(number1 + number2);
    }

    public String substraction() throws Exception {
        return resultTransformation(number1 - number2);
    }

    public String multiplication() throws Exception {
        return resultTransformation(number1 * number2);
    }

    public String division() throws Exception {
        return resultTransformation((number1 - (number1 % number2)) / number2);
    }

    protected abstract String resultTransformation(int number) throws Exception;

    protected abstract int constructorTransformation(String number);
}
