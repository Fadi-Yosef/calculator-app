package se.lexicon;

public class Calculator {

    public double add(double... numbers) {
        double result = 0;
        for (double n : numbers) {
            result += n;
        }
        return result;
    }

    public double subtract(double... numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("Need at least one number");
        }

        double result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result -= numbers[i];
        }
        return result;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero");
        }
        return a / b;
    }

    public double power(double a, double b) {
        return Math.pow(a, b);
    }

    public double sqrt(double a) {
        if (a < 0) {
            throw new IllegalArgumentException("Cannot sqrt negative");
        }
        return Math.sqrt(a);
    }
}
