package org.example.Calculator.operations;

public class DivideOperationNode extends OperationNode {
    public DivideOperationNode() {
        operation = Operation.DIVIDE;
    }

    @Override
    protected NumericNode operation(NumericNode left, NumericNode right) {
        return new NumericNode(left.getValue() / right.getValue());
    }

    @Override
    public String toString() {
        return "/";
    }
}
