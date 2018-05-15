package ua.training.controller.listener;

import ua.training.constant.AttributeAndParameterNames;
import ua.training.constant.Pages;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent session) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent session) {
        session.getSession().getServletContext().removeAttribute(AttributeAndParameterNames.LOGIN);
        session.getSession().getServletContext().removeAttribute(AttributeAndParameterNames.ROLE);
        session.getSession().getServletContext().removeAttribute(AttributeAndParameterNames.FIRST_NAME);
        session.getSession().getServletContext().removeAttribute(AttributeAndParameterNames.LAST_NAME);
        session.getSession().invalidate();
    }
}
