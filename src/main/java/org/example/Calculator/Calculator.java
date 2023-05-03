package org.example.Calculator;

import org.example.Calculator.numberSystems.INumberSystem;
import org.example.Calculator.parsers.Lexer;
import org.example.Calculator.parsers.Parser;
import org.example.Calculator.tokens.Token;
import org.example.Calculator.tokens.TokenType;

import java.util.ArrayList;

public class Calculator {
    Parser parser;

    public Calculator(){
        parser = new Parser();
    }

    public Expression.Result calculate(String expr){
        ArrayList<Token<TokenType>> tokens = Lexer.processingString(TokenType.class, expr);
        Expression expression = parser.parse(tokens);
        return expression.solve();
    }

    public void setNumSystem(INumberSystem numSystem){
        parser.setNumberSystem(numSystem);
    }

    public INumberSystem getNumSystem(){
        return parser.getNumberSystem();
    }
}
