package ua.training.controller.command.action;

import ua.training.controller.command.Command;
import ua.training.controller.constant.Locations;
import ua.training.controller.constant.Pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogOut implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
//        System.out.println("login: [" + session.getAttribute("login") + "]");
        session.getServletContext().removeAttribute("login");
        session.getServletContext().removeAttribute("role");
        session.getServletContext().removeAttribute("firstName");
        session.getServletContext().removeAttribute("lastName");
        session.invalidate();
        return Locations.REDIRECT + Locations.LOGIN_FORM;
    }
}