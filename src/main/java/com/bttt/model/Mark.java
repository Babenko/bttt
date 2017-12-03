package com.bttt.model;

/**
 * @author Sem Babenko.
 */
public class Mark {

    private Symbol symbol;

    private Integer location;

    public Mark(Symbol symbol, Integer location) {
        this.symbol = symbol;
        this.location = location;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public enum Symbol {

        ZERO("o"),
        X("x");

        private String val;

        Symbol(String symbol) {
            val = symbol;
        }

        public static Symbol getEnum(String value) {
            if(value.equals("o") || value.equals("O") || value.equals("0")) {
                return Symbol.ZERO;
            } else if (value.equals("x") || value.equals("X")) {
                return Symbol.X;
            } else {
                throw new IllegalArgumentException("Wrong symbol");
            }
        }
    }

}
