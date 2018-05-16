package ua.training.model.dao.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.model.dao.*;

/**
 * @see JdbcDAOFactory
 */
public abstract class DAOFactory  {
    public static final Logger logger = LogManager.getLogger(DAOFactory.class);
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
