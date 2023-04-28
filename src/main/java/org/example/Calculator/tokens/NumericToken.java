package org.example.Calculator.tokens;

public class NumericToken extends Token {
    private double value;

    public double getValue() {
        return value;
    }

    public NumericToken(double value){
        this.value = value;
    }

    @Override
    protected NumericToken solve() {
        return this;
    }
}
