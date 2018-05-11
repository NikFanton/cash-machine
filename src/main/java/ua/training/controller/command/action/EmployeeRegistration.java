package ua.training.controller.command.action;

import ua.training.controller.command.Command;
import ua.training.controller.constant.Locations;
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
            String firstName = request.getParameter("newFirstName");
        String lastName = request.getParameter("newLastName");
        String login = request.getParameter("newLogin");
        String password = request.getParameter("newPassword");
        Role role = Role.valueOf(request.getParameter("newRole"));
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
