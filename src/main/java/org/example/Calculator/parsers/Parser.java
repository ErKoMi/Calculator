package org.example.Calculator.parsers;

import org.example.Calculator.numberSystems.DecimalNumberSystem;
import org.example.Calculator.numberSystems.INumberSystem;
import org.example.Calculator.operations.*;
import org.example.Calculator.tokens.Token;
import org.example.Calculator.tokens.TokenType;
import org.example.Expression;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;

public class Parser {
    INumberSystem numberSystem;

    public void setNumberSystem(INumberSystem numberSystem) {
        this.numberSystem = numberSystem;
    }

    public INumberSystem getNumberSystem() {
        return numberSystem;
    }

    public Parser() {
        numberSystem = new DecimalNumberSystem();
    }

    public Expression parse(String exprStr) {
        exprStr = exprStr.replace(" ", "");

        ArrayList<Token<TokenType>> tokens = Lexer.processingString(TokenType.class, exprStr);
        OperationNode op;
        try {
            op = makeTree(tokens);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }

        return new Expression(op);
    }

    OperationNode makeTree(ArrayList<Token<TokenType>> tokens) throws Exception {
        OperationNode root;

        Stack<Node> result = new Stack<>();
        Stack<OperationNode> operations = new Stack<>();

        for (int i = 0; i < tokens.size(); i++) {
            Token<TokenType> token = tokens.get(i);
            Operation oper = null;
            if (token.type() == TokenType.NUMBER) {
                if(numberSystem.getPattern().matcher(token.value()).matches()){
                    double value = numberSystem.parse(token.value());
                    result.push(new NumericNode(value));
                } else {
                    throw new Exception("Недопустимое число! " + token.value());
                }

            } else if (token.type() == TokenType.OPENBRACKET) {
                operations.push(nodeByOperation(Operation.OPENBRACKET));
            } else if (token.type() == TokenType.CLOSEBRACKET) {
                
                try {
                    shiftWhile(result, operations, Operation.OPENBRACKET.getPriority() + 1);
                } catch (EmptyStackException ex) {
                    throw new Exception("Количество закрывающих скобок не равно количеству открывающих!");
                }

                if (!operations.isEmpty() || operations.peek() instanceof OpenBracketNode) {
                    operations.pop();
                } else {
                    throw new Exception("Количество закрывающих скобок не равно количеству открывающих!");
                }

            } else if(token.type() == TokenType.PLUS){
                oper =  Operation.ADD;
            } else if(token.type() == TokenType.ASTERISK) {
                oper = Operation.MULTIPLY;
            } else if(token.type() == TokenType.SLASH) {
                oper = Operation.DIVIDE;
            } else if(token.type() == TokenType.MINUS) {
                if(i > 0 && tokens.get(i - 1).type() == TokenType.NUMBER){
                    oper = Operation.SUBTRACT;
                } else {
                    // TODO: 01.05.2023 Унарный минус
                }
            }

            if(oper != null){
                try{
                    shiftWhile(result, operations, oper.getPriority());
                } catch (EmptyStackException ignore){

                }
                operations.push(nodeByOperation(oper));
            }
        }

        try{
            shiftWhile(result, operations, -1);
        } catch (EmptyStackException ignore){

        }

        root = (OperationNode) result.pop();

        if (!operations.isEmpty() || root == null) {
            throw new IllegalArgumentException("Illegal expression!");
        }

        return root;
    }

    private static void shiftWhile(Stack<Node> result, Stack<OperationNode> operations, int priority) throws EmptyStackException {
        OperationNode tmp = operations.peek();
        while (tmp.getOperation().getPriority() >= priority) {
            tmp = operations.pop();
            tmp.setSecondOperand(result.pop()).setFirstOperand(result.pop());
            result.push(tmp);
            tmp = operations.peek();
        }
    }

    public static OperationNode nodeByOperation(Operation op){
        return switch (op){
            case OPENBRACKET -> new OpenBracketNode();
            case CLOSEBRACKET -> new CloseBracketNode();
            case ADD -> new AddOperationNode();
            case SUBTRACT -> new SubtractOperationNode();
            case MULTIPLY -> new MultiplyOperationNode();
            case DIVIDE -> new DivideOperationNode();
        };
    }
}
