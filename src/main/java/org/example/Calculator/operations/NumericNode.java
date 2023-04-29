package org.example.Calculator.operations;

public class NumericNode extends Node {
    private double value;

    public double getValue() {
        return value;
    }

    public NumericNode(double value){
        this.value = value;
    }

    @Override
    protected NumericNode solve() {
        return this;
    }

    @Override
    public String toString() {
        return String.valueOf(getValue());
    }
}
