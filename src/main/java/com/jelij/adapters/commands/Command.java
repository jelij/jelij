package com.jelij.adapters.commands;

import com.jelij.adapters.AdapterInterface;

import java.util.HashMap;

/**
 * Simple implementation for command. Each command should extends from that implementation.
 */
public abstract class Command implements CommandInterface {

    /**
     * Adapter associated with command.
     */
    AdapterInterface _adapter;

    /**
     * Params associated with command.
     */
    HashMap<String, Object> _params;

    /**
     * ID counter for generating unique id.
     */
    static int _id = 0;

    // Command() {};

    // /**
    //  * Contructor with adapter.
    //  *
    //  * @param adapter
    //  */
    // Command(AdapterInterface adapter) {
    //     _adapter = adapter;
    // }

    /**
     * {@inheritDoc}
     */
    public HashMap<String, Object> getParams() {
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
    public void setParams(HashMap<String, Object> params) {
        _params = params;
    }

    /**
     * {@inheritDoc}
     */
    public void setParam(String name, Object value) {
        _params.put(name, value);
    }

    // ResultSet fetch(Command command) throws Exception {
    //     if (this._adapter != null) {
    //         return this._adapter.fetch(this);
    //     } else {
    //         throw new Exception("There is no adapter set for command.");
    //     }
    // }
}
