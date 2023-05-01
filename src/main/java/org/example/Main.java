package org.example;

import org.example.Calculator.numberSystems.NumberSystems;
import org.example.Calculator.parsers.Parser;

public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser();
        Expression expression = null;
        try {
            parser.setNumberSystem(NumberSystems.HEX);
            expression = parser.parse("F + F");
            expression.print();
            System.out.println(expression.solve());
        } catch (Exception e) {
            System.out.println("exception: " + e.getMessage());
        }
    }
}