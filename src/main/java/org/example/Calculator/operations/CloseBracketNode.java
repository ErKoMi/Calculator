package org.example.Calculator.operations;

public class CloseBracketNode extends OperationNode {
    public CloseBracketNode(int priority) {
        super(priority);
    }

    @Override
    protected NumericNode operation(NumericNode left, NumericNode right) {
        throw new UnsupportedOperationException();
    }
}
