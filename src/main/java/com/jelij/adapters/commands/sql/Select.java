package com.jelij.adapters.commands.sql;

import com.jelij.adapters.commands.Built;
import com.jelij.adapters.commands.Command;
import com.jelij.adapters.commands.CommandInterface;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Select extends Command implements WhereDelegatorInterface<Select> {
    public static final String JOIN_LEFT = "left";
    public static final String JOIN_RIGHT = "right";
    public static final String JOIN_INNER = "inner";

    private String _from;
    private Integer _limit;
    private Integer _offset;
    private String[] _sort;
    private ArrayList<HashMap<String, Object>> _columns = new ArrayList<>();

    private Where _where = new Where();
    private ArrayList<HashMap<String, Object>> _joins = new ArrayList<>();

    public Select from(String from) {
        _from = from;

        return this;
    }

    public Select column(String value) {
        HashMap<String, Object> column = new HashMap<>();

        column.put("value", value);
        column.put("alias", null);

        _columns.add(column);

        return this;
    }

    public Select column(String value, String alias) {
        HashMap<String, Object> column = new HashMap<>();

        column.put("value", value);
        column.put("alias", alias);

        _columns.add(column);

        return this;
    }

    /**
     * Set _limit at select statement.
     *
     * <pre>
     *     SELECT
     *         *
     *     FROM table
     *     LIMIT _limit
     * </pre>
     *
     * @param _limit
     */
    public Select limit(Integer limit) {
        this._limit = limit;
        this._offset = null;

        return this;
    }

    /**
     * Set _limit and offset at select statement.
     *
     * <pre>
     *     SELECT
     *         *
     *     FROM table
     *     LIMIT _limit OFFSET offset
     * </pre>
     *
     * @param limit
     * @param offest
     */
    public Select limit(Integer limit, Integer offest) {
        this._limit = limit;
        this._offset = offest;

        return this;
    }

    /**
     * Set offset at select statement.
     *
     * <pre>
     *     SELECT
     *         *
     *     FROM table
     *     LIMIT ... OFFSET offset
     * </pre>
     *
     * @param _offset
     */
    public Select offset(Integer _offset) {
        this._offset = _offset;

        return this;
    }

    public Select sort(String[] sort) {
        this._sort = sort;

        return this;
    }

    /**
     * {@inheritDoc}
     */
    public Built build() throws SQLException {
        Built built = new Built();

        String command = "SELECT";

        // Columns
        if (_columns.size() > 0) {
            for(HashMap<String, Object> column: _columns) {
                String value = null;
                String alias = (String) column.get("alias");

                if (column.get("value") instanceof String) {
                    value = (String) column.get("value");
                } else if (column.get("value") instanceof CommandInterface) {
                    Built valueBuilt = ((CommandInterface) column.get("value")).build();

                    value = "(" + valueBuilt.getCommand() + ")";

                    built.setParams(valueBuilt.getParams());
                }

                command += "\n" + value;

                if (alias != null) {
                    command += " as " + alias;
                }

                command += ",";
            }

            command = command.substring(0, command.length() -1);

        } else {
            command += "\n*";
        }

        // From
        command += "\nFROM " + this._from;

        // Join
        if (_joins.size() > 0) {
            for(HashMap<String, Object> join: _joins) {
                String type = (String) join.get("type");
                String with = null;
                String on = null;

                if (!type.equals(JOIN_LEFT) && !type.equals(JOIN_INNER) && !type.equals(JOIN_RIGHT)) {
                    throw new SQLException("Unsupported type of join '" + type + "'.");
                }

                if (join.get("with") instanceof String) {
                    with = (String) join.get("with");
                } else if (join.get("with") instanceof CommandInterface) {
                    Built withBuild = ((CommandInterface) join.get("with")).build();

                    with = "(" + withBuild.getCommand() + ")";

                    built.setParams(withBuild.getParams());
                }

                if (join.get("on") instanceof String) {
                    on = (String) join.get("on");
                } else if (join.get("on") instanceof CommandInterface) {
                    Built onBuild = ((CommandInterface) join.get("on")).build();

                    on = "(" + onBuild.getCommand() + ")";

                    built.setParams(onBuild.getParams());
                }

                command += "\n" + type + " join " + with + " on " + on;
            }
        }

        // Where
        Built whereBuild = _where.build();

        if (whereBuild.getCommand() != null) {
            command += "\nWHERE " + whereBuild.getCommand();

            // Move params

            built.setParams(whereBuild.getParams());
        }

        // Order
        if (this._sort != null) {
            if (this._sort.length > 0) {
                command += "\nORDER BY " + String.join(",", this._sort);
            }
        }

        // Limit, Offset
        if (this._limit != null) {
            if (this._offset != null) {
                command += "\nLIMIT " + this._limit + " OFFSET " + this._offset;
            } else {
                command += "\nLIMIT " + this._limit;
            }
        }

        built.setCommand(command);

        return built;
    }

    @Override
    public Select equal(String field, String value) {
        _where.equal(field, value);

        return this;
    }

    @Override
    public Select notEqual(String field, String value) {
        _where.notEqual(field, value);

        return this;
    }

    @Override
    public Select in(String field, String[] value) {
        _where.in(field, value);

        return this;
    }

    @Override
    public Select notIn(String field, String[] value) {
        _where.notIn(field, value);

        return this;
    }

    @Override
    public Select isNull(String field) {
        _where.isNull(field);

        return this;
    }

    @Override
    public Select isNotNull(String field) {
        _where.isNotNull(field);

        return this;
    }

    @Override
    public Select startWith(String field, String value) {
        _where.startWith(field, value);

        return this;
    }

    @Override
    public Select notStartWith(String field, String value) {
        _where.notStartWith(field, value);

        return this;
    }

    @Override
    public Select endWith(String field, String value) {
        _where.endWith(field, value);

        return this;
    }

    @Override
    public Select notEndWith(String field, String value) {
        _where.notEndWith(field, value);

        return this;
    }

    @Override
    public Select contains(String field, String value) {
        _where.contains(field, value);

        return this;
    }

    @Override
    public Select notContains(String field, String value) {
        _where.notContains(field, value);

        return this;
    }

    @Override
    public Select like(String field, String value) {
        _where.like(field, value);

        return this;
    }

    @Override
    public Select notLike(String field, String value) {
        _where.notLike(field, value);

        return this;
    }

    @Override
    public Select lowerThan(String field, String value) {
        _where.lowerThan(field, value);

        return this;
    }

    @Override
    public Select notLowerThan(String field, String value) {
        _where.notLowerThan(field, value);

        return this;
    }

    @Override
    public Select lowerThanEqual(String field, String value) {
        _where.lowerThanEqual(field, value);

        return this;
    }

    @Override
    public Select notLowerThanEqual(String field, String value) {
        _where.notLowerThanEqual(field, value);

        return this;
    }

    @Override
    public Select greaterThan(String field, String value) {
        _where.greaterThan(field, value);

        return this;
    }

    @Override
    public Select notGreaterThan(String field, String value) {
        _where.notGreaterThan(field, value);

        return this;
    }

    @Override
    public Select greaterThanEqual(String field, String value) {
        _where.greaterThanEqual(field, value);

        return this;
    }

    @Override
    public Select notGreaterThanEqual(String field, String value) {
        _where.notGreaterThanEqual(field, value);

        return this;
    }

    @Override
    public Select between(String field, String from, String to) {
        _where.between(field, from, to);

        return this;
    }

    @Override
    public Select notBetween(String field, String from, String to) {
        _where.notBetween(field, from, to);

        return this;
    }

    @Override
    public Select exists(CommandInterface value) {
        _where.exists(value);

        return this;
    }

    @Override
    public Select notExists(CommandInterface value) {
        _where.notExists(value);

        return this;
    }

    @Override
    public Select expresion(Expresion value) {
        _where.expresion(value);

        return this;
    }

    public Select leftJoin(String with, String on) {
        return join(JOIN_LEFT, with, on);
    }

    public Select innerJoin(String with, String on) {
        return join(JOIN_INNER, with, on);
    }

    public Select rightJoin(String with, String on) {
        return join(JOIN_RIGHT, with, on);
    }

    public Select join(String type, String with, String on) {
        HashMap<String, Object> join = new HashMap<>();

        join.put("type", type);
        join.put("with", with);
        join.put("on", on);

        _joins.add(join);

        return this;
    }

    // public function page($page, $pageSize = null)
    // public function group($group)
    // public function having($having)
    // public function order($order)
    // public function _sort($_sort)
    // // public function _sort($_sort = null)
    // public function columns(array $columns = null)
    // public function column($column, string $alias = null)
    // public function _from($table, $alias = null)
    // public function brackets($function)
    // public function and()
    // public function or()
    // public function conditions($column, $conditions, array $params = array())
    // public function params(array $values = array(), array $fields = array())
    // public function build(array $params = array()) : Built
    // public function buildOld(array $params = array()) : Built
    // public function count(array $params = array())
    // public function random()
    // public function fetch(array $params = array())
}
