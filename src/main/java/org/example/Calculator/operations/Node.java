package org.example.Calculator.operations;

public abstract class Node {
    Node leftChild;
    Node rightChild;

    protected abstract NumericNode solve();

    public void print(){
        if(leftChild != null)
            leftChild.print();
        if(rightChild != null)
            rightChild.print();
        System.out.print(this.toString());
    }
}
