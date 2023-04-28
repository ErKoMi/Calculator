package org.example.Calculator.parsers;
import org.example.Calculator.tokens.Token;

import static java.lang.Character.isDigit;

public abstract class ParserState {
    protected final Parser parser;
    protected StringBuilder parseStr;
    protected ParserState(Parser parser) {
        this.parser = parser;
        parseStr = new StringBuilder();
    }

    public abstract void add(char c);

    protected void endParse(Token token, char c){
        parseStr = new StringBuilder();
        parser.addToken(token);
        ParserState next = null;

        if(c == '\0'){
            next = parser.getEndParserState();
        }else if (isDigit(c)) {
            next = parser.getParserStateNumeric();
        } else {
            next = parser.getParserStateOperation();
        }

        next.add(c);
        parser.setState(next);
    }
}
