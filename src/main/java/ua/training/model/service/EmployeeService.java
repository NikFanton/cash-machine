package ua.training.model.service;

import ua.training.model.dao.util.CryptoUtil;
import ua.training.model.entity.Employee;

public class EmployeeService implements Service {
    public boolean isEmployeeExist(String login, String pass) {
        Employee employee = getEmployee(login);
        return employee != null && CryptoUtil.checkPassword(pass, employee.getPassword());
    }

    public Employee getEmployee(String login) {
        return daoFactory.getEmployeeDAO().getByLogin(login);
    }

    public Employee getEmployee(String login, String pass) {
        return daoFactory.getEmployeeDAO().getByLoginAndPassword(login, pass);
    }
}
