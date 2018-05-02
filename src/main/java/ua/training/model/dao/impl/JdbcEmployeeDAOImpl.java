package ua.training.model.dao.impl;

import ua.training.model.dao.UserDAO;
import ua.training.model.entity.Role;
import ua.training.model.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcUserDAOImpl implements UserDAO {
    private static final String SQL_REQUEST_GET_BY_ID = "SELECT * FROM user WHERE id = ";
    private static final String SQL_REQUEST_ADD = "INSERT INTO USER (LOGIN, PASSWORD, ROLE) VALUES (?, ?, ?)";
    private static final String SQL_REQUEST_GET_ALL = "SELECT * FROM USER";
    private static final String SQL_REQUEST_GET_BY_LOGIN = "SELECT * FROM USER WHERE USER.LOGIN = ?";
    private static final String SQL_REQUEST_GET_BY_LOGIN_AND_PASSWORD = "SELECT * FROM USER WHERE USER.LOGIN = ? AND USER.PASSWORD = ?";
    private static final String SQL_REQUEST_GET_ALL_LOGIN = "SELECT * FROM USER";

    @Override
    public void add(User user) {
        Connection connection;
        try {
            connection = JdbcDAOFactory.getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_REQUEST_ADD)) {
                preparedStatement.setString(1, user.getLogin());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.setString(3, user.getRole().getRoleName());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User getById(Long id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        Statement statement;
        Connection connection;
        try {
            connection = JdbcDAOFactory.getConnection();
            statement = connection.createStatement();
            try(ResultSet resultSet = statement.executeQuery(SQL_REQUEST_GET_ALL)) {
                while (resultSet.next()) {
                    users.add(extractUserFromResultSet(resultSet));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    private User extractUserFromResultSet(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong("id");
        String login = resultSet.getString("login");
        String password = resultSet.getString("password");
        String roleName = resultSet.getString("role");
        Role role = Role.valueOf(roleName);
        System.out.println(roleName);
        return new User(id, login, password, role);
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void close() throws Exception {
        JdbcDAOFactory.getConnection().close();
    }

    @Override
    public User getByLogin(String login) {
        try {
            Connection connection = JdbcDAOFactory.getConnection();
            try (PreparedStatement ps = connection.prepareStatement(SQL_REQUEST_GET_BY_LOGIN)) {
                ps.setString(1, login);
                try (ResultSet resultSet = ps.executeQuery()) {
                    if (resultSet.first()) {
                        return extractUserFromResultSet(resultSet);
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public User getByLoginAndPassword(String login, String password) {
        try {
            Connection connection = JdbcDAOFactory.getConnection();
            try (PreparedStatement ps = connection.prepareStatement(SQL_REQUEST_GET_BY_LOGIN_AND_PASSWORD)) {
                ps.setString(1, login);
                ps.setString(2, password);
                try (ResultSet resultSet = ps.executeQuery()) {
                    if (resultSet.first()) {
                        return extractUserFromResultSet(resultSet);
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<String> getAllLogin() {
        List<String> allLogin = new ArrayList<>();
        Connection connection;
        try {
            connection = JdbcDAOFactory.getConnection();
            Statement statement = connection.createStatement();
            try (ResultSet resultSet = statement.executeQuery(SQL_REQUEST_GET_ALL_LOGIN)) {
                while (resultSet.next()) {
                    allLogin.add(resultSet.getString("login"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allLogin;
    }
}
