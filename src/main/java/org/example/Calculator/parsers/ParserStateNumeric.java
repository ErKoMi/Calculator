package org.example.Calculator.parsers;

import org.example.Calculator.tokens.NumericToken;
import org.example.Calculator.tokens.Token;

import static java.lang.Character.*;

public class ParserStateNumeric extends ParserState {
    protected ParserStateNumeric(Parser parser) {
        super(parser);
    }

    @Override
    public void add(char c) {
        if(isDigit(c))
            parseStr.append(c);
        else{
            NumericToken token = new NumericToken(Double.parseDouble(parseStr.toString()));
            endParse(token, c);
        }
    }
}
