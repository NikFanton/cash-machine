package ua.training.controller.listener;

import ua.training.constant.AttributeAndParameterNames;
import ua.training.constant.Pages;
import ua.training.model.entity.Employee;
import ua.training.model.entity.enums.Role;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Set;

@WebListener
public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent session) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent session) {
        ServletContext context = session.getSession().getServletContext();
        @SuppressWarnings("unchecked")
        Set<String> authorizedUsers = (Set<String>) context.getAttribute(AttributeAndParameterNames.AUTHORIZED_USERS);
        String login = (String) session.getSession().getAttribute(AttributeAndParameterNames.LOGIN);
        authorizedUsers.remove(login);
        context.setAttribute(AttributeAndParameterNames.AUTHORIZED_USERS, authorizedUsers);
        session.getSession().getServletContext().removeAttribute(AttributeAndParameterNames.LOGIN);
        session.getSession().getServletContext().removeAttribute(AttributeAndParameterNames.ROLE);
        session.getSession().getServletContext().removeAttribute(AttributeAndParameterNames.FIRST_NAME);
        session.getSession().getServletContext().removeAttribute(AttributeAndParameterNames.LAST_NAME);
        session.getSession().invalidate();
    }
}
