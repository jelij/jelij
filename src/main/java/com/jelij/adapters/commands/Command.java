package com.jelij.adapters.commands;

import java.util.HashMap;

/**
 * Simple implementation for command. Each command should extends from that implementation.
 */
public abstract class Command implements CommandInterface {
    HashMap<String, Object> _params;
    static int _id = 0;

    /**
     * {@inheritDoc}
     */
    public HashMap<String, Object> params() {
        return _params;
    }

    /**
     * Generate unique placehoder.
     *
     * @return
     */
    protected String generateUniquePlaceholder() {
        String placeholder = "holder";

        // Append id.
        placeholder += String.valueOf(_id);

        // Increate placehoder ID.
        _id++;

        return placeholder;
    }

    /**
     * {@inheritDoc}
     */
    public void params(HashMap<String, Object> params) {
        _params = params;
    }

    /**
     * {@inheritDoc}
     */
    public void param(String name, Object value) {
        _params.put(name, value);
    }
}
