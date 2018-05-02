package ua.training.model.service;

import ua.training.model.dao.factory.DAOFactory;
import ua.training.model.dao.factory.JdbcDAOFactory;
import ua.training.model.entity.Employee;

public class EmployeeService {
    private DAOFactory daoFactory = new JdbcDAOFactory();

    public boolean isEmployeeExist(String login, String pass) {
        return getEmployee(login, pass) != null;
    }

    public Employee getEmployee(String login, String pass) {
        return daoFactory.getEmployeeDAO().getByLoginAndPassword(login, pass);
    }
}
