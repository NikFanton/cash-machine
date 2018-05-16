package ua.training.model.dao.mapper;

import ua.training.model.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface UserMapper extends BaseMapper<Employee> {
    default Employee extractFromResultSetWithoutAccount(ResultSet resultSet) throws SQLException {
        return extractFromResultSetWithoutAccount(resultSet, "");
    }

    Employee extractFromResultSetWithoutAccount(ResultSet resultSet, String prefix) throws SQLException;
}
