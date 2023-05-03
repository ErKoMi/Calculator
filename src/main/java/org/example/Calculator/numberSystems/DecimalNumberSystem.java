package org.example.Calculator.numberSystems;

import java.util.regex.Pattern;

public class DecimalNumberSystem implements INumberSystem {
    static Pattern pattern = Pattern.compile("^\\d+$");
    int radix = 10;

    DecimalNumberSystem(){};
    @Override
    public Pattern getPattern() {
        return pattern;
    }

    @Override
    public int parse(String value) throws NumberFormatException {
        return Integer.parseInt(value);
    }

    @Override
    public String toString(int value) {
        return String.valueOf(value);
    }

    public int getRadix() {
        return radix;
    }
}
