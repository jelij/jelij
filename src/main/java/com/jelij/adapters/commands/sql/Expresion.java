package com.jelij.adapters.commands.sql;

public class Expresion {

    private String _expresion;

    public Expresion(String expresion) {
        _expresion = expresion;
    }

    @Override
    public String toString() {
        return _expresion;
    }
}
