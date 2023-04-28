package org.example.Calculator.tokens;

public abstract class Token {
    Token leftChild = new NullToken();
    Token rightChild = new NullToken();

    protected abstract NumericToken solve();
}
