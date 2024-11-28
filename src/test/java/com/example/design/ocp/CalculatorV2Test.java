package com.example.design.ocp;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;


public class CalculatorV2Test {
    public record Item(int points, double price) { }
    public void saveTotals(List<Item> items) {
        int totalPoints = 0;
        double totalCost = 0.0;
        for (Item item : items) {
            totalCost += item.price;
        }
        for (Item item : items) {
            totalPoints += item.points;
        }
    }

    public static void main(String[] args) {
        // Creating a list of Strings
        List<String> words = Arrays.asList("GFG", "Geeks", "for", "GeeksQuiz", "GeeksforGeeks");

        // Using reduce to find the longest string in the list
        Optional<String> longestString = words.stream()
                .reduce((word1, word2) -> {
                    System.out.println("word1=" + word1);
                    System.out.println("word2=" + word2);
                    return word1 + "-" + word2;
                });

        // Displaying the longest String
        longestString.ifPresent(System.out::println);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream().map(i -> i*2).reduce(0, (num1, num2) -> num1 + num2);
        System.out.println("sum=" + sum);

    }

    public static void report1(Writer out, List<Machine> machines, Robot robot) throws IOException {
        out.write("FACTORY REPORT\n");
        Iterator<Machine> line = machines.iterator();
        while (line.hasNext()) {
            Machine machine = (Machine) line.next();
            out.write("Machine " + machine.name());
            if (machine.bin() != null)
                out.write(" bin=" + machine.bin());
            out.write("\n");
        }
        out.write("\n");
        out.write("Robot");
        if (robot.location() != null)
            out.write(" location=" + robot.location());
        if (robot.bin() != null)
            out.write(" bin=" + robot.bin());
        out.write("\n========\n");
    }

    public static void report2(Writer out, List machines, Robot robot) throws Exception {
        printTitle(out);
        printMachines(out, machines);
        printRobot(out, robot);
    }
    private static void printTitle(Writer out) throws IOException {
        out.write("FACTORY REPORT\n");
    }
    private static void printMachines(Writer out, List machines) throws Exception {
        Iterator line = machines.iterator();
        while (line.hasNext()) {
            Machine machine = (Machine)line.next();
            out.write("Machine " + machine.name());
            if (machine.bin() != null)
                out.write(" bin=" + machine.bin());
            out.write("\n");
        }
        out.write("\n");
    }
    private static void printRobot (Writer out, Robot robot) throws Exception {
        out.write("Robot");
        if (robot.location() != null)
            out.write(" location=" + robot.location());
        if (robot.bin() != null)
            out.write(" bin=" + robot.bin());
        out.write("\n========\n");
    }


    public record Robot(String location, String bin) { }

    public record Machine(String name, String bin) { }
}







