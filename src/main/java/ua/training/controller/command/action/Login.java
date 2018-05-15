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
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;

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
        @SuppressWarnings("unchecked")
        Set<String> authorizedUsers = (Set<String>) request.getSession().getServletContext()
                .getAttribute(AttributeAndParameterNames.AUTHORIZED_USERS);
        boolean unauthorized = !authorizedUsers.contains(login);
        if (CryptoUtil.checkPassword(password, employee.getPassword()) && unauthorized) {
            System.out.println("IN");
            System.out.println("login = [" + login + "]");
            authorizedUsers.add(login);
            request.getServletContext().setAttribute(AttributeAndParameterNames.AUTHORIZED_USERS, authorizedUsers);
            request.getSession().setAttribute(AttributeAndParameterNames.LOGIN, login);
            request.getSession().setAttribute(AttributeAndParameterNames.ROLE, employee.getRole());
            request.getSession().setAttribute(AttributeAndParameterNames.FIRST_NAME, employee.getFirstName());
            request.getSession().setAttribute(AttributeAndParameterNames.LAST_NAME, employee.getLastName());
            System.out.println("loginAfter = [" + request.getSession().getAttribute(AttributeAndParameterNames.LOGIN)+ "]");
            return employee.getRole().getStartPage();
        } else {
            return Locations.REDIRECT + Locations.LOGIN_FORM;
        }
    }
}
