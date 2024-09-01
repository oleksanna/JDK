package DZ_3;

public class Calculator {

    public static <T1 extends Number, T2 extends Number> double sum(T1 a, T2 b) {
        return a.doubleValue() + b.doubleValue();
    }

    public static <T1 extends Number, T2 extends Number> double multiply(T1 a, T2 b) {
        return a.doubleValue() * b.doubleValue();
    }

    public static <T1 extends Number, T2 extends Number> double divide(T1 a, T2 b) {
        if (b.doubleValue() == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a.doubleValue() / b.doubleValue();
    }

    public static <T1 extends Number, T2 extends Number> double subtract(T1 a, T2 b) {
        return a.doubleValue() - b.doubleValue();
    }
}