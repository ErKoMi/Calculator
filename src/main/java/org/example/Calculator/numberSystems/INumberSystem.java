package org.example.Calculator.numberSystems;

import java.util.regex.Pattern;

public interface INumberSystem {
    Pattern getPattern();
    double parse(String value) throws NumberFormatException;
    String toString(double value);
}
