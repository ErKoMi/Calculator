package org.example.Calculator.tokens;

public class MultiplyOperationToken extends OperationToken {
    public MultiplyOperationToken(int priority) {
        super(priority);
    }

    @Override
    protected NumericToken operation(NumericToken left, NumericToken right) {
        return new NumericToken(left.getValue() * right.getValue());
    }

    @Override
    public String toString() {
        return "*";
    }
}
