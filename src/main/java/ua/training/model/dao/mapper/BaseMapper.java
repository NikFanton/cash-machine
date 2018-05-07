package ua.training.model.dao.mapper;

import ua.training.model.entity.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public interface BaseMapper<T extends Entity<Long>> {
    default T extractFromResultSet(ResultSet resultSet) throws SQLException {
        return extractFromResultSet(resultSet, "");
    }

    T extractFromResultSet(ResultSet resultSet, String prefix) throws SQLException;

    default T makeUnique(Map<Long, T> cache, T t) {
        cache.putIfAbsent(t.getId(), t);
        return cache.get(t.getId());
    }
}
