package org.example.Calculator.operations;

public class CloseBracketNode extends OperationNode {

    public CloseBracketNode() {
        operation = Operation.CLOSEBRACKET;
    }

    @Override
    protected NumericNode operation(NumericNode left, NumericNode right) {
        throw new UnsupportedOperationException();
    }
}
