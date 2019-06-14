package com.jelij.adapters.commands.sql;

import com.jelij.adapters.commands.Built;
import com.jelij.adapters.commands.Command;

import java.sql.SQLException;

public class Expresion extends Command {

    private String _expresion;

    public Expresion(String expresion) {
        _expresion = expresion;
    }

    @Override
    public String toString() {
        return _expresion;
    }

    @Override
    public Built build() throws SQLException {
        return new Built(_expresion);
    }
}
