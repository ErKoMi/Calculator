package org.example.Calculator.tokens;

public class OpenBracketToken extends OperationToken {
    public OpenBracketToken(int priority) {
        super(priority);
    }

    @Override
    protected NumericToken operation(NumericToken left, NumericToken right) {
        throw new UnsupportedOperationException();
    }
}
