package ua.training.controller.command.action;

import ua.training.controller.command.Command;
import ua.training.controller.constant.Locations;
import ua.training.controller.constant.Pages;
import ua.training.model.util.CryptoUtil;
import ua.training.model.entity.Employee;
import ua.training.model.exception.NoSuchResultFromDataBaseException;
import ua.training.model.service.EmployeeService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;

public class Login implements Command {

    private EmployeeService employeeService;

    public Login(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("pass");
        Employee employee;
        try {
            employee = employeeService.getEmployee(login);
        } catch (NoSuchResultFromDataBaseException e) {
            return Locations.REDIRECT + Locations.LOGIN_FORM;
        }

        if (CryptoUtil.checkPassword(password, employee.getPassword())) {
            request.getSession().getServletContext().setAttribute("login", login);
            request.getSession().getServletContext().setAttribute("role", employee.getRole());
            request.getSession().getServletContext().setAttribute("firstName", employee.getFirstName());
            request.getSession().getServletContext().setAttribute("lastName", employee.getLastName());
            return employee.getRole().getStartPage();
        } else {
            return Locations.REDIRECT + Locations.LOGIN_FORM;
        }
    }
}
