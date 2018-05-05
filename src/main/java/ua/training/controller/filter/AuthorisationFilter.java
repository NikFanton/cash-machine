package ua.training.controller.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.controller.constant.Pages;
import ua.training.controller.util.ResourceUtil;
import ua.training.model.entity.enums.Role;
import ua.training.model.service.EmployeeService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ResourceBundle;

import static java.util.Objects.nonNull;

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
        String login = request.getParameter("login");
        String password = request.getParameter("pass");
        EmployeeService service = new EmployeeService();
        HttpSession session = request.getSession();
        Role role = getRoleAndSetInfoInSession(login, password, service, session);
        System.out.println("login: " + login);
        System.out.println("password: " + password);
        System.out.println("Role" + role);
        String page = getPage(request, role);
        request.getRequestDispatcher(page).forward(request, response);
    }

    private Role getRoleAndSetInfoInSession(String login, String password, EmployeeService service, HttpSession session) {
        Role role;
        if (nonNull(session) &&
                nonNull(session.getAttribute("login")) &&
                nonNull(session.getAttribute("pass"))) {
            role = (Role) session.getAttribute("role");
        } else if (nonNull(session) && service.isEmployeeExist(login, password)) {
            role = service.getEmployee(login).getRole();
            session.setAttribute("login", login);
            session.setAttribute("pass", password);
            session.setAttribute("role", role);
        } else {
            role = Role.UNKNOWN;
        }
        return role;
    }

    private String getPage(ServletRequest servletRequest, Role role) {
        if (!role.equals(Role.UNKNOWN)) {
            ResourceUtil.setAttributesCreateCheckForm(servletRequest);
            return Pages.CREATE_CHECK;
        } else {
            System.out.println("GUEST");
            return Pages.LOGIN;
        }
    }

    @Override
    public void destroy() {

    }
}
