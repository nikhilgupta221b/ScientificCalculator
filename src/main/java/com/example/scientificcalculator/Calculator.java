package com.example.scientificcalculator;

import java.util.Scanner;

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

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Calculator");
            System.out.println("1: Square root");
            System.out.println("2: Factorial");
            System.out.println("3: Natural logarithm");
            System.out.println("4: Power");
            System.out.println("5: Exit");
            System.out.print("Enter choice (1-5): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter a number: ");
                    double num1 = scanner.nextDouble();
                    System.out.println("Square root of " + num1 + " is: " + calculator.squareRoot(num1));
                    break;
                case 2:
                    System.out.print("Enter a number: ");
                    int num2 = scanner.nextInt();
                    System.out.println("Factorial of " + num2 + " is: " + calculator.factorial(num2));
                    break;
                case 3:
                    System.out.print("Enter a number: ");
                    double num3 = scanner.nextDouble();
                    System.out.println("Natural logarithm of " + num3 + " is: " + calculator.naturalLogarithm(num3));
                    break;
                case 4:
                    System.out.print("Enter the base: ");
                    double base = scanner.nextDouble();
                    System.out.print("Enter the exponent: ");
                    double exponent = scanner.nextDouble();
                    System.out.println(base + " raised to the power of " + exponent + " is: " + calculator.power(base, exponent));
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }

        scanner.close();
    }
}
