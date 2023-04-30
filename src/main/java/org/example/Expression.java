package org.example;

import org.example.Calculator.operations.OperationNode;

public class Expression {
    OperationNode rootToken;

    public Expression(OperationNode token){
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
