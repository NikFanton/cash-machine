package ua.training.controller.listener;

import ua.training.model.entity.Employee;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.HashSet;

@WebListener
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
        event.getServletContext().setAttribute("authorizedUsers", new HashSet<String>());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
