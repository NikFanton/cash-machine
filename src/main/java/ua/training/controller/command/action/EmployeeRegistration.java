package ua.training.controller.command.action;

import ua.training.controller.command.Command;
import ua.training.constant.AttributeAndParameterNames;
import ua.training.constant.Locations;
import ua.training.model.entity.Employee;
import ua.training.model.entity.enums.Role;
import ua.training.model.service.EmployeeService;

import javax.servlet.http.HttpServletRequest;

public class EmployeeRegistration implements Command {

    private EmployeeService employeeService;

    public EmployeeRegistration(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public String execute(HttpServletRequest request) {
            String firstName = request.getParameter(AttributeAndParameterNames.NEW_FIRST_NAME);
        String lastName = request.getParameter(AttributeAndParameterNames.NEW_LAST_NAME);
        String login = request.getParameter(AttributeAndParameterNames.NEW_LOGIN);
        String password = request.getParameter(AttributeAndParameterNames.NEW_PASSWORD);
        Role role = Role.valueOf(request.getParameter(AttributeAndParameterNames.NEW_ROLE));
        employeeService.registerEmployee(Employee.builder()
                .firstName(firstName)
                .lastName(lastName)
                .login(login)
                .password(password)
                .role(role)
                .build());
        return Locations.REDIRECT + Locations.EMPLOYEE_REGISTRATION_FORM;
    }
}
