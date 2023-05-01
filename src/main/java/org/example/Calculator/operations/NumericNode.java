package org.example.Calculator.operations;

public class NumericNode extends Node {
    private int value;

    public int getValue() {
        return value;
    }

    public NumericNode(int value){
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
