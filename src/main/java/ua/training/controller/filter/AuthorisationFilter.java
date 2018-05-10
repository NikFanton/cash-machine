package ua.training.controller.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.controller.constant.Pages;
import ua.training.model.entity.enums.Role;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.util.Objects.nonNull;

@WebFilter(urlPatterns = "/api/login")
public class AuthorisationFilter implements Filter {

    final static Logger logger = LogManager.getLogger();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        System.out.println("FILTER");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        ServletContext context = session.getServletContext();
        Role role = (Role) context.getAttribute("role");
        String login = (String) context.getAttribute("login");
        System.out.println("role = [" + role + "]");

//        TODO Catch role here if already in system
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
