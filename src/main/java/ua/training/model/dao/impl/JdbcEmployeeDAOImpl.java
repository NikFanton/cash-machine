package ua.training.model.dao.impl;

import ua.training.constant.LogMessages;
import ua.training.model.dao.EmployeeDAO;
import ua.training.model.dao.SQLQueries;
import ua.training.model.dao.mapper.impl.EmployeeMapper;
import ua.training.model.entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcEmployeeDAOImpl implements EmployeeDAO {
    private Connection connection;

    public JdbcEmployeeDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(Employee employee) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.ADD_EMPLOYEE)) {
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getLogin());
            preparedStatement.setString(4, employee.getPassword());
            preparedStatement.setString(5, employee.getRole().name());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage() + " " + LogMessages.CREATE_EMPLOYEE_ERROR);
            throw new RuntimeException();
        }
    }

    @Override
    public Employee getById(Long id) {
        return null;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> users = new ArrayList<>();
        try(Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQLQueries.GET_ALL_EMPLOYEES)) {
            EmployeeMapper mapper = new EmployeeMapper();
            while (resultSet.next()) {
                users.add(mapper.extractFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            logger.error(e.getMessage() + " " + LogMessages.GET_ALL_EMPLOYEES_ERROR);
            throw new RuntimeException();
        }
        return users;
    }

    @Override
    public void update(Employee employee) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void close() throws Exception {
        connection.close();
    }

    @Override
    public Employee getByLoginAndPassword(String login, String password) {
        try (PreparedStatement ps = connection.prepareStatement(SQLQueries.GET_EMPLOYEE_BY_LOGIN_AND_PASSWORD)) {
            ps.setString(1, login);
            ps.setString(2, password);
            try (ResultSet resultSet = ps.executeQuery()) {
                return extractEmployeeFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage() + " " + LogMessages.GET_EMPLOYEE_BY_LOGIN_AND_PASSWORD_ERROR);
            throw new RuntimeException();
        }
    }

    @Override
    public Employee getByLogin(String login) {
        try (PreparedStatement ps = connection.prepareStatement(SQLQueries.GET_EMPLOYEE_BY_LOGIN)) {
            ps.setString(1, login);
            try (ResultSet resultSet = ps.executeQuery()) {
                return extractEmployeeFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage() + " " + LogMessages.GET_EMPLOYEE_BY_LOGIN_ERROR);
            throw new RuntimeException();
        }
    }

    private Employee extractEmployeeFromResultSet(ResultSet resultSet) throws SQLException {
        Employee employee = null;
        if (resultSet.first()) {
            EmployeeMapper mapper = new EmployeeMapper();
            employee = mapper.extractFromResultSet(resultSet);
        }
        return employee;
    }
}
