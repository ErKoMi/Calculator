package org.example.Calculator.tokens;

public class MinusOperationToken extends OperationToken {
    @Override
    protected NumericToken operation(NumericToken left, NumericToken right) {
        return new NumericToken(left.getValue() - right.getValue());
    }
}
