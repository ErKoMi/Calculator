package org.example.Calculator.numberSystems;

import java.text.NumberFormat;
import java.util.regex.Pattern;

public class BinaryNumberSystem implements INumberSystem {
    Pattern pattern;
    int radix = 2;

    BinaryNumberSystem(){
        pattern = Pattern.compile("^[01]*$");
    }

    @Override
    public Pattern getPattern() {
        return pattern;
    }

    @Override
    public int parse(String value) throws NumberFormatException {
        return Integer.parseInt(value, radix);
    }

    @Override
    public String toString(int value) {
        return Integer.toBinaryString(value);
    }

    @Override
    public int getRadix() {
        return radix;
    }
}
