package ua.training.model.dao.impl;

import ua.training.model.dao.DAOFactory;
import ua.training.model.dao.EmployeeDAO;
import ua.training.model.dao.ProductDAO;
import ua.training.model.util.ConnectionUtil;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.SQLException;

public class JdbcDAOFactory extends DAOFactory {
    private DataSource dataSource = ConnectionPoolHolder.getDataSource();

    @Override
    public EmployeeDAO getEmployeeDAO() {
        return new JdbcEmployeeDAOImpl(getConnection());
    }

    @Override
    public ProductDAO getProductDAO() {
        return new JdbcProductDAOImpl(getConnection());
    }

    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
