package org.example;

import org.example.Calculator.tokens.OperationToken;

public class Expression {
    OperationToken rootToken;

    public Expression(OperationToken token){
        rootToken = token;
    }

    public double solve(){
        return rootToken.solve().getValue();
    }

    public void print(){
        rootToken.print();
        System.out.println();
    }
}
