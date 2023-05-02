package org.example.Calculator.mathEngine;

import org.example.Calculator.nodes.Operation;

public class Math {

    public static int resolve(Operation operation, int[] args){
        if(operation.getCountArgs() != args.length){
            throw new IllegalArgumentException(String.format(
                    "Неверное количество аргументов операции! %s. Ожидалось: %d - имеем %d",
                    operation, operation.getCountArgs(), args.length));
        }

        return switch (operation){
            case ADD -> args[0] + args[1];
            case SUBTRACT -> args[0] - args[1];
            case MULTIPLY -> args[0] * args[1];
            case DIVIDE -> args[0] / args[1];
            case INVERT -> -1 * args[0];
            default -> throw new UnsupportedOperationException();
        };
    }
}
