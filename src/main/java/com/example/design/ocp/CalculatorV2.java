package com.example.design.ocp;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class CalculatorV2 {

    public double calculate(CalcOperation operation) {
        if (operation == null) {
            throw new InvalidParameterException("operation can not be empty");
        }
        return operation.perform();
    }

    public static void main(String[] args) {
        Map<String, OperationFactory> opsFactories = new HashMap<>() {{
            put("+", new AdditionOpsFactory());
            put("-", new SubtractionOpsFactory());
            put("*", new MultiplicationOpsFactory());
            put("/", new DivisionOpsFactory());
        }};

        Scanner sc = new Scanner(System.in);
        InputPair numbers = getInputNumbers(sc);
        char op = getOperationType(sc);
        CalcOperation operation = Optional.ofNullable(opsFactories.get(String.valueOf(op)))
                .orElseThrow(() -> new InvalidParameterException("This operation can not be performed"))
                .create(numbers);
        System.out.println("Result is: " + new CalculatorV2().calculate(operation));
    }

    private static char getOperationType(Scanner sc) {
        System.out.print("Enter the type of operation you want to perform (+, -, *, /, %) - ");
        char op = sc.next().charAt(0);
        return op;
    }

    private static InputPair getInputNumbers(Scanner sc) {

        System.out.print("Enter the first number - ");
        double arg1 = sc.nextDouble();
        System.out.print("Enter the Second number - ");
        double arg2 = sc.nextDouble();
        return new InputPair(arg1, arg2);
    }
    public record Item(double price) { }
    public record Order(List<Item> items) {}

}


;

