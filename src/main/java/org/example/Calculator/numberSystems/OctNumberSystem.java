package org.example.Calculator.numberSystems;

import java.util.regex.Pattern;

public class OctNumberSystem implements INumberSystem {
    Pattern pattern;

    OctNumberSystem(){
        pattern = Pattern.compile("^[0-7]*$");
    }

    @Override
    public Pattern getPattern() {
        return pattern;
    }

    @Override
    public int parse(String value) throws NumberFormatException {
        return Integer.parseInt(value, 8);
    }

    @Override
    public String toString(int value) {
        return Integer.toOctalString(value);
    }
}
