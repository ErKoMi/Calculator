package org.example.Calculator.tokens;

public class OperationTokenFactory {
    public static OperationToken tokenByString(String tokenStr){

        switch (tokenStr){
            case "+" -> new PlusOperationToken();
            case "-" -> new MinusOperationToken();
        }

        throw new IllegalArgumentException("Illegal operation!: " + tokenStr);
    }
}
