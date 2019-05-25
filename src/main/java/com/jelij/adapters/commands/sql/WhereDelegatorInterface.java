package com.jelij.adapters.commands.sql;

import com.jelij.adapters.commands.CommandInterface;

public interface WhereDelegatorInterface<T> {
    T equal(String field, String value);
    T notEqual(String field, String value);

    T in(String field, String[] value);
    T notIn(String field, String[] value);

    T isNull(String field);
    T isNotNull(String field);

    T startWith(String field, String value);
    T notStartWith(String field, String value);
    T endWith(String field, String value);
    T notEndWith(String field, String value);
    T contains(String field, String value);
    T notContains(String field, String value);
    T like(String field, String value);
    T notLike(String field, String value);

    T lowerThan(String field, String value);
    T notLowerThan(String field, String value);
    T lowerThanEqual(String field, String value);
    T notLowerThanEqual(String field, String value);
    T greaterThan(String field, String value);
    T notGreaterThan(String field, String value);
    T greaterThanEqual(String field, String value);
    T notGreaterThanEqual(String field, String value);

    T between(String field, String from, String to);
    T notBetween(String field, String from, String to);

    T exists(CommandInterface value);
    T notExists(CommandInterface value);
    T expresion(Expresion value);
}
