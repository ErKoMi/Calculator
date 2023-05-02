package org.example.Calculator.nodes;

import org.example.Calculator.mathEngine.Math;

import java.util.ArrayList;
import java.util.Arrays;

public class OperationNode extends Node {
    Operation operation;
    ArrayList<Node> operands;

    public Operation getOperation() {
        return operation;
    }

    public OperationNode(Operation operation) {
        this.operation = operation;
    }

    public void setOperands(Node[] nodes) {
        if (operation.getCountArgs() != nodes.length) {
            throw new IllegalArgumentException(String.format(
                    "Неверное количество аргументов операции! %s. Ожидалось: %d - имеем %d",
                    operation, operation.getCountArgs(), nodes.length));
        }

        operands = new ArrayList<>(Arrays.asList(nodes));
    }

    @Override
    public NumericNode solve() {
        int[] operands = this.operands.stream().map(child -> child.solve().getValue()).mapToInt(Integer::intValue).toArray();
        int result = Math.resolve(operation, operands);
        return new NumericNode(result);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Node op: operands)
            stringBuilder.append(op.toString()).append(" ");
        stringBuilder.append(operation);
        return stringBuilder.toString();
    }
}
