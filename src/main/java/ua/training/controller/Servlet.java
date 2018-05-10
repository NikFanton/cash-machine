package ua.training.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.controller.command.*;
import ua.training.controller.command.direction.CreateCheckForm;
import ua.training.controller.command.direction.EmployeeRegistrationForm;
import ua.training.controller.command.direction.FindProductForm;
import ua.training.controller.command.RemoveProductFromCheck;
import ua.training.controller.constant.Locations;
import ua.training.controller.constant.Pages;
import ua.training.model.service.impl.CheckServiceImpl;
import ua.training.model.service.impl.EmployeeServiceImpl;
import ua.training.model.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@WebServlet(urlPatterns = "/api/*")
public class Servlet extends HttpServlet {
    private static Logger logger = LogManager.getLogger(Servlet.class);
    private ConcurrentMap<String, Command> commands = new ConcurrentHashMap<>();

    @Override
    public void init() {
        commands.put(Locations.LOGIN, new Login(new EmployeeServiceImpl()));
        commands.put(Locations.LOGOUT, new LogOut());
        commands.put(Locations.CREATE_CHECK_FORM, new CreateCheckForm());
        commands.put(Locations.CHECK_LIST, new CheckList(new CheckServiceImpl()));
        commands.put(Locations.REPORT, new Report());
        commands.put(Locations.ADD_PRODUCT, new AddProduct(new ProductServiceImpl()));
        commands.put(Locations.REMOVE_PRODUCT_FROM_CHECK, new RemoveProductFromCheck());
        commands.put(Locations.SAVE_CHECK, new SaveCheck(new CheckServiceImpl(), new EmployeeServiceImpl()));
        commands.put(Locations.CANCEL_CHECK, new CancelCheck(new CheckServiceImpl()));
        commands.put(Locations.FIND_PRODUCT_FORM, new FindProductForm());
        commands.put(Locations.FIND_PRODUCT, new FindProduct(new ProductServiceImpl()));
        commands.put(Locations.EMPLOYEE_REGISTRATION_FORM, new EmployeeRegistrationForm());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("SERVLET");
        String path = request.getRequestURI();
        System.out.println(path);
        path = path.replaceAll(".*/api/", "");
        Command command = commands.getOrDefault(path, r -> Pages.LOGIN);
        String page = command.execute(request);
        if (page.contains("redirect:")) {
            response.sendRedirect(page.replace("redirect:", "/api/"));
        } else {
            request.getRequestDispatcher(page).forward(request, response);
        }
    }
}
