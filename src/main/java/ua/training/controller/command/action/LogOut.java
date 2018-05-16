package ua.training.controller.command.action;

import ua.training.controller.annotation.CommandWithLocation;
import ua.training.controller.command.Command;
import ua.training.constant.Locations;

import javax.servlet.http.HttpServletRequest;

@CommandWithLocation(location = Locations.LOGOUT)
public class LogOut implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().invalidate();
        return Locations.REDIRECT + Locations.LOGIN_FORM;
    }
}