package org.example.Calculator.numberSystems;

import java.util.regex.Pattern;

public interface INumberSystem {
    Pattern getPattern();
    int parse(String value) throws NumberFormatException;
    String toString(int value);
    int getRadix();
}
