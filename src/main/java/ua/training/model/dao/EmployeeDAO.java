package ua.training.model.dao;

import ua.training.model.entity.Employee;

import java.util.List;

public interface EmployeeDAO extends GenericDAO<Employee, Long> {
    Employee getByLoginAndPassword(String login, String password);
}
