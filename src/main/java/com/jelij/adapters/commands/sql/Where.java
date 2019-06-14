package com.jelij.adapters.commands.sql;

import com.jelij.adapters.commands.Built;
import com.jelij.adapters.commands.Command;
import com.jelij.adapters.commands.CommandInterface;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Where extends Command {
    private static final String TYPE_EQUAL = "equal";
    private static final String TYPE_NOT_EQUAL = "notEqual";
    private static final String TYPE_IN = "in";
    private static final String TYPE_NOT_IN = "notIn";
    private static final String TYPE_IS_NULL = "isNull";
    private static final String TYPE_IS_NOT_NULL = "isNotNull";
    private static final String TYPE_START_WITH = "startWith";
    private static final String TYPE_NOT_START_WITH = "notStartWith";
    private static final String TYPE_END_WITH = "endWith";
    private static final String TYPE_NOT_END_WITH = "notEndWith";
    private static final String TYPE_CONTAINS = "contains";
    private static final String TYPE_NOT_CONTAINS = "notContains";
    private static final String TYPE_LIKE = "like";
    private static final String TYPE_NOT_LIKE = "notLike";
    private static final String TYPE_LOWER_THEN = "lowerThan";
    private static final String TYPE_NOT_LOWER_THEN = "notLowerThan";
    private static final String TYPE_LOWER_THEN_EQUAL = "lowerThanEqual";
    private static final String TYPE_NOT_LOWER_THEN_EQUAL = "notLowerThanEqual";
    private static final String TYPE_GREATER_THEN = "greaterThan";
    private static final String TYPE_NOT_GREATER_THEN = "notGreaterThan";
    private static final String TYPE_GREATER_THEN_EQUAL = "greaterThanEqual";
    private static final String TYPE_NOT_GREATER_THEN_EQUAL = "notGreaterThanEqual";
    private static final String TYPE_BETTWEEN = "between";
    private static final String TYPE_NOT_BETTWEEN = "notBetween";
    private static final String TYPE_EXISTS = "exists";
    private static final String TYPE_NOT_EXISTS = "notExists";
    private static final String TYPE_EXPRESION = "expresion";
    private static final Object TYPE_OR = "or";
    private static final Object TYPE_AND = "and";

    private static final String OPERATOR_AND = "AND";
    private static final String OPERATOR_OR = "OR";

    ArrayList<HashMap<String, Object>> _conditions = new ArrayList<>();

    public Where equal(String field, String value) {
        HashMap<String, Object> condition = new HashMap<>();

        condition.put("type", TYPE_EQUAL);
        condition.put("field", field);
        condition.put("value", value);
        condition.put("operator", OPERATOR_AND);

        _conditions.add(condition);

        return this;
    }

    public Where notEqual(String field, String value) {
        HashMap<String, Object> condition = new HashMap<>();

        condition.put("type", TYPE_NOT_EQUAL);
        condition.put("field", field);
        condition.put("value", value);
        condition.put("operator", OPERATOR_AND);

        _conditions.add(condition);

        return this;
    }

    public Where in(String field, String[] in) {
        HashMap<String, Object> condition = new HashMap<>();

        condition.put("type", TYPE_IN);
        condition.put("field", field);
        condition.put("value", in);
        condition.put("operator", OPERATOR_AND);

        _conditions.add(condition);

        return this;
    }

    public Where notIn(String field, String[] in) {
        HashMap<String, Object> condition = new HashMap<>();

        condition.put("type", TYPE_NOT_IN);
        condition.put("field", field);
        condition.put("value", in);
        condition.put("operator", OPERATOR_AND);

        _conditions.add(condition);

        return this;
    }

    public Where isNull(String field) {
        HashMap<String, Object> condition = new HashMap<>();

        condition.put("type", TYPE_IS_NULL);
        condition.put("field", field);
        condition.put("value", null);
        condition.put("operator", OPERATOR_AND);

        _conditions.add(condition);

        return this;
    }

    public Where isNotNull(String field) {
        HashMap<String, Object> condition = new HashMap<>();

        condition.put("type", TYPE_IS_NOT_NULL);
        condition.put("field", field);
        condition.put("value", null);
        condition.put("operator", OPERATOR_AND);

        _conditions.add(condition);

        return this;
    }

    public Where startWith(String field, String value) {
        HashMap<String, Object> condition = new HashMap<>();

        condition.put("type", TYPE_START_WITH);
        condition.put("field", field);
        condition.put("value", value);
        condition.put("operator", OPERATOR_AND);

        _conditions.add(condition);

        return this;
    }

    public Where notStartWith(String field, String value) {
        HashMap<String, Object> condition = new HashMap<>();

        condition.put("type", TYPE_NOT_START_WITH);
        condition.put("field", field);
        condition.put("value", value);
        condition.put("operator", OPERATOR_AND);

        _conditions.add(condition);

        return this;
    }

    public Where endWith(String field, String value) {
        HashMap<String, Object> condition = new HashMap<>();

        condition.put("type", TYPE_END_WITH);
        condition.put("field", field);
        condition.put("value", value);
        condition.put("operator", OPERATOR_AND);

        _conditions.add(condition);

        return this;
    }

    public Where notEndWith(String field, String value) {
        HashMap<String, Object> condition = new HashMap<>();

        condition.put("type", TYPE_NOT_END_WITH);
        condition.put("field", field);
        condition.put("value", value);
        condition.put("operator", OPERATOR_AND);

        _conditions.add(condition);

        return this;
    }

    public Where contains(String field, String value) {
        HashMap<String, Object> condition = new HashMap<>();

        condition.put("type", TYPE_CONTAINS);
        condition.put("field", field);
        condition.put("value", value);
        condition.put("operator", OPERATOR_AND);

        _conditions.add(condition);

        return this;
    }

    public Where notContains(String field, String value) {
        HashMap<String, Object> condition = new HashMap<>();

        condition.put("type", TYPE_NOT_CONTAINS);
        condition.put("field", field);
        condition.put("value", value);
        condition.put("operator", OPERATOR_AND);

        _conditions.add(condition);

        return this;
    }

    public Where like(String field, String value) {
        HashMap<String, Object> condition = new HashMap<>();

        condition.put("type", TYPE_LIKE);
        condition.put("field", field);
        condition.put("value", value);
        condition.put("operator", OPERATOR_AND);

        _conditions.add(condition);

        return this;
    }

    public Where notLike(String field, String value) {
        HashMap<String, Object> condition = new HashMap<>();

        condition.put("type", TYPE_NOT_LIKE);
        condition.put("field", field);
        condition.put("value", value);
        condition.put("operator", OPERATOR_AND);

        _conditions.add(condition);

        return this;
    }

    public Where lowerThan(String field, String value) {
        HashMap<String, Object> condition = new HashMap<>();

        condition.put("type", TYPE_LOWER_THEN);
        condition.put("field", field);
        condition.put("value", value);
        condition.put("operator", OPERATOR_AND);

        _conditions.add(condition);

        return this;
    }

    public Where notLowerThan(String field, String value) {
        HashMap<String, Object> condition = new HashMap<>();

        condition.put("type", TYPE_NOT_LOWER_THEN);
        condition.put("field", field);
        condition.put("value", value);
        condition.put("operator", OPERATOR_AND);

        _conditions.add(condition);

        return this;
    }

    public Where lowerThanEqual(String field, String value) {
        HashMap<String, Object> condition = new HashMap<>();

        condition.put("type", TYPE_LOWER_THEN_EQUAL);
        condition.put("field", field);
        condition.put("value", value);
        condition.put("operator", OPERATOR_AND);

        _conditions.add(condition);

        return this;
    }

    public Where notLowerThanEqual(String field, String value) {
        HashMap<String, Object> condition = new HashMap<>();

        condition.put("type", TYPE_NOT_LOWER_THEN_EQUAL);
        condition.put("field", field);
        condition.put("value", value);
        condition.put("operator", OPERATOR_AND);

        _conditions.add(condition);

        return this;
    }

    public Where greaterThan(String field, String value) {
        HashMap<String, Object> condition = new HashMap<>();

        condition.put("type", TYPE_GREATER_THEN);
        condition.put("field", field);
        condition.put("value", value);
        condition.put("operator", OPERATOR_AND);

        _conditions.add(condition);

        return this;
    }

    public Where notGreaterThan(String field, String value) {
        HashMap<String, Object> condition = new HashMap<>();

        condition.put("type", TYPE_NOT_GREATER_THEN);
        condition.put("field", field);
        condition.put("value", value);
        condition.put("operator", OPERATOR_AND);

        _conditions.add(condition);

        return this;
    }

    public Where greaterThanEqual(String field, String value) {
        HashMap<String, Object> condition = new HashMap<>();

        condition.put("type", TYPE_GREATER_THEN_EQUAL);
        condition.put("field", field);
        condition.put("value", value);
        condition.put("operator", OPERATOR_AND);

        _conditions.add(condition);

        return this;
    }

    public Where notGreaterThanEqual(String field, String value) {
        HashMap<String, Object> condition = new HashMap<>();

        condition.put("type", TYPE_NOT_GREATER_THEN_EQUAL);
        condition.put("field", field);
        condition.put("value", value);
        condition.put("operator", OPERATOR_AND);

        _conditions.add(condition);

        return this;
    }

    public Where between(String field, String from, String to) {
        HashMap<String, Object> condition = new HashMap<>();

        condition.put("type", TYPE_BETTWEEN);
        condition.put("field", field);
        condition.put("from", from);
        condition.put("to", to);
        condition.put("operator", OPERATOR_AND);

        _conditions.add(condition);

        return this;
    }

    public Where notBetween(String field, String from, String to) {
        HashMap<String, Object> condition = new HashMap<>();

        condition.put("type", TYPE_NOT_BETTWEEN);
        condition.put("field", field);
        condition.put("from", from);
        condition.put("to", to);
        condition.put("operator", OPERATOR_AND);

        _conditions.add(condition);

        return this;
    }

    public Where exists(CommandInterface value) {
        HashMap<String, Object> condition = new HashMap<>();

        condition.put("type", TYPE_EXISTS);
        condition.put("field", null);
        condition.put("value", value);
        condition.put("operator", OPERATOR_AND);

        _conditions.add(condition);

        return this;
    }

    public Where notExists(CommandInterface value) {
        HashMap<String, Object> condition = new HashMap<>();

        condition.put("type", TYPE_NOT_EXISTS);
        condition.put("field", null);
        condition.put("value", value);
        condition.put("operator", OPERATOR_AND);

        _conditions.add(condition);

        return this;
    }

    public Where expresion(Expresion value) {
        HashMap<String, Object> condition = new HashMap<>();

        condition.put("type", TYPE_EXPRESION);
        condition.put("field", null);
        condition.put("value", value);
        condition.put("operator", OPERATOR_AND);

        _conditions.add(condition);

        return this;
    }

    public Where or(Where[] value) {
        HashMap<String, Object> condition = new HashMap<>();

        condition.put("type", TYPE_OR);
        condition.put("field", null);
        condition.put("value", value);
        condition.put("operator", OPERATOR_AND);

        _conditions.add(condition);

        return this;
    }

    public Where and(Where[] value) {
        HashMap<String, Object> condition = new HashMap<>();

        condition.put("type", TYPE_AND);
        condition.put("field", null);
        condition.put("value", value);
        condition.put("operator", OPERATOR_AND);

        _conditions.add(condition);

        return this;
    }

    // public function expr($expr)
    // public function exists($value)
    // public function notExists($value)
    // public function between($column, $begin, $end)
    // public function notBetween($column, $begin, $end)

    // // public function join($with, $on, $type = self::JOIN_LEFT)
    // public function join(string $type,  $table, $on, string $alias = null)
    // public function limit(int $limit, int $offset = 0)
    // public function page($page, $pageSize = null)
    // public function group($group)

    @Override
    public Built build() throws SQLException {
        Built built = new Built();
        String command = "";
        Boolean first = true;

        for(HashMap<String, Object> condition : _conditions) {
            String type = (String) condition.get("type");
            String operator = (String) condition.get("operator");
            String field = "";
            String value = "";
            String from = "";
            String to = "";
            // String valuePlaceholder = null;

            if (first) {
                operator = "";
            }


            if (condition.get("field") instanceof String) {
                field = (String) condition.get("field");
            } else if (condition.get("field") instanceof CommandInterface) {

            }

            if (condition.get("value") instanceof String) {
                value = (String) condition.get("value");

                if (type.equals(TYPE_START_WITH) || type.equals(TYPE_NOT_START_WITH)) {
                    value = value + "%";
                } else if (type.equals(TYPE_END_WITH) || type.equals(TYPE_NOT_END_WITH)) {
                    value = "%" + value;
                } else if (type.equals(TYPE_CONTAINS) || type.equals(TYPE_NOT_CONTAINS)) {
                    value = "%" + value + "%";
                }

                // Generate uniquehoder
                String holder = generateUniquePlaceholder();

                // Set param.
                built.setParam(holder, value);

                // Set value as :holder...
                value = ":" + holder;
            } else if (condition.get("value") instanceof Expresion) {
                value = "(" + condition.get("value").toString() + ")";
            } else if (condition.get("value") instanceof CommandInterface) {
                Built valueBuilt = ((CommandInterface) condition.get("value")).build();

                value = valueBuilt.getCommand();

                built.putParams(valueBuilt.getParams());
            } else if (condition.get("value") instanceof Where[]) {
                String t = "";
                String o = null;

                if (type == TYPE_OR) {
                    o = "or";
                } else {
                    o = "and";
                }

                for(Where where: (Where[]) condition.get("value")) {
                    Built whereBuilt = where.build();

                    t += "(" + whereBuilt.getCommand() + ") " + o + " ";

                    built.putParams(whereBuilt.getParams());
                }

                t = t.substring(0, t.length() - o.length() - 2);


                value = t;
            } else if (condition.get("value") instanceof String[]) {
                for(String v: (String[]) condition.get("value")) {
                    String placeholder = generateUniquePlaceholder();

                    value += ":" + placeholder + ",";

                    built.setParam(placeholder, v);
                }

                if (value.length() > 0) {
                    value = value.substring(0, value.length() - 1);
                }
            }

            if (type.equals(TYPE_BETTWEEN) || type.equals(TYPE_NOT_BETTWEEN)) {
                from = (String) condition.get("from");
                to = (String) condition.get("to");
            }

            if (type.equals(TYPE_EQUAL)) {
                command += operator + "(" + field + " = " + value + ")";
            } else if (type.equals(TYPE_NOT_EQUAL)) {
                command += operator + "(" + field + " != " + value + ")";
            } else if (type.equals(TYPE_IN)) {
                command += operator + "(" + field + " in (" + value + "))";
            } else if (type.equals(TYPE_NOT_IN)) {
                command += operator + "(" + field + " not in (" + value + "))";

            } else if (type.equals(TYPE_IS_NULL)) {
                command += operator + "(" + field + " is null)";
            } else if (type.equals(TYPE_IS_NOT_NULL)) {
                command += operator + "(" + field + " is not null)";
            } else if (type.equals(TYPE_START_WITH) || type.equals(TYPE_END_WITH) || type.equals(TYPE_CONTAINS)) {
                command += operator + "(" + field + " like " + value + ")";
            } else if (type.equals(TYPE_NOT_START_WITH) || type.equals(TYPE_NOT_END_WITH) || type.equals(TYPE_NOT_CONTAINS)) {
                command += operator + "(" + field + " not like " + value + ")";
            } else if (type.equals(TYPE_LIKE)) {
                command += operator + "(" + field + " like " + value + ")";
            } else if (type.equals(TYPE_NOT_LIKE)) {
                command += operator + "(" + field + " not like " + value + ")";
            } else if (type.equals(TYPE_LOWER_THEN)) {
                command += operator + "(" + field + " < " + value + ")";
            } else if (type.equals(TYPE_NOT_LOWER_THEN)) {
                command += operator + "(" + field + " >= " + value + ")";
            } else if (type.equals(TYPE_LOWER_THEN_EQUAL)) {
                command += operator + "(" + field + " <= " + value + ")";
            } else if (type.equals(TYPE_NOT_LOWER_THEN_EQUAL)) {
                command += operator + "(" + field + " > " + value + ")";
            } else if (type.equals(TYPE_GREATER_THEN)) {
                command += operator + "(" + field + " > " + value + ")";
            } else if (type.equals(TYPE_NOT_GREATER_THEN)) {
                command += operator + "(" + field + " <= " + value + ")";
            } else if (type.equals(TYPE_GREATER_THEN_EQUAL)) {
                command += operator + "(" + field + " >= " + value + ")";
            } else if (type.equals(TYPE_NOT_GREATER_THEN_EQUAL)) {
                command += operator + "(" + field + " < " + value + ")";
            } else if (type.equals(TYPE_BETTWEEN)) {
                command += operator + "(" + field + " between " + from + " and " + to + ")";
            } else if (type.equals(TYPE_NOT_BETTWEEN)) {
                command += operator + "(" + field + " not between " + from + " and " + to + ")";
            } else if (type.equals(TYPE_EXISTS)) {
                command += operator + "(" + field + " exists (" + value + "))";
            } else if (type.equals(TYPE_NOT_EXISTS)) {
                command += operator + "(" + field + " not exists (" + value + "))";
            } else if (type.equals(TYPE_EXPRESION)) {
                command += operator + "(" + value + ")";
            } else if (type.equals(TYPE_OR) || type.equals(TYPE_AND)) {
                command += operator + "(" + value + ")";
            }
        }

        built.setCommand(command);


        return built;
    }
}
