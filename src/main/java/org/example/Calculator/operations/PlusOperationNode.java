package org.example.Calculator.operations;

public class PlusOperationNode extends OperationNode {
    public PlusOperationNode(int priority) {
        super(priority);
    }

    @Override
    protected NumericNode operation(NumericNode left, NumericNode right) {
        return new NumericNode(left.getValue() + right.getValue());
    }

    @Override
    public String toString() {
        return "+";
    }
}
