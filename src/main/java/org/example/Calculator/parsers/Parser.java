package org.example.Calculator.parsers;

import org.example.Calculator.tokens.*;
import org.example.Expression;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;

public class Parser {

    static HashMap<Class<?>, Integer> priority = new HashMap<>();

    ArrayList<Token> tokens = new ArrayList<>();

    private ParserState state;

    private final ParserStateOperation parserStateOperation = new ParserStateOperation(this);
    private final ParserStateNumeric parserStateNumeric = new ParserStateNumeric(this);
    private final EndParserState endParserState = new EndParserState(this);

    public ParserStateOperation getParserStateOperation() {
        return parserStateOperation;
    }

    public ParserStateNumeric getParserStateNumeric() {
        return parserStateNumeric;
    }

    public EndParserState getEndParserState() {
        return endParserState;
    }

    public Parser() {
        setState(new ParserStateNumeric(this));

        priority.put(MinusOperationToken.class, 1);
        priority.put(PlusOperationToken.class, 1);
    }

    void setState(ParserState state) {
        this.state = state;
    }

    public void addToken(Token token) {
        tokens.add(token);
    }

    public Expression parse(String exprStr) {
        state = getParserStateNumeric();
        exprStr = exprStr.replace(" ", "") + "\0";
        for (char c : exprStr.toCharArray()) {
            state.add(c);
        }

        return new Expression(makeTree());
    }

    OperationToken makeTree(){
        OperationToken root = null;

        Stack<Token> result = new Stack<>();
        Stack<OperationToken> operations = new Stack<>();

        for (Token token: tokens){
            if(token instanceof NumericToken){
                result.push(token);
            } else if(token instanceof OperationToken oper){
                try {
                    OperationToken tmp = operations.peek();
                    while (tmp.getPriority() >= oper.getPriority()) {
                        tmp = operations.pop();
                        tmp.setSecondOperand(result.pop()).setFirstOperand(result.pop());
                        result.push(tmp);
                        tmp = operations.peek();
                    }
                } catch (EmptyStackException ignored){
                }

                operations.push(oper);
            }
        }

        while (!operations.isEmpty()){
            OperationToken tmp = operations.pop();
            tmp.setSecondOperand(result.pop()).setFirstOperand(result.pop());
            result.push(tmp);
        }

        root = (OperationToken)result.pop();

        return root;
    }
}
