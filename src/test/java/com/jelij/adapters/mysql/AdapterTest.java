package com.jelij.adapters.mysql;

import com.jelij.TestCase;
import com.jelij.adapters.AdapterInterface;
import com.jelij.adapters.commands.sql.Select;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;

class AdapterTest extends TestCase {
    @Test
    void fetchByString() throws SQLException, ClassNotFoundException {
        AdapterInterface adapter = this.adapter("bookshop");

        ResultSet result = adapter.fetch("SELECT * FROM users ORDER BY id ASC LIMIT 1");

        result.next();

        assertEquals("1", result.getString("id"));
        assertEquals("Publicité", result.getString("firstName"));
        assertEquals("Terran", result.getString("lastName"));
        assertEquals("wterran0@imgur.com", result.getString("email"));
        assertEquals("257", result.getString("genderId"));
        assertEquals(null, result.getDate("birthDate"));
        assertEquals("39.32.246.221", result.getString("ip"));
        assertEquals("147", result.getString("countryId"));
        assertEquals("934", result.getString("cityId"));
        assertEquals("400-488-2327", result.getString("phone"));
    }

    @Test
    void fetchByStringWithPlaceholders() throws SQLException, ClassNotFoundException {
        AdapterInterface adapter = this.adapter("bookshop");

        ResultSet result = adapter.fetch("SELECT * FROM users where (id = :userId and firstName = :firstName) ORDER BY id ASC LIMIT 1", new HashMap<String, Object>(){{
            put("userId", "1");
            put("firstName", "Publicité");
        }});

        result.next();

        assertEquals("1", result.getString("id"));
        assertEquals("Publicité", result.getString("firstName"));
        assertEquals("Terran", result.getString("lastName"));
        assertEquals("wterran0@imgur.com", result.getString("email"));
        assertEquals("257", result.getString("genderId"));
        assertEquals(null, result.getDate("birthDate"));
        assertEquals("39.32.246.221", result.getString("ip"));
        assertEquals("147", result.getString("countryId"));
        assertEquals("934", result.getString("cityId"));
        assertEquals("400-488-2327", result.getString("phone"));
    }

    @Test
    void fetchBySelect() throws SQLException, ClassNotFoundException {
        AdapterInterface adapter = this.adapter("bookshop");

        Select select = new Select();

        select.from("users");
        select.sort(new String[]{"id asc"});
        select.limit(1);

        System.out.println(select.build().command());
        ResultSet result = adapter.fetch(select);

        result.next();

        assertEquals("1", result.getString("id"));
        assertEquals("Publicité", result.getString("firstName"));
        assertEquals("Terran", result.getString("lastName"));
        assertEquals("wterran0@imgur.com", result.getString("email"));
        assertEquals("257", result.getString("genderId"));
        assertEquals(null, result.getDate("birthDate"));
        assertEquals("39.32.246.221", result.getString("ip"));
        assertEquals("147", result.getString("countryId"));
        assertEquals("934", result.getString("cityId"));
        assertEquals("400-488-2327", result.getString("phone"));
    }
}