package ua.training.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogOut implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        System.out.println("LOGOUT");
        HttpSession session = request.getSession();
        session.removeAttribute("login");
        session.removeAttribute("pass");
        session.removeAttribute("role");
        return "redirect:/";
    }
}
