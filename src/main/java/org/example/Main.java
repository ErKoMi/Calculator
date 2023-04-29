package org.example;

import org.example.Calculator.parsers.Parser;

public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser();
        Expression expression = null;
        try {
            expression = parser.parse("-10 + ((4 - 2) * (5 + 2) - 5 * 2) / 2");
            expression.print();
            System.out.println(expression.solve());
        } catch (Exception e) {
            System.out.println("exception: " + e.getMessage());
        }
    }
}