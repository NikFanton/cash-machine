package ua.training.model.service.impl;

import ua.training.constant.LogMessages;
import ua.training.model.dao.EmployeeDAO;
import ua.training.model.entity.Employee;
import ua.training.model.exception.NoSuchResultFromDataBaseException;
import ua.training.model.service.EmployeeService;
import ua.training.model.util.CryptoUtil;

import java.util.Optional;

import static java.util.Objects.nonNull;

public class EmployeeServiceImpl implements EmployeeService {
    public boolean isEmployeeExist(String login, String pass) {
        Employee employee = null;
        try {
            employee = getEmployee(login);
        } catch (NoSuchResultFromDataBaseException e) {
            logger.error(e.getMessage() + " " + LogMessages.GET_EMPLOYEE_BY_LOGIN_AND_PASSWORD_ERROR);
        }
        return nonNull(employee) && CryptoUtil.checkPassword(pass, employee.getPassword());
    }

    public Employee getEmployee(String login) throws NoSuchResultFromDataBaseException {
        try (EmployeeDAO dao = daoFactory.getEmployeeDAO()) {
            return Optional.ofNullable(dao.getByLogin(login))
                    .orElseThrow(NoSuchResultFromDataBaseException::new);
        } catch (Exception e) {
            logger.error(e.getMessage() + " " + LogMessages.GET_EMPLOYEE_BY_LOGIN_ERROR + " " + login);
            throw new NoSuchResultFromDataBaseException();
        }
    }

    public void registerEmployee(Employee employee) {
        try (EmployeeDAO dao = daoFactory.getEmployeeDAO()) {
            employee.setPassword(CryptoUtil.hashPassword(employee.getPassword()));
            dao.add(employee);
        } catch (Exception e) {
            logger.error(e.getMessage() + " " + LogMessages.REGISTER_EMPLOYEE_ERROR);
            throw new RuntimeException();
        }
    }
}
