package ua.training.controller.command;

import ua.training.controller.constant.Pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogOut implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
//        System.out.println("login: [" + session.getAttribute("login") + "]");
        session.removeAttribute("login");
        session.removeAttribute("pass");
        session.removeAttribute("role");
        return Pages.REDIRECT;
    }
}