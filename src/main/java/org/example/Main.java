package org.example;

import org.example.Calculator.parsers.Parser;

public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser();
        Expression expression = parser.parse("10 + 5 - 5 * 2 / 2");
        expression.print();
        System.out.println(expression.solve());
    }
}