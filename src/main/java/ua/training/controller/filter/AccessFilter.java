package ua.training.controller.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.constant.AttributeAndParameterNames;
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
    public static final Logger logger = LogManager.getLogger(AccessFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        Role role = (Role) session.getAttribute(AttributeAndParameterNames.ROLE);
        role = Optional.ofNullable(role).orElse(Role.UNKNOWN);
        String action = req.getRequestURI().replaceAll(".*/api/", "");
        String logInfo = "role: " + role + " | action: [" + action + "] | access status: ";
        if (role.getAccessibleLocations().contains(action)) {
            logger.info(logInfo + "YES");
            chain.doFilter(request, response);
        } else {
            logger.info(logInfo + "NO");
            resp.sendRedirect(role.getStartPage());
        }
    }

    @Override
    public void destroy() {

    }
}
