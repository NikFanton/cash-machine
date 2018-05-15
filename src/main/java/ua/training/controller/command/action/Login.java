package ua.training.controller.command.action;

import ua.training.controller.command.Command;
import ua.training.constant.AttributeAndParameterNames;
import ua.training.constant.Locations;
import ua.training.constant.Pages;
import ua.training.model.util.CryptoUtil;
import ua.training.model.entity.Employee;
import ua.training.model.exception.NoSuchResultFromDataBaseException;
import ua.training.model.service.EmployeeService;

import javax.servlet.http.HttpServletRequest;

public class Login implements Command {

    private EmployeeService employeeService;

    public Login(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter(AttributeAndParameterNames.LOGIN);
        String password = request.getParameter(AttributeAndParameterNames.PASSWORD);
        Employee employee;
        try {
            employee = employeeService.getEmployee(login);
        } catch (NoSuchResultFromDataBaseException e) {
            return Locations.REDIRECT + Locations.LOGIN_FORM;
        }
        if (CryptoUtil.checkPassword(password, employee.getPassword())) {
            request.getSession().getServletContext().setAttribute(AttributeAndParameterNames.LOGIN, login);
            request.getSession().getServletContext().setAttribute(AttributeAndParameterNames.ROLE, employee.getRole());
            request.getSession().getServletContext().setAttribute(AttributeAndParameterNames.FIRST_NAME, employee.getFirstName());
            request.getSession().getServletContext().setAttribute(AttributeAndParameterNames.LAST_NAME, employee.getLastName());
            return employee.getRole().getStartPage();
        } else {
            return Locations.REDIRECT + Locations.LOGIN_FORM;
        }
    }
}
