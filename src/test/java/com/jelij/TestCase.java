package com.jelij;

import com.jelij.adapters.AdapterInterface;
import com.jelij.adapters.mysql.Adapter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class TestCase {

    protected AdapterInterface adapter(String name) throws SQLException, ClassNotFoundException {
        Adapter adapter = new Adapter("localhost", "3306", "bookshop", "root", "", new HashMap<String, Object>() {{
            put("zeroDateTimeBehavior", "convertToNull");
            put("noDatetimeStringSync", true);
        }});

        return adapter;
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