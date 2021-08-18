package enums;

public enum RomanNumbersEnum {
    I(1), V(5), X(10), L(50), C(100);

    private final int number;

    RomanNumbersEnum(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }
}
