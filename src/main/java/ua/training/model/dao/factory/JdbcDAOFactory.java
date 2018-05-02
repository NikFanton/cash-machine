package ua.training.model.dao.factory;

import ua.training.model.dao.*;
import ua.training.model.dao.datasource.ConnectionPoolHolder;
import ua.training.model.dao.impl.*;
import ua.training.model.entity.CheckManipulation;

import javax.sql.DataSource;
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

    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
