package org.example.Calculator.tokens;

public class CloseBracketToken extends OperationToken {
    public CloseBracketToken(int priority) {
        super(priority);
    }

    @Override
    protected NumericToken operation(NumericToken left, NumericToken right) {
        throw new UnsupportedOperationException();
    }
}
