package com.example.design.ocp;

import java.util.Scanner;

public class CalculatorV1 {
    public double calculate(double a, double b, char op) {
        return switch (op) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a % b;
            default -> throw new IllegalArgumentException("Invalid operation");
        };
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first number - ");
        double a = sc.nextDouble();
        System.out.print("Enter the Second number - ");
        double b = sc.nextDouble();
        System.out.print("Enter the type of operation you want to perform (+, -, *, /, %) - ");
        char op = sc.next().charAt(0);
        System.out.println("Result is: " + new CalculatorV1().calculate(a, b, op));
    }
}
