package se.lexicon;

import javax.swing.*;
import java.awt.*;

public class CalculatorGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculator calc = new Calculator();

            JFrame frame = new JFrame("Calculator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(350, 220);
            frame.setLayout(new GridLayout(6, 1, 5, 5));

            JTextField numbersField = new JTextField();
            JTextField opField = new JTextField();
            JLabel resultLabel = new JLabel("Result: ");
            JButton button = new JButton("Calculate");

            frame.add(new JLabel("Numbers (space separated):"));
            frame.add(numbersField);
            frame.add(new JLabel("Operator (+, -, *, /, ^, sqrt):"));
            frame.add(opField);
            frame.add(button);
            frame.add(resultLabel);

            button.addActionListener(e -> {
                try {
                    String op = opField.getText().trim().toLowerCase();
                    String input = numbersField.getText().trim();

                    double result;

                    if (op.equals("+") || op.equals("-")) {
                        String[] parts = input.split("\\s+");
                        double[] nums = new double[parts.length];
                        for (int i = 0; i < parts.length; i++) nums[i] = Double.parseDouble(parts[i]);
                        result = op.equals("+") ? calc.add(nums) : calc.subtract(nums);
                    } else if (op.equals("*") || op.equals("/")) {
                        String[] parts = input.split("\\s+");
                        if (parts.length != 2) throw new IllegalArgumentException("Need exactly 2 numbers");
                        double a = Double.parseDouble(parts[0]);
                        double b = Double.parseDouble(parts[1]);
                        result = op.equals("*") ? calc.multiply(a, b) : calc.divide(a, b);
                    } else if (op.equals("^")) {
                        String[] parts = input.split("\\s+");
                        if (parts.length != 2) throw new IllegalArgumentException("Need base and exponent");
                        result = calc.power(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]));
                    } else if (op.equals("sqrt")) {
                        result = calc.sqrt(Double.parseDouble(input));
                    } else {
                        throw new IllegalArgumentException("Invalid operator");
                    }

                    resultLabel.setText("Result: " + result);
                } catch (Exception ex) {
                    resultLabel.setText("Error: " + ex.getMessage());
                }
            });

            frame.setVisible(true);
        });
    }
}
