package ua.training.model.service.impl;

import ua.training.model.dao.EmployeeDAO;
import ua.training.model.dao.factory.DAOFactory;
import ua.training.model.dao.util.CryptoUtil;
import ua.training.model.entity.Employee;
import ua.training.model.service.Service;

public class EmployeeService implements Service {
    public boolean isEmployeeExist(String login, String pass) {
        Employee employee = getEmployee(login);
        return employee != null && CryptoUtil.checkPassword(pass, employee.getPassword());
    }

    public Employee getEmployee(String login) {
        try (EmployeeDAO dao = daoFactory.getEmployeeDAO()) {
            return dao.getByLogin(login);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Employee getEmployee(String login, String pass) {
        try (EmployeeDAO dao = daoFactory.getEmployeeDAO()) {
            return dao.getByLoginAndPassword(login, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
