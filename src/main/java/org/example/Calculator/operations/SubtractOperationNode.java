package org.example.Calculator.operations;

public class SubtractOperationNode extends OperationNode {
    public SubtractOperationNode() {
        operation = Operation.SUBTRACT;
    }

    @Override
    protected NumericNode operation(NumericNode left, NumericNode right) {
        return new NumericNode(left.getValue() - right.getValue());
    }

    @Override
    public String toString() {
        return "-";
    }
}
