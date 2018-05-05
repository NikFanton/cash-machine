package ua.training.model.dao.impl;

import org.junit.Test;
import ua.training.model.dao.factory.DAOFactory;
import ua.training.model.dao.EmployeeDAO;

public class MySqlEmployeeDAOImplTest {
    private EmployeeDAO dao = DAOFactory.getDaoFactory().getEmployeeDAO();

    @Test
    public void add() {
    }

    @Test
    public void getById() {
    }

    @Test
    public void getAll() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void getByLoginAndPassword() {
//        Employee employee = Employee.builder()
//                .firstName("Jack")
//                .lastName("Linden")
//                .login("jlin")
//                .password("abc123")
//                .role(Role.CASHIER)
//                .build();
//        dao.add(employee);
//        Employee result = dao.getByLoginAndPassword(employee.getLogin(), employee.getPassword());
//        employee.setId(result.getId());
//        assertEquals(employee, result);
    }
}