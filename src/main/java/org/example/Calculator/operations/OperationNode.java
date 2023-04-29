package org.example.Calculator.operations;

public abstract class OperationNode extends Node {
    int priority = 0;

    public int getPriority() {
        return priority;
    }

    public OperationNode(int priority){
        this.priority = priority;
    }

    @Override
    public NumericNode solve() {
        NumericNode left = leftChild.solve();
        NumericNode right = rightChild.solve();
        return operation(left, right);
    }

    public OperationNode setFirstOperand(Node token){
        leftChild = token;
        return this;
    }

    public OperationNode setSecondOperand(Node token){
        rightChild = token;
        return this;
    }

    protected abstract NumericNode operation(NumericNode left, NumericNode right);
}
