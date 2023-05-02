package org.example.Calculator.nodes;

public enum Operation {
    OPENBRACKET(0, 0),
    CLOSEBRACKET(0, 0),
    ADD(1, 2),
    SUBTRACT(1, 2),
    MULTIPLY(2, 2),
    DIVIDE(2, 2);

    private int priority;
    private int countArgs;

    Operation(int priority, int countArgs) {

        this.priority = priority;
        this.countArgs = countArgs;
    }

    public int getPriority() {
        return priority;
    }

    public int getCountArgs() {
        return countArgs;
    }
}
