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
    HashMap<String, Object> params();

    /**
     * Set list of params.
     *
     * @param params
     *
     * @return
     */
    void params(HashMap<String, Object> params);

    /**
     * Set param.
     *
     * @param name
     * @param value
     */
    void param(String name, Object value);
}
