package org.example.Calculator.parsers;

import org.example.Calculator.numberSystems.INumberSystem;
import org.example.Calculator.numberSystems.NumberSystems;
import org.example.Calculator.nodes.*;
import org.example.Calculator.tokens.Token;
import org.example.Calculator.tokens.TokenType;
import org.example.Expression;

import java.util.ArrayList;
import java.util.EmptyStackException;
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
        numberSystem = NumberSystems.DECIMAL;
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
                    int value = numberSystem.parse(token.value());
                    result.push(new NumericNode(value));
                } else {
                    throw new Exception("Недопустимое число! " + token.value());
                }

            } else if (token.type() == TokenType.OPENBRACKET) {
                operations.push(new OperationNode(Operation.OPENBRACKET));
            } else if (token.type() == TokenType.CLOSEBRACKET) {
                
                try {
                    shiftWhile(result, operations, Operation.OPENBRACKET.getPriority() + 1);
                } catch (EmptyStackException ex) {
                    throw new Exception("Количество закрывающих скобок не равно количеству открывающих!");
                }

                if (!operations.isEmpty() || operations.peek().getOperation() == Operation.OPENBRACKET) {
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
                if(i > 0 && (tokens.get(i - 1).type() == TokenType.NUMBER || tokens.get(i - 1).type() == TokenType.CLOSEBRACKET)){
                    oper = Operation.SUBTRACT;
                } else {
                    oper = Operation.INVERT;
                }
            } else if (token.type() == TokenType.CIRCUMFLEX) {
                oper = Operation.POW;
            }

            if(oper != null){
                try{
                    shiftWhile(result, operations, oper.getPriority());
                } catch (EmptyStackException ignore){

                }
                operations.push(new OperationNode(oper));
            }
        }

        try{
            shiftWhile(result, operations, -1);
        } catch (EmptyStackException ignore){

        }

        if(result.size() != 1){
            throw new IllegalArgumentException("Illegal expression!");
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
            setOperands(result, tmp);
            result.push(tmp);
            tmp = operations.peek();
        }
    }

    private static void setOperands(Stack<Node> operands, OperationNode operationNode){
        Node[] tmp = new Node[operationNode.getOperation().getCountArgs()];
        for(int i = tmp.length - 1; i >= 0; i--){
            tmp[i] = operands.pop();
        }

        operationNode.setOperands(tmp);
    }
}
