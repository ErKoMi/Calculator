package org.example.Calculator.parsers;

import org.example.Calculator.tokens.OperationToken;
import org.example.Calculator.tokens.OperationTokenFactory;

import static java.lang.Character.*;

public class ParserStateOperation extends ParserState {
    protected ParserStateOperation(Parser parser) {
        super(parser);
    }

    @Override
    public void add(char c) {
        if (!isDigit(c)) {
            parseStr.append(c);
        } else {
            OperationToken operationToken = OperationTokenFactory.tokenByString(parseStr.toString());
            endParse(operationToken, c);
        }
    }
}
