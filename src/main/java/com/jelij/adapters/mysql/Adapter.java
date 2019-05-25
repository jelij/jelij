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
    private String host;
    private String port;
    private String dbname;
    private String username;
    private String password;
    private Connection connection;

    public Adapter(
            String host,
            String port,
            String dbname,
            String username,
            String password
    ) throws SQLException, ClassNotFoundException {
        this.host = host;
        this.port = port;
        this.dbname = dbname;
        this.username = username;
        this.password = password;

        // Class.forName("com.mysql.jdbc.Driver");

        // System.out.println("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.dbname + "?zeroDateTimeBehavior=convertToNull");
        connection = DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.dbname + "?zeroDateTimeBehavior=convertToNull&noDatetimeStringSync=true", this.username, this.password);
        // useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC

        // here sonoo is database name, root is username and password

        // Statement stmt=con.createStatement();

        connection.createStatement().execute("SET sql_mode = 'NO_ZERO_DATE'");
    }

    public ResultSet fetch(Command command) throws SQLException {
        if (command instanceof Select) {
            Built built = ((Select) command).build();

            System.out.println(String.valueOf(built.getParams()));

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

        System.out.println(command);
        System.out.println("------------------");

        while(match.find()) {
            String name = match.group(2);

            System.out.println(name);
            System.out.println("------------------");

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

        System.out.println("Przed wykonanie");
        System.out.println(command);
        System.out.println(String.valueOf(placehoders));
        System.out.println("-----------------------");

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
