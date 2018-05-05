package ua.training.model.dao.factory;

import ua.training.model.dao.*;
import ua.training.model.dao.datasource.ConnectionPoolHolder;
import ua.training.model.dao.impl.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class MySqlDAOFactory extends DAOFactory {
    private DataSource dataSource = ConnectionPoolHolder.getDataSource();

    @Override
    public EmployeeDAO getEmployeeDAO() {
        return new MySqlEmployeeDAOImpl(getConnection());
    }

    @Override
    public ProductDAO getProductDAO() {
        return new MySqlProductDAOImpl(getConnection());
    }

    @Override
    public CheckManipulationDAO getCheckManipulationDAO() {
        return new MySqlCheckManipulationDAOImpl(getConnection());
    }

    @Override
    public CheckDAO getCheckDAO() {
        return new MySqlCheckDAOImpl(getConnection());
    }

    @Override
    public ReportDAO getReportDAO() {
        return new MySqlReportDAOImpl(getConnection());
    }

    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
