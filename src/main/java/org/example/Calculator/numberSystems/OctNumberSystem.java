package org.example.Calculator.numberSystems;

import java.util.regex.Pattern;

public class OctNumberSystem implements INumberSystem {
    Pattern pattern;
    int radix = 8;

    OctNumberSystem(){
        pattern = Pattern.compile("^[0-7]*$");
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
        return Integer.toOctalString(value);
    }

    @Override
    public int getRadix() {
        return radix;
    }
}
