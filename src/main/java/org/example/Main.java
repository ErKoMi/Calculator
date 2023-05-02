package org.example;

import org.example.Calculator.Calculator;
import org.example.Calculator.Expression;
import org.example.menu.Menu;
import org.example.menu.MenuItem;

import java.util.Scanner;
import static java.lang.System.out;

public class Main {
    static final Scanner in = new Scanner(System.in);
    static Calculator calculator;

    public static void main(String[] args) {
        calculator = new Calculator();
        Menu menu = new Menu();

        menu.addItem("solve", new MenuItem("Расчёт значения математического выражения",
                () -> {
                    String expr = in.nextLine().replace(" ", "");
                    try {
                        Expression.Result result = calculator.calculate(expr);
                        out.println(Menu.ANSI_BLUE + result + Menu.ANSI_RESET);
                    } catch (Exception exception){
                        out.println(Menu.ANSI_RED + exception.getMessage() + Menu.ANSI_RESET);
                    }
                },
                () -> true));

        menu.addItem("exit", new MenuItem("Выйти",
                () -> System.exit(0),
                () -> true));

        menu.start();
    }
}