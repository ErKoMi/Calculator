package org.example;

import org.example.Calculator.numberSystems.NumberSystems;
import org.example.Calculator.parsers.Parser;

public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser();
        Expression expression = null;
        try {
            parser.setNumberSystem(NumberSystems.DECIMAL);
            expression = parser.parse("(10 - 2) ^ 2");
            expression.print();
            System.out.println(expression.solve());
        } catch (Exception e) {
            System.out.println("exception: " + e.getMessage());
        }
    }
}