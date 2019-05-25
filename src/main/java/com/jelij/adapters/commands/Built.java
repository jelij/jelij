package com.jelij.adapters.commands;

import java.util.HashMap;

public class Built {
    private String _command = "";
    private HashMap<String, Object> _params = new HashMap<String, Object>();

    public Built() {

    }

    public Built(String command) {
        _command = command;
    }

    /**
     * Return command.
     *
     * @return
     */
    public String command() {
        if (_command.equals("")) {
            return null;
        } else {
            return _command;
        }
    }

    public String getCommand() {
        return _command;
    }

    public void setCommand(String command) {
        _command = command;
    }

    public void setParam(String name, Object value) {
        _params.put(name, value);
    }

    public void setParams(HashMap<String, Object> params) {
        _params.putAll(params);
    }

    public HashMap<String, Object> getParams() {
        return _params;
    }
}
