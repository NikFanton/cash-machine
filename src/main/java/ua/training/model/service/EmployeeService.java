package ua.training.model.service;

import ua.training.model.dao.EmployeeDAO;
import ua.training.model.dao.util.CryptoUtil;
import ua.training.model.entity.Employee;

public interface EmployeeService extends Service {
    boolean isEmployeeExist(String login, String pass);

    Employee getEmployee(String login);

    Employee getEmployee(String login, String pass);
}
