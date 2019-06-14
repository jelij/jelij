package com.jelij.adapters.commands;

import java.util.HashMap;

public class Built {
    private String _command = "";
    private HashMap<String, Object> _params = new HashMap<String, Object>();

    public Built() {}

    public Built(String command) {
        _command = command;
    }

    public Built(String command, HashMap<String, Object> params) {
        _command = command;
        _params = params;
    }

    public String getCommand() {
        if (_command == "") {
            return null;
        } else {
            return _command;
        }
    }

    public void setCommand(String command) {
        _command = command;
    }

    public void setParam(String name, Object value) {
        _params.put(name, value);
    }

    public void putParams(HashMap<String, Object> params) {
        _params.putAll(params);
    }

    public void setParams(HashMap<String, Object> params) {
        _params.clear();
        _params.putAll(params);
    }

    public HashMap<String, Object> getParams() {
        return _params;
    }
}
