package org.example.Calculator.operations;

public class MultiplyOperationNode extends OperationNode {
    public MultiplyOperationNode() {
        operation = Operation.MULTIPLY;
    }

    @Override
    protected NumericNode operation(NumericNode left, NumericNode right) {
        return new NumericNode(left.getValue() * right.getValue());
    }

    @Override
    public String toString() {
        return "*";
    }
}
