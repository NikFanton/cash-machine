package ua.training.controller.command;

import ua.training.controller.constant.Locations;

import javax.servlet.http.HttpServletRequest;

public class EmployeeRegistration implements Command {
    @Override
    public String execute(HttpServletRequest request) {
//        TODO make registration
        return Locations.REDIRECT + Locations.EMPLOYEE_REGISTRATION_FORM;
    }
}
