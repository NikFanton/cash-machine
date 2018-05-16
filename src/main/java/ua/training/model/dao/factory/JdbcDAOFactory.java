package ua.training.model.dao.factory;

import ua.training.model.dao.*;
import ua.training.model.dao.datasource.ConnectionPoolHolder;
import ua.training.model.dao.impl.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JdbcDAOFactory extends DAOFactory {
    private static DataSource dataSource = ConnectionPoolHolder.getDataSource();

    @Override
    public EmployeeDAO getEmployeeDAO() {
        return new JdbcEmployeeDAOImpl(getConnection());
    }

    @Override
    public ProductDAO getProductDAO() {
        return new JdbcProductDAOImpl(getConnection());
    }

    @Override
    public CheckManipulationDAO getCheckManipulationDAO() {
        return new JdbcCheckManipulationDAOImpl(getConnection());
    }

    @Override
    public CheckDAO getCheckDAO() {
        return new JdbcCheckDAOImpl(getConnection());
    }

    @Override
    public ReportDAO getReportDAO() {
        return new JdbcReportDAOImpl(getConnection());
    }

    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            logger.error(e.getMessage() + " " + "can't close connection");
            throw new RuntimeException(e);
        }
    }
}
