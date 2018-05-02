package ua.training.model.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public interface BaseMapper<T> {
    default T extractFromResultSet(ResultSet resultSet) throws SQLException {
        return extractFromResultSet(resultSet, "");
    };
    T extractFromResultSet(ResultSet resultSet, String prefix) throws SQLException;

    default T makeUnique(Map<Long, T> cache, T t) {
        return null;
    }
}
