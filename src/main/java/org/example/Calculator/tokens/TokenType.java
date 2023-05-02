package org.example.Calculator.tokens;

import java.util.regex.Pattern;

public enum TokenType implements ITokenType {

    NUMBER("[0-9A-Z]+"),
    OPENBRACKET("\\("),
    CLOSEBRACKET("\\)"),
    PLUS("\\+"),
    MINUS("\\-"),
    ASTERISK("\\*"),
    SLASH("\\/");


    private final Pattern pattern;

    TokenType(String tokenPattern) {
        pattern = Pattern.compile("^" + tokenPattern);
    }

    public Pattern getPattern() {
        return pattern;
    }
}
