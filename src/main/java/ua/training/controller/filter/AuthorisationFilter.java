package ua.training.controller.filter;

import ua.training.model.dao.EmployeeDAO;
import ua.training.model.dao.factory.JdbcDAOFactory;
import ua.training.model.entity.Employee;
import ua.training.model.entity.enums.Role;
import ua.training.model.service.EmployeeService;

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
        EmployeeDAO employeeDAO  = JdbcDAOFactory.getDaoFactory().getEmployeeDAO();
        employeeDAO.add(new Employee("Tony", "Stark", "tonystark", "stark111", Role.SENIOR_CASHIER));
        employeeDAO.getAll().forEach(System.out::println);
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String login = request.getParameter("login");
        String password = request.getParameter("pass");
        EmployeeService service = new EmployeeService();
        HttpSession session = request.getSession();
        Role role = getRoleAndSetInfoInSession(login, password, service, session);
        moveToPage(request, response, role);
    }

    private Role getRoleAndSetInfoInSession(String login, String password, EmployeeService service, HttpSession session) {
        Role role;
        if (nonNull(session) &&
                nonNull(session.getAttribute("login")) &&
                nonNull(session.getAttribute("pass"))) {
            role = (Role) session.getAttribute("role");
        } else if (nonNull(session) && service.isEmployeeExist(login, password)) {
            role = service.getEmployee(login, password).getRole();
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

        if (!role.equals(Role.UNKNOWN)) {
            request.getRequestDispatcher("/user-page.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
