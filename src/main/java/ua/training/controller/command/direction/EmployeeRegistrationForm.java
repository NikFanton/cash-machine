package ua.training.controller.command.direction;

import ua.training.controller.command.Command;
import ua.training.constant.Pages;

import javax.servlet.http.HttpServletRequest;

public class EmployeeRegistrationForm implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return Pages.EMPLOYEE_REGISTRATION_FORM;
    }
}
