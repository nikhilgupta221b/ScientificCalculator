package com.example.scientificcalculator;

public class Calculator {

    public double squareRoot(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("Cannot take the square root of a negative value.");
        }
        return Math.sqrt(x);
    }

    public long factorial(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("Cannot take the factorial of a negative value.");
        }
        long result = 1;
        for (int i = 2; i <= x; i++) {
            result *= i;
        }
        return result;
    }

    public double naturalLogarithm(double x) {
        if (x <= 0) {
            throw new IllegalArgumentException("Cannot take the logarithm of a non-positive value.");
        }
        return Math.log(x);
    }

    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
}
