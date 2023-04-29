package org.example.Calculator.parsers;

import org.example.Calculator.tokens.Operation;
import org.example.Calculator.tokens.OperationToken;
import org.example.Calculator.tokens.OperationTokenFactory;

import static java.lang.Character.*;

public class ParserStateOperation extends ParserState {
    protected ParserStateOperation(Parser parser) {
        super(parser);
    }

    @Override
    public void add(char c) {
        try{
            Operation operation = Operation.byString(parseStr.toString());
            OperationToken operationToken = OperationTokenFactory.tokenByOperation(operation);
            endParse(operationToken, c);
        } catch (IllegalArgumentException e) {
            if(isDigit(c)){
                throw new UnsupportedOperationException("Unknown operation: \"" + parseStr.toString() + "\"");
            }

            parseStr.append(c);
        }
    }
}
