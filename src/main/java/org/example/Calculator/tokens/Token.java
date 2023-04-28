package org.example.Calculator.tokens;

public abstract class Token {
    Token leftChild;
    Token rightChild;

    protected abstract NumericToken solve();

    public void print(){
        if(leftChild != null)
            leftChild.print();
        if(rightChild != null)
            rightChild.print();
        System.out.print(this.toString());
    }
}
