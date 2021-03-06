package com.jelij.adapters.mysql;

import com.jelij.adapters.commands.Built;
import com.jelij.adapters.commands.Command;
import com.jelij.adapters.commands.sql.Select;
import com.mysql.cj.jdbc.SuspendableXAConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Adapter extends com.jelij.adapters.Adapter {
    private final String _host;
    private final String _port;
    private final String _dbname;
    private final String _username;
    private final String _password;
    private final HashMap<String, Object> _params;

    private Connection connection;

    public Adapter(
            String host,
            String port,
            String dbname,
            String username,
            String password,
            HashMap<String, Object> params
    ) throws SQLException, ClassNotFoundException {
        _host = host;
        _port = port;
        _dbname = dbname;
        _username = username;
        _password = password;
        _params = params;

        // Params imploded
        String p = "";

        for(String key: params.keySet()) {
            p += key + "=" + params.get(key) + "&";
        }

        if (p.length() > 0) {
            p = p.substring(0, p.length() - 1);
            p = "?" + p;
        }

        connection = DriverManager.getConnection("jdbc:mysql://" + _host + ":" + _port + "/" + _dbname + p, _username, _password);

        connection.createStatement().execute("SET sql_mode = 'NO_ZERO_DATE'");
    }

    public ResultSet fetch(Command command) throws SQLException {
        if (command instanceof Select) {
            Built built = ((Select) command).build();


            return this.fetch(built.getCommand(), built.getParams());
        }

        return null;
    }

    public ResultSet fetch(String command) throws SQLException {
        return fetch(command, new HashMap<>());
    }

    public ResultSet fetch(String command, HashMap<String, Object> params) throws SQLException {
        // Params and placesholer.
        Pattern pattern = Pattern.compile("(:(\\w*))");
        Matcher match = pattern.matcher(command);

        ArrayList<String> placehoders = new ArrayList<>();

        System.out.println("command");
        System.out.println(command);

        while(match.find()) {
            String name = match.group(2);

            if (params.containsKey(name)) {
                // Params is defined
                String value = (String) params.get(name);

                // Reaplce holder to question mark.
                command = command.replace(match.group(1), "?");

                // Put to list of hollders.
                placehoders.add(value);
            } else {
                throw new SQLException("Param " + name + " is not defined.");
            }
        }


        // Prepare statement.
        PreparedStatement statement = connection.prepareStatement(command);

        // Put value for questions marks.
        int key = 0;

        for(String value : placehoders) {
            key++;

            statement.setString(key, value);
        }

        return statement.executeQuery();
    }
}
