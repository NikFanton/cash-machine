package ua.training.model.dao.factory;

import ua.training.model.dao.*;

public abstract class DAOFactory  {
    private static volatile DAOFactory daoFactory = null;

    public abstract EmployeeDAO getEmployeeDAO();
    public abstract ProductDAO getProductDAO();
    public abstract CheckManipulationDAO getCheckManipulationDAO();
    public abstract CheckDAO getCheckDAO();
    public abstract ReportDAO getReportDAO();

    public static DAOFactory getDaoFactory() {
        if (daoFactory == null) {
            synchronized (DAOFactory.class) {
                if (daoFactory == null) {
                    daoFactory = new JdbcDAOFactory();
                }
            }
        }
        return daoFactory;
    }
}
