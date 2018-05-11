package ua.training.model.service;

import ua.training.model.entity.Employee;
import ua.training.model.exception.NoSuchResultFromDataBaseException;

public interface EmployeeService extends Service {
    boolean isEmployeeExist(String login, String pass);

    Employee getEmployee(String login) throws NoSuchResultFromDataBaseException;

    Employee getEmployee(String login, String pass) throws NoSuchResultFromDataBaseException;

    void registerEmployee(Employee employee);
}
