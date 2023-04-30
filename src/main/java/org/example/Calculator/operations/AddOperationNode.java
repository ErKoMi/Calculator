package org.example.Calculator.operations;

public class AddOperationNode extends OperationNode {
    public AddOperationNode() {
        operation = Operation.ADD;
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
