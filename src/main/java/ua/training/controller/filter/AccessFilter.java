package ua.training.controller.filter;

import ua.training.model.entity.enums.Role;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebFilter(urlPatterns = "/api/*")
public class AccessFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("ACCESS FILTER");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        Role role = (Role) session.getServletContext().getAttribute("role");
        role = Optional.ofNullable(role).orElse(Role.UNKNOWN);
        String action = req.getRequestURI().replaceAll(".*/api/", "");
        System.out.println("access role = [" + role + "]");
        System.out.println("access action = [" + action + "]");
        if (role.getAccessibleLocations().contains(action)) {
            System.out.println("access status = [YES]");
            chain.doFilter(request, response);
        } else {
            System.out.println("access status = [NO]");
            resp.sendRedirect(role.getStartPage());
        }
    }

    @Override
    public void destroy() {

    }
}
