package se.lexicon;
import java.util.Scanner;
public class ConsoleCalculatorAPP { public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Calculator calculator = new Calculator();


    boolean running = true;

    System.out.println("=== Console Calculator ===");

    while (running) {
        System.out.println("\nChoose operation: +  -  *  /");
        System.out.print("Operator: ");
        String op = scanner.nextLine().trim();
        if (op.equals("+") || op.equals("-")) {
            System.out.println("Enter numbers separated by spaces (example: 10 20 30 40):");
            String input = scanner.nextLine().trim();
            String[] parts = input.split("\\s+");

            double[] numbers = new double[parts.length];
            for (int i = 0; i < parts.length; i++) {
                numbers[i] = Double.parseDouble(parts[i]);
            }

            double result = op.equals("+")
                    ? calculator.add(numbers)
                    : calculator.subtract(numbers);

            System.out.println("Result: " + result);
            continue;
        }

        // Basic validation
        if (!op.equals("+") && !op.equals("-") && !op.equals("*") && !op.equals("/")) {
            System.out.println("Invalid operator. Try again.");
            continue;
        }

        double a;
        double b;

        try {
            System.out.print("Enter first number: ");
            a = Double.parseDouble(scanner.nextLine().trim());

            System.out.print("Enter second number: ");
            b = Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number input. Please enter valid numbers.");
            continue;
        }

        // Division by zero check
        if (op.equals("/") && b == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            continue;
        }

        double result = 0;

        if (op.equals("+")) {
            result = a + b;
        } else if (op.equals("-")) {
            result = a - b;
        } else if (op.equals("*")) {
            result = a * b;
        } else if (op.equals("/")) {
            result = a / b;
        }

        System.out.println("Result: " + result);

        System.out.print("Do another calculation? (y/n): ");
        String choice = scanner.nextLine().trim().toLowerCase();

        if (!choice.equals("y")) {
            running = false;
        }
    }

    System.out.println("Bye 👋");
    scanner.close();
}
}