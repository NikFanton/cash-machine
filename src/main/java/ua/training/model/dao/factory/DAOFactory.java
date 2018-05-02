package ua.training.model.dao;

import ua.training.model.dao.impl.JdbcDAOFactory;

public abstract class DAOFactory  {
    private static volatile DAOFactory daoFactory = null;

    public abstract EmployeeDAO getEmployeeDAO();
    public abstract ProductDAO getProductDAO();

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
