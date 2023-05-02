package org.example.Calculator;

import org.example.Calculator.nodes.OperationNode;
import org.example.Calculator.numberSystems.NumberSystems;

public class Expression {
    OperationNode rootToken;

    public Expression(OperationNode token){
        rootToken = token;
    }

    public Result solve(){
        return new Result(rootToken.solve().getValue());
    }

    @Override
    public String toString(){
        return rootToken.toString();
    }

    public class Result{
        public final int result;
        public final String binaryString;
        public final String decimalString;
        public final String hexString;
        public final String octString;

        public int getResult() {
            return result;
        }

        public Result(int value){
            result = value;
            binaryString = NumberSystems.BINARY.toString(value);
            decimalString = NumberSystems.DECIMAL.toString(value);
            hexString = NumberSystems.HEX.toString(value);
            octString = NumberSystems.OCT.toString(value);
        }

        @Override
        public String toString() {
            return  "Binary:  " + binaryString + System.lineSeparator() +
                    "Decimal: " + decimalString + System.lineSeparator() +
                    "Hex:     " + hexString + System.lineSeparator() +
                    "Oct:     " + octString;
        }
    }
}
