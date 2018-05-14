package ua.training.model.dao.impl;

import org.junit.Test;
import ua.training.model.dao.datasource.ConnectionPoolHolder;
import ua.training.model.dao.factory.DAOFactory;
import ua.training.model.dao.EmployeeDAO;
import ua.training.model.entity.Employee;
import ua.training.model.entity.enums.Role;
import ua.training.model.util.CryptoUtil;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JdbcEmployeeDAOImplTest {

    @Test
    public void addEmployeeAndGet() throws SQLException {
        String firstName = "Jack";
        String lastName = "Lee";
        String login = "jacklee";
        String password = CryptoUtil.hashPassword("123");
        Role role = Role.SENIOR_CASHIER;

        Employee employee = mock(Employee.class);
        when(employee.getFirstName()).thenReturn(firstName);
        when(employee.getLastName()).thenReturn(lastName);
        when(employee.getLogin()).thenReturn(login);
        when(employee.getPassword()).thenReturn(password);
        when(employee.getRole()).thenReturn(role);

        Connection connection = ConnectionPoolHolder.getDataSource().getConnection();
        try (EmployeeDAO employeeDAO = DAOFactory.getDaoFactory().getEmployeeDAO()) {
            connection.setAutoCommit(false);
            employeeDAO.add(employee);
            assertNotNull(employeeDAO.getByLogin(employee.getLogin()));
            connection.rollback();
        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback();
        }
    }

    @Test
    public void getByLogin() throws SQLException {
        Employee expectedEmployee = Employee.builder()
                .firstName("Jack")
                .lastName("Lee")
                .login("jacklee")
                .password(CryptoUtil.hashPassword("123"))
                .role(Role.SENIOR_CASHIER)
                .build();
        Connection connection = ConnectionPoolHolder.getDataSource().getConnection();
        try (EmployeeDAO employeeDAO = DAOFactory.getDaoFactory().getEmployeeDAO()) {
            connection.setAutoCommit(false);
            Employee actualEmployee = employeeDAO.getByLogin(expectedEmployee.getLogin());
            assertEquals(expectedEmployee, actualEmployee);
            connection.rollback();
        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback();
        }
    }
}