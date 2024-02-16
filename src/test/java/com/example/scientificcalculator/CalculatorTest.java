package com.example.scientificcalculator;

import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void testSquareRoot() {
        assertEquals("Square root of 4 should be 2.", 2.0, calculator.squareRoot(4), 0.0);
    }

    @Test
    public void testFactorial() {
        assertEquals("Factorial of 5 should be 120.", 120, calculator.factorial(5));
    }

    @Test
    public void testNaturalLogarithm() {
        assertEquals("Natural logarithm of e should be 1.", 1.0, calculator.naturalLogarithm(Math.E), 0.0);
    }

    @Test
    public void testPower() {
        assertEquals("2 to the power of 3 should be 8.", 8.0, calculator.power(2, 3), 0.0);
    }
}
