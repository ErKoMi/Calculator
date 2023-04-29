package org.example.Calculator.operations;

public final class OperationNodeFactory {

    public static OperationNode tokenByOperation(Operation operation){
        return switch (operation){
            case OPENBRACKET -> new OpenBracketNode(0);
            case CLOSEBRACKET -> new CloseBracketNode(0);
            case ADD -> new PlusOperationNode(1);
            case SUBTRACT -> new MinusOperationNode(1);
            case MULTIPLY -> new MultiplyOperationNode(2);
            case DIVIDE -> new DivideOperationNode(2);
        };
    }
}
