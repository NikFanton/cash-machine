package ua.training.controller.listener;

import ua.training.controller.constant.Pages;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent session) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent session) {
        session.getSession().getServletContext().removeAttribute("login");
        session.getSession().getServletContext().removeAttribute("role");
        session.getSession().getServletContext().removeAttribute("firstName");
        session.getSession().getServletContext().removeAttribute("lastName");
        session.getSession().invalidate();
    }
}
