package org.example.Calculator.tokens;

public abstract class OperationToken extends Token {
    @Override
    public NumericToken solve() {
        NumericToken left = leftChild.solve();
        NumericToken right = rightChild.solve();
        return operation(left, right);
    }

    public OperationToken setFirstOperand(Token token){
        leftChild = token;
        return this;
    }

    public OperationToken setSecondOperand(Token token){
        rightChild = token;
        return this;
    }

    protected abstract NumericToken operation(NumericToken left, NumericToken right);
}
