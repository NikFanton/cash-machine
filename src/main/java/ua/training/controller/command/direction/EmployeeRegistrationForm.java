package ua.training.controller.command.direction;

import ua.training.constant.Locations;
import ua.training.controller.annotation.CommandWithLocation;
import ua.training.controller.command.Command;
import ua.training.constant.Pages;

import javax.servlet.http.HttpServletRequest;

@CommandWithLocation(location = Locations.EMPLOYEE_REGISTRATION_FORM)
public class EmployeeRegistrationForm implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return Pages.EMPLOYEE_REGISTRATION_FORM;
    }
}
