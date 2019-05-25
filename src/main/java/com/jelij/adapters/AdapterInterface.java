package com.jelij.adapters;

import com.jelij.adapters.commands.Command;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public interface AdapterInterface {
    // public function execute($command, $params = array());
    // public function fetch($command, array $params = array()) : \Tiie\Data\Adapters\Result;
    // public function lastId();

    // void execute(CommandInterface command);

    ResultSet fetch(Command command) throws SQLException;

    ResultSet fetch(String command) throws SQLException;

    /**
     * Execute command as string and returns result.
     *
     * @param command
     * @param params
     *
     * @return
     * @throws SQLException
     */
    ResultSet fetch(String command, HashMap<String, Object> params) throws SQLException;
}
