package org.example.Calculator.operations;

public class OpenBracketNode extends OperationNode {
    public OpenBracketNode(int priority) {
        super(priority);
    }

    @Override
    protected NumericNode operation(NumericNode left, NumericNode right) {
        throw new UnsupportedOperationException();
    }
}
