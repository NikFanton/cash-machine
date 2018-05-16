package ua.training.model.service.impl;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.training.model.entity.Employee;
import ua.training.model.exception.NoSuchResultFromDataBaseException;
import ua.training.model.service.EmployeeService;
import ua.training.model.util.CryptoUtil;

import static org.junit.Assert.*;

public class EmployeeServiceImplTest {

    private EmployeeServiceImpl employeeService;

    @Before
    public void init() {
        employeeService = new EmployeeServiceImpl();
    }

    @Test
    public void getEmployeeByLogin() throws NoSuchResultFromDataBaseException {
        String login = "peter";
        Employee employee = employeeService.getEmployee(login);
        assertNotNull(employee);
        assertEquals(login, employee.getLogin());
    }

    @Test(expected = NoSuchResultFromDataBaseException.class)
    public void getEmployeeByLoginThrowsNoSuchResultFromDataBaseException() throws NoSuchResultFromDataBaseException {
        employeeService.getEmployee("only-for-test");
    }
}