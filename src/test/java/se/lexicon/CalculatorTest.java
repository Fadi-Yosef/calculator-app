package se.lexicon;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    Calculator calc = new Calculator();


    @Test
    void testAddMultiple() {
        assertEquals(60.0, calc.add(10, 20, 30), 1e-9);
    }

    @Test
    void testSubtractMultiple() {
        assertEquals(5.0, calc.subtract(20, 10, 5), 1e-9);
    }

    @Test
    void testMultiply() {
        assertEquals(50.0, calc.multiply(10, 5), 1e-9);
    }

    @Test
    void testDivide() {
        assertEquals(2.0, calc.divide(10, 5), 1e-9);
    }

    @Test
    void testDivideByZero() {
        assertThrows(IllegalArgumentException.class,
                () -> calc.divide(10, 0));
    }

    @Test
    void testPower() {
        assertEquals(8.0, calc.power(2, 3), 1e-9);
    }

    @Test
    void testSqrt() {
        assertEquals(5.0, calc.sqrt(25), 1e-9);
    }

    @Test
    void testSqrtNegativeThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> calc.sqrt(-4));
    }
}
