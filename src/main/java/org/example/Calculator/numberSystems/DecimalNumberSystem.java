package org.example.Calculator.numberSystems;

import java.util.regex.Pattern;

public class DecimalNumberSystem implements INumberSystem {
    static Pattern pattern = Pattern.compile("^\\d+([,.]\\d+)?$");
    @Override
    public Pattern getPattern() {
        return pattern;
    }

    @Override
    public double parse(String value) throws NumberFormatException {
        return Double.parseDouble(value);
    }

    @Override
    public String toString(double value) {
        return String.valueOf(value);
    }
}
