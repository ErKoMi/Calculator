package org.example;

import org.example.Calculator.tokens.OperationToken;

public class Expression {
    OperationToken rootToken;

    public void setRootToken(OperationToken rootToken) {
        this.rootToken = rootToken;
    }

    public double solve(){
        return rootToken.solve().getValue();
    }
}
