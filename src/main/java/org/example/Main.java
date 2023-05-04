package org.example;

import org.example.Calculator.Calculator;
import org.example.Calculator.Expression;
import org.example.Calculator.numberSystems.NumberSystems;
import org.example.menu.Menu;
import org.example.menu.MenuItem;

import static java.lang.System.out;

public class Main {
    static Calculator calculator;

    public static void main(String[] args) {
        calculator = new Calculator();
        Menu menu = new Menu();
        menu.setStatus("Текущая система счисления: " + calculator.getNumSystem().getRadix());

        menu.addItem("solve", new MenuItem("Расчёт значения математического выражения",
                a -> {
                    if (a.length < 1) {
                        out.println("Using solve <expression>");
                        return;
                    }
                    String expr = String.join("", a);
                    Expression.Result result = calculator.calculate(expr);
                    out.println(Menu.ANSI_BLUE + result + Menu.ANSI_RESET);
                },
                () -> true));

        menu.addItem("numsys", new MenuItem("Смена системы счисления",
                a ->{
                    if(a.length != 1){
                        out.println("Using numsys <number system>");
                        return;
                    }

                    calculator.setNumSystem(NumberSystems.fromString(a[0].toUpperCase()));
                    menu.setStatus("Текущая система счисления: " + calculator.getNumSystem().getRadix());
                },
                () -> true ));

        menu.addItem("exit", new MenuItem("Выйти",
                (a) -> {
                    menu.exit();
                    System.exit(0);
                },
                () -> true));

        menu.start();
    }
}