package org.example.Calculator.tokens;

import java.util.HashMap;

public final class OperationTokenFactory {

    public static OperationToken tokenByOperation(Operation operation){
        return switch (operation){
            case OPENBRACKET -> new OpenBracketToken(0);
            case CLOSEBRACKET -> new CloseBracketToken(0);
            case ADD -> new PlusOperationToken(1);
            case SUBTRACT -> new MinusOperationToken(1);
            case MULTIPLY -> new MultiplyOperationToken(2);
            case DIVIDE -> new DivideOperationToken(2);
        };
    }
}
