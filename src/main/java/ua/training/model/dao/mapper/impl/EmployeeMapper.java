package ua.training.model.dao.mapper.impl;

import ua.training.constant.database.EmployeeFieldsNames;
import ua.training.model.dao.mapper.UserMapper;
import ua.training.model.entity.Employee;
import ua.training.model.entity.enums.Role;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements UserMapper {
    @Override
    public Employee extractFromResultSet(ResultSet resultSet, String prefix) throws SQLException {
        Employee employee = extractFromResultSetWithoutAccount(resultSet, prefix);
        String login = resultSet.getString(prefix + EmployeeFieldsNames.LOGIN);
        String password = resultSet.getString(prefix + EmployeeFieldsNames.PASSWORD);
        employee.setLogin(login);
        employee.setPassword(password);
        return employee;
    }

    @Override
    public Employee extractFromResultSetWithoutAccount(ResultSet resultSet, String prefix) throws SQLException {
        Long id = resultSet.getLong(prefix + EmployeeFieldsNames.ID);
        String firstName = resultSet.getString(prefix + EmployeeFieldsNames.FIRST_NAME);
        String lastName = resultSet.getString(prefix + EmployeeFieldsNames.LAST_NAME);
        String roleName = resultSet.getString(prefix + EmployeeFieldsNames.ROLE);
        Role role = Role.valueOf(roleName);
        return new Employee(id, firstName, lastName, role);
    }
}
