package ua.training.model.dao.impl;

import ua.training.model.dao.factory.DAOFactory;
import ua.training.model.dao.EmployeeDAO;
import ua.training.model.dao.SQLQueries;
import ua.training.model.dao.mapper.EmployeeMapper;
import ua.training.model.entity.Employee;
import ua.training.model.entity.enums.Role;

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
            throw new RuntimeException(e);
        }
    }

    @Override
    public Employee getById(Long id) {
        return null;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> users = new ArrayList<>();
        try(ResultSet resultSet = connection.createStatement().executeQuery(SQLQueries.GET_ALL_EMPLOYEES)) {
            EmployeeMapper mapper = new EmployeeMapper();
            while (resultSet.next()) {
                users.add(mapper.extractFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
                if (resultSet.first()) {
                    EmployeeMapper mapper = new EmployeeMapper();
                    return mapper.extractFromResultSet(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static void main(String[] args) {
        EmployeeDAO dao = DAOFactory.getDaoFactory().getEmployeeDAO();
        Employee employee = new Employee("Jack", "Linden", "jlin", "abc123", Role.CASHIER);
//        dao.add(employee);
        dao.getAll().forEach(System.out::println);
        System.out.println(dao.getByLoginAndPassword("jlin", "abc123"));
    }
}
