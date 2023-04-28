package org.example.Calculator.tokens;

public class OperationTokenFactory {
    public static OperationToken tokenByString(String tokenStr){
        return switch (tokenStr){
            case "+" -> new PlusOperationToken(1);
            case "-" -> new MinusOperationToken(1);
            case "*" -> new MultiplyOperationToken(2);
            case "/" -> new DivideOperationToken(2);
            default -> throw new IllegalArgumentException("Unknown operation!: " + tokenStr);
        };
    }
}
