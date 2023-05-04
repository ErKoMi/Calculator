package org.example.Calculator.numberSystems;

import org.example.Calculator.parsers.Parser;

import java.util.regex.Pattern;

public class HexNumberSystem implements INumberSystem {

    Pattern pattern;
    int radix = 16;

    HexNumberSystem() {
        pattern = Pattern.compile("^[0-9A-F]+$");
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
        return Integer.toHexString(value).toUpperCase();
    }

    @Override
    public int getRadix() {
        return radix;
    }
}
