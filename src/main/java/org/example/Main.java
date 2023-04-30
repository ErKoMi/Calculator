package org.example;

import org.example.Calculator.parsers.Parser;

public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser();
        Expression expression = null;
        try {
            expression = parser.parse("(10 + 5) * 4 / (2A + 2BD)");
            expression.print();
            System.out.println(expression.solve());
        } catch (Exception e) {
            System.out.println("exception: " + e.getMessage());
        }
    }
}