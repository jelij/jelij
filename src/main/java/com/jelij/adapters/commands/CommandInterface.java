package com.jelij.adapters.commands;

import java.sql.SQLException;
import java.util.HashMap;

public interface CommandInterface {
    /**
     * Creates a prepared command to perform.
     *
     * @return
     */
    Built build() throws SQLException;

    /**
     * Return list of params assigned to command.
     *
     * @return
     */
    HashMap<String, Object> getParams();

    /**
     * Set list of params.
     *
     * @param params
     *
     * @return
     */
    void setParams(HashMap<String, Object> params);

    /**
     * Set value of param at command.
     *
     * @param name
     * @param value
     */
    void setParam(String name, Object value);
}
