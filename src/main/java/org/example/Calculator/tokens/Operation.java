package org.example.Calculator.tokens;

public enum Operation {
    OPENBRACKET("("),
    CLOSEBRACKET(")"),
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String token;

    Operation(String token) {
        this.token = token;
    }

    public static Operation byString(String str) {
        for (Operation op : values()) {
            if (op.token.equals(str)) {
                return op;
            }
        }

        throw new IllegalArgumentException();
    }
}
