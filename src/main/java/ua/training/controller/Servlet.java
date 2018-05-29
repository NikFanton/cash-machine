package ua.training.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.constant.Locations;
import ua.training.constant.Pages;
import ua.training.controller.annotation.CommandWithLocation;
import ua.training.controller.command.Command;
import ua.training.controller.command.action.*;
import ua.training.controller.command.direction.*;
import ua.training.model.service.impl.CheckServiceImpl;
import ua.training.model.service.impl.EmployeeServiceImpl;
import ua.training.model.service.impl.ProductServiceImpl;
import ua.training.model.service.impl.ReportServiceImpl;

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
        initCommand(new Login(new EmployeeServiceImpl()));
        initCommand(new LogOut());
        initCommand(new CreateCheckForm());
        initCommand(new CheckList(new CheckServiceImpl()));
        initCommand(new MakeReport(new ReportServiceImpl()));
        initCommand(new MakeXReport(new ReportServiceImpl()));
        initCommand(new MakeZReport(new ReportServiceImpl()));
        initCommand(new AddProduct(new ProductServiceImpl()));
        initCommand(new RemoveProductFromCheck());
        initCommand(new CreateCheck(new CheckServiceImpl(), new EmployeeServiceImpl()));
        initCommand(new CancelCheck(new CheckServiceImpl()));
        initCommand(new FindProductForm());
        initCommand(new FindProduct(new ProductServiceImpl()));
        initCommand(new EmployeeRegistrationForm());
        initCommand(new EmployeeRegistration(new EmployeeServiceImpl()));
        initCommand(new AdminInfo());
        initCommand(new AddProductToStorageForm());
        initCommand(new AddProductToStorage(new ProductServiceImpl()));
        initCommand(new MerchantInfo());
    }

    private void initCommand(Command command) {
        Class clazz = command.getClass();
        CommandWithLocation annotation = (CommandWithLocation) clazz.getAnnotation(CommandWithLocation.class);
        String location = annotation.location();
        commands.put(location, command);
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
        String path = request.getRequestURI().replaceAll(".*/api/", "");;
        Command command = commands.getOrDefault(path, r -> Pages.LOGIN);
        String page = command.execute(request);
        if (page.contains(Locations.REDIRECT)) {
            response.sendRedirect(page.replace(Locations.REDIRECT, "/api/"));
        } else {
            request.getRequestDispatcher(page).forward(request, response);
        }
    }
}
