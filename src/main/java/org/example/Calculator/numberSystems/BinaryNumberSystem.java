package org.example.Calculator.numberSystems;

import java.text.NumberFormat;
import java.util.regex.Pattern;

public class BinaryNumberSystem implements INumberSystem {
    Pattern pattern;

    public BinaryNumberSystem(){
        pattern = Pattern.compile("^[0-1]*$");
    }

    @Override
    public Pattern getPattern() {
        return pattern;
    }

    @Override
    public double parse(String value) throws NumberFormatException {
        return 0;
    }

    @Override
    public String toString(double value) {
        return null;
    }
}
