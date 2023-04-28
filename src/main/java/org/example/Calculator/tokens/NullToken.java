package org.example.Calculator.tokens;

public class NullToken extends Token {
    @Override
    protected NumericToken solve() {
        return null;
    }
}
