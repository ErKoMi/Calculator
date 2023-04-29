package org.example.Calculator.operations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public static boolean isOperation(String str){
        return Arrays.stream(values()).anyMatch(v -> v.token.equals(str));
    }

    public static Operation byString(String str) {
        for (Operation op : values()) {
            if (op.token.equals(str)) {
                return op;
            }
        }

        throw new IllegalArgumentException();
    }

    public static List<String> getTokens() {
        return Arrays.stream(values()).map(v -> v.token).collect(Collectors.toList());
    }
}
