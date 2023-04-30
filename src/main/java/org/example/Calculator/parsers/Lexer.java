package org.example.Calculator.parsers;

import org.example.Calculator.tokens.ITokenType;
import org.example.Calculator.tokens.Token;

import java.util.ArrayList;
import java.util.regex.Matcher;

public class Lexer  {
    public static <T extends Enum<T> & ITokenType>  ArrayList<Token<T>> processingString(Class<T> tClass, String str){
        ArrayList<Token<T>> tokens = new ArrayList<>();

        String exprString = str;
        while(exprString.length() > 0){
            int count = tokens.size();
            for (ITokenType type: tClass.getEnumConstants()){
                Matcher matcher = type.getPattern().matcher(exprString);
                if(matcher.find()){
                    int end = matcher.group().length();
                    tokens.add(new Token<T>(tClass.cast(type), exprString.substring(0, end)));
                    exprString = exprString.substring(end);
                    break;
                }
            }

            if(count == tokens.size()){
                throw new IllegalArgumentException(String.format("Unresolved symbol \"%c\"", exprString.charAt(0)));
            }
        }

        return tokens;
    }
}
