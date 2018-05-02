package ua.training.model.service;

import ua.training.model.dao.DAOFactory;
import ua.training.model.dao.impl.JdbcDAOFactory;
import ua.training.model.entity.Employee;

import java.util.List;

public class UserService {
    private DAOFactory daoFactory = new JdbcDAOFactory();

    public boolean isEmployeeExist(String login, String pass) {
        return getEmployee(login, pass) != null;
    }

    public Employee getEmployee(String login, String pass) {
        return daoFactory.getEmployeeDAO().getByLoginAndPassword(login, pass);
    }

    public List<String> getAllLogin() {
        return daoFactory.getEmployeeDAO().getAllLogin();
    }

    public List<Employee> getAllUsers () {
        return daoFactory.getEmployeeDAO().getAll();
    }
}
