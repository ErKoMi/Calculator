package org.example.Calculator.numberSystems;

public class NumberSystems {
    public static final INumberSystem DECIMAL = new DecimalNumberSystem();
    public static final INumberSystem BINARY = new BinaryNumberSystem();
    public static final INumberSystem HEX = new HexNumberSystem();
    public static final INumberSystem OCT = new OctNumberSystem();

    public static INumberSystem fromString(String name) throws IllegalArgumentException{
        return switch (name){
            case "DEC" -> DECIMAL;
            case "OCT" -> OCT;
            case "BIN" -> BINARY;
            case "HEX" -> HEX;
            default -> throw new IllegalArgumentException("Неизвестная система счисления!");
        };
    }
}
