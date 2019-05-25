package com.jelij;

import com.jelij.adapters.AdapterInterface;
import com.jelij.adapters.mysql.Adapter;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestCase {

    protected AdapterInterface adapter(String name) throws SQLException, ClassNotFoundException {
        return new Adapter("localhost", "3306", "bookshop", "root", "");
    }

    protected int count(ResultSet res) {

        int totalRows = 0;

        try {
            res.last();
            totalRows = res.getRow();
            res.beforeFirst();
        } catch(Exception ex)  {
            return 0;
        }

        return totalRows;
    }
}