package ua.training.model.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public interface GenericMapper<T> {
    T extractFromResultSet(ResultSet resultSet) throws SQLException;
    T makeUnique(Map<Long, T> cache, T t);
}
