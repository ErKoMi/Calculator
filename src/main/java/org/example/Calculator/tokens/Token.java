package org.example.Calculator.tokens;

public record Token<T extends Enum<T>> (T type, String value){
}