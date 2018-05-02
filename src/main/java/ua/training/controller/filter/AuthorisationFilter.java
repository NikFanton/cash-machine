package ua.training.controller.filter;

import ua.training.model.entity.Role;
import ua.training.model.service.UserService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.util.Objects.nonNull;

public class AuthorisationFilter implements Filter {

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
        UserService service = new UserService();
        HttpSession session = request.getSession();
        Role role = getRoleAndSetInfoInSession(login, password, service, session);
        moveToPage(request, response, role);
    }

    private Role getRoleAndSetInfoInSession(String login, String password, UserService service, HttpSession session) {
        Role role;
        if (nonNull(session) &&
                nonNull(session.getAttribute("login")) &&
                nonNull(session.getAttribute("pass"))) {
            role = (Role) session.getAttribute("role");
        } else if (nonNull(session) && service.isUserExist(login, password)) {
            role = service.getUser(login, password).getRole();
            session.setAttribute("login", login);
            session.setAttribute("pass", password);
            session.setAttribute("role", role);
        } else {
            role = Role.UNKNOWN;
        }
        return role;
    }

    private void moveToPage(HttpServletRequest request, HttpServletResponse response, Role role)
            throws ServletException, IOException {
        if (role.equals(Role.ADMIN) || role.equals(Role.USER)) {
            request.getRequestDispatcher("/user-page.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
