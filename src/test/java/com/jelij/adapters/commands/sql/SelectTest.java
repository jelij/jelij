package com.jelij.adapters.commands.sql;

import com.jelij.TestCase;
import com.jelij.adapters.AdapterInterface;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SelectTest extends TestCase {

    @Test
    void equal() throws SQLException, ClassNotFoundException {
        AdapterInterface adapter = this.adapter("bookshop");

        Select select = new Select();

        select.from("users");
        select.equal("id", "1");

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

    @Test
    void notEqual() throws SQLException, ClassNotFoundException {
        AdapterInterface adapter = this.adapter("bookshop");

        Select select = new Select();

        select.from("users");
        select.notEqual("id", "1");
        select.sort(new String[]{"id asc"});

        System.out.println(select.build().command());
        ResultSet result = adapter.fetch(select);

        result.next();

        assertEquals("2", result.getString("id"));
        assertEquals("Alizée", result.getString("firstName"));
        assertEquals("Castrillo", result.getString("lastName"));
        assertEquals("wcastrillo1@t-online.de", result.getString("email"));
        assertEquals("257", result.getString("genderId"));
        assertEquals(null, result.getDate("birthDate"));
        assertEquals("231.188.163.37", result.getString("ip"));
        assertEquals("60", result.getString("countryId"));
        assertEquals("672", result.getString("cityId"));
        assertEquals("846-794-2164", result.getString("phone"));
    }

    @Test
    void in() throws SQLException, ClassNotFoundException {
        AdapterInterface adapter = this.adapter("bookshop");

        Select select = new Select();

        select.from("users");
        select.in("id", new String[]{"1"});

        ResultSet result = adapter.fetch(select);

        int count = this.count(result);

        result.next();

        assertEquals(1, count);
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
    void notIn() throws SQLException, ClassNotFoundException {
        AdapterInterface adapter = this.adapter("bookshop");

        Select select = new Select();

        select.from("users");
        select.notIn("id", new String[]{"1"});
        select.sort(new String[]{"id asc"});

        ResultSet result = adapter.fetch(select);

        int count = this.count(result);

        result.next();

        assertEquals(1999, count);
        assertEquals("2", result.getString("id"));
        assertEquals("Alizée", result.getString("firstName"));
        assertEquals("Castrillo", result.getString("lastName"));
        assertEquals("wcastrillo1@t-online.de", result.getString("email"));
        assertEquals("257", result.getString("genderId"));
        assertEquals(null, result.getDate("birthDate"));
        assertEquals("231.188.163.37", result.getString("ip"));
        assertEquals("60", result.getString("countryId"));
        assertEquals("672", result.getString("cityId"));
        assertEquals("846-794-2164", result.getString("phone"));
    }

    @Test
    void isNull() throws SQLException, ClassNotFoundException {
        AdapterInterface adapter = this.adapter("bookshop");

        Select select = new Select();

        select.from("users");
        select.isNull("countryId");

        ResultSet result = adapter.fetch(select);

        int count = this.count(result);

        result.next();

        assertEquals(153, count);
    }

    @Test
    void isNotNull() throws SQLException, ClassNotFoundException {
        AdapterInterface adapter = this.adapter("bookshop");

        Select select = new Select();

        select.from("users");
        select.isNotNull("countryId");

        ResultSet result = adapter.fetch(select);

        int count = this.count(result);

        result.next();

        assertEquals(1847, count);
    }

    @Test
    void startWith() throws SQLException, ClassNotFoundException {
        AdapterInterface adapter = this.adapter("bookshop");

        Select select = new Select();

        select.from("users");
        select.startWith("firstName", "L");

        ResultSet result = adapter.fetch(select);

        int count = this.count(result);

        result.next();

        assertEquals(157, count);
    }

    @Test
    void notStartWith() throws SQLException, ClassNotFoundException {
        AdapterInterface adapter = this.adapter("bookshop");

        Select select = new Select();

        select.from("users");
        select.notStartWith("firstName", "L");

        ResultSet result = adapter.fetch(select);

        int count = this.count(result);

        result.next();

        assertEquals(1843, count);
    }

    @Test
    void endWith() throws SQLException, ClassNotFoundException {
        AdapterInterface adapter = this.adapter("bookshop");

        Select select = new Select();

        select.from("users");
        select.endWith("firstName", "L");

        ResultSet result = adapter.fetch(select);

        int count = this.count(result);

        result.next();

        assertEquals(68, count);
    }

    @Test
    void notEndWith() throws SQLException, ClassNotFoundException {
        AdapterInterface adapter = this.adapter("bookshop");

        Select select = new Select();

        select.from("users");
        select.notEndWith("firstName", "L");

        ResultSet result = adapter.fetch(select);

        int count = this.count(result);

        result.next();

        assertEquals(1932, count);
    }

    @Test
    void contains() throws SQLException, ClassNotFoundException {
        AdapterInterface adapter = this.adapter("bookshop");

        Select select = new Select();

        select.from("users");
        select.contains("firstName", "ree");

        ResultSet result = adapter.fetch(select);

        int count = this.count(result);

        result.next();

        assertEquals(17, count);
    }

    @Test
    void notContains() throws SQLException, ClassNotFoundException {
        AdapterInterface adapter = this.adapter("bookshop");

        Select select = new Select();

        select.from("users");
        select.notContains("firstName", "L");

        ResultSet result = adapter.fetch(select);

        int count = this.count(result);

        result.next();

        assertEquals(1128, count);
    }

    @Test
    void like() throws SQLException, ClassNotFoundException {
        AdapterInterface adapter = this.adapter("bookshop");

        Select select = new Select();

        select.from("users");
        select.like("firstName", "%a%b%");

        ResultSet result = adapter.fetch(select);

        int count = this.count(result);

        result.next();

        assertEquals(37, count);
    }

    @Test
    void notLike() throws SQLException, ClassNotFoundException {
        AdapterInterface adapter = this.adapter("bookshop");

        Select select = new Select();

        select.from("users");
        select.notLike("firstName", "%a%b%");

        ResultSet result = adapter.fetch(select);

        int count = this.count(result);

        result.next();

        assertEquals(1963, count);
    }

    @Test
    void lowerThan() throws SQLException, ClassNotFoundException {
        AdapterInterface adapter = this.adapter("bookshop");

        Select select = new Select();

        select.from("users");
        select.lowerThan("countryId", "100");

        ResultSet result = adapter.fetch(select);

        int count = this.count(result);

        result.next();

        assertEquals(1156, count);
    }

    @Test
    void notLowerThan() throws SQLException, ClassNotFoundException {
        AdapterInterface adapter = this.adapter("bookshop");

        Select select = new Select();

        select.from("users");
        select.notLowerThan("countryId", "100");

        ResultSet result = adapter.fetch(select);

        int count = this.count(result);

        result.next();

        assertEquals(691, count);
    }

    @Test
    void lowerThanEqual() throws SQLException, ClassNotFoundException {
        AdapterInterface adapter = this.adapter("bookshop");

        Select select = new Select();

        select.from("users");
        select.lowerThanEqual("countryId", "100");

        ResultSet result = adapter.fetch(select);

        int count = this.count(result);

        result.next();

        assertEquals(1164, count);
    }

    @Test
    void notLowerThanEqual() throws SQLException, ClassNotFoundException {
        AdapterInterface adapter = this.adapter("bookshop");

        Select select = new Select();

        select.from("users");
        select.notLowerThanEqual("countryId", "100");

        ResultSet result = adapter.fetch(select);

        int count = this.count(result);

        result.next();

        assertEquals(683, count);
    }

    @Test
    void greaterThan() throws SQLException, ClassNotFoundException {
        AdapterInterface adapter = this.adapter("bookshop");

        Select select = new Select();

        select.from("users");
        select.greaterThan("countryId", "100");

        ResultSet result = adapter.fetch(select);

        int count = this.count(result);

        result.next();

        assertEquals(683, count);
    }

    @Test
    void notGreaterThan() throws SQLException, ClassNotFoundException {
        AdapterInterface adapter = this.adapter("bookshop");

        Select select = new Select();

        select.from("users");
        select.notGreaterThan("countryId", "100");

        ResultSet result = adapter.fetch(select);

        int count = this.count(result);

        result.next();

        assertEquals(1164, count);
    }

    @Test
    void greaterThanEqual() throws SQLException, ClassNotFoundException {
        AdapterInterface adapter = this.adapter("bookshop");

        Select select = new Select();

        select.from("users");
        select.greaterThanEqual("countryId", "100");

        ResultSet result = adapter.fetch(select);

        int count = this.count(result);

        result.next();

        assertEquals(691, count);
    }

    @Test
    void notGreaterThanEqual() throws SQLException, ClassNotFoundException {
        AdapterInterface adapter = this.adapter("bookshop");

        Select select = new Select();

        select.from("users");
        select.notGreaterThanEqual("countryId", "100");

        ResultSet result = adapter.fetch(select);

        int count = this.count(result);

        result.next();

        assertEquals(1156, count);
    }

    @Test
    void between() throws SQLException, ClassNotFoundException {
        AdapterInterface adapter = this.adapter("bookshop");

        Select select = new Select();

        select.from("users");
        select.between("countryId", "100", "200");

        ResultSet result = adapter.fetch(select);

        int count = this.count(result);

        result.next();

        assertEquals(691, count);
    }

    @Test
    void notBetween() throws SQLException, ClassNotFoundException {
        AdapterInterface adapter = this.adapter("bookshop");

        Select select = new Select();

        select.from("users");
        select.notBetween("countryId", "100", "200");

        ResultSet result = adapter.fetch(select);

        int count = this.count(result);

        result.next();

        assertEquals(1156, count);
    }

    @Test
    void exists() throws SQLException, ClassNotFoundException {
        AdapterInterface adapter = this.adapter("bookshop");

        Select select = new Select();

        select.from("users u");

        // Exists select
        Select exists = new Select();
        exists.from("users u2");
        exists.expresion(new Expresion("u2.id = u.id + 1"));

        select.exists(exists);

        ResultSet result = adapter.fetch(select);

        int count = this.count(result);

        result.next();

        assertEquals(1998, count);
    }

    @Test
    void notExists() throws SQLException, ClassNotFoundException {
        AdapterInterface adapter = this.adapter("bookshop");

        Select select = new Select();

        select.from("users u");

        // Exists select
        Select exists = new Select();
        exists.from("users u2");
        exists.expresion(new Expresion("u2.id = u.id + 1"));

        select.notExists(exists);

        ResultSet result = adapter.fetch(select);

        int count = this.count(result);

        result.next();

        assertEquals(2, count);
    }

    @Test
    void expresion() throws SQLException, ClassNotFoundException {
        AdapterInterface adapter = this.adapter("bookshop");

        Select select = new Select();

        select.from("users u");
        select.expresion(new Expresion("u.id = 1"));

        ResultSet result = adapter.fetch(select);

        int count = this.count(result);

        result.next();

        assertEquals(1, count);
    }

    @Test
    void leftJoin() throws SQLException, ClassNotFoundException {
        AdapterInterface adapter = this.adapter("bookshop");

        Select select = new Select();

        select.from("users u");
        select.column("u.id");

        // Join with countries
        select.leftJoin("countries c", "c.id = u.countryId");
        select.column("c.name", "country");
        select.equal("u.id", "1");

        ResultSet result = adapter.fetch(select);

        int count = this.count(result);

        result.next();

        assertEquals(1, count);
        assertEquals("1", result.getString("id"));
        assertEquals("Samoa", result.getString("country"));
    }
}