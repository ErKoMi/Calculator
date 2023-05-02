package org.example.Calculator.nodes;

public class NumericNode extends ValueNode {
    private final int value;

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
