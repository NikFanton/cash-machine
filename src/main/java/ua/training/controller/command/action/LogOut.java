package ua.training.controller.command.action;

import ua.training.controller.command.Command;
import ua.training.constant.AttributeAndParameterNames;
import ua.training.constant.Locations;
import ua.training.constant.Pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogOut implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.getServletContext().removeAttribute(AttributeAndParameterNames.LOGIN);
        session.getServletContext().removeAttribute(AttributeAndParameterNames.ROLE);
        session.getServletContext().removeAttribute(AttributeAndParameterNames.FIRST_NAME);
        session.getServletContext().removeAttribute(AttributeAndParameterNames.LAST_NAME);
        session.invalidate();
        return Locations.REDIRECT + Locations.LOGIN_FORM;
    }
}