package ua.training.controller.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.constant.AttributeAndParameterNames;
import ua.training.constant.Pages;
import ua.training.model.entity.enums.Role;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.util.Objects.nonNull;

//@WebFilter(urlPatterns = "/api/login")
@Deprecated
public class AuthorisationFilter implements Filter {

    final static Logger logger = LogManager.getLogger();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        ServletContext context = session.getServletContext();
        Role role = (Role) session.getAttribute(AttributeAndParameterNames.ROLE);
        String login = (String) session.getAttribute(AttributeAndParameterNames.LOGIN);
        
        if (nonNull(role) && nonNull(login)) {
            request.getRequestDispatcher(Pages.LOGIN).forward(request, response);
        } else {
            filterChain.doFilter(request, response);
        }
    }
    @Override
    public void destroy() {

    }
}
