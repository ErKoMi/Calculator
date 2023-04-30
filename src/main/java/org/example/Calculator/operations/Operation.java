package org.example.Calculator.operations;

public enum Operation {
    OPENBRACKET(0),
    CLOSEBRACKET(0),
    ADD(1),
    SUBTRACT(1),
    MULTIPLY(2),
    DIVIDE(2);

    private int priority;

    Operation(int priority) {

        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
