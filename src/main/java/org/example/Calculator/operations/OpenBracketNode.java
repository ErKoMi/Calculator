package org.example.Calculator.operations;

public class OpenBracketNode extends OperationNode {
    public OpenBracketNode() {
        operation = Operation.OPENBRACKET;
    }

    @Override
    protected NumericNode operation(NumericNode left, NumericNode right) {
        throw new UnsupportedOperationException();
    }
}
