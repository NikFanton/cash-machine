package ua.training.model.dao.mapper;

import ua.training.model.entity.Employee;
import ua.training.model.entity.enums.Role;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class EmployeeMapper implements BaseMapper<Employee> {
    @Override
    public Employee extractFromResultSet(ResultSet resultSet) throws SQLException {
        return extractFromResultSet(resultSet, "");
    }

    public Employee extractFromResultSetWithoutAccount(ResultSet resultSet) throws SQLException {
        return extractFromResultSetWithoutAccount(resultSet, "");
    }

    @Override
    public Employee extractFromResultSet(ResultSet resultSet, String prefix) throws SQLException {
        Employee employee = extractFromResultSetWithoutAccount(resultSet, prefix);
        String login = resultSet.getString(prefix + "login");
        String password = resultSet.getString(prefix + "password");
        employee.setLogin(login);
        employee.setPassword(password);
        return employee;
    }

    public Employee extractFromResultSetWithoutAccount(ResultSet resultSet, String prefix) throws SQLException {
        Long id = resultSet.getLong(prefix + "id");
        String firstName = resultSet.getString(prefix + "first_name");
        String lastName = resultSet.getString(prefix + "last_name");
        String roleName = resultSet.getString(prefix + "role");
        Role role = Role.valueOf(roleName);
        return new Employee(id, firstName, lastName, role);
    }

    @Override
    public Employee makeUnique(Map<Long, Employee> cache, Employee employee) {
        cache.putIfAbsent(employee.getId(), employee);
        return cache.get(employee.getId());
    }
}
