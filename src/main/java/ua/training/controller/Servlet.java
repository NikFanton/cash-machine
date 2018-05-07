package ua.training.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.controller.command.*;
import ua.training.controller.constant.CommandNames;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Servlet extends HttpServlet {
    private static Logger logger = LogManager.getLogger(Servlet.class);
    private ConcurrentMap<String, Command> commands = new ConcurrentHashMap<>();

    @Override
    public void init() {
        commands.put(CommandNames.LOGOUT, new LogOut());
        commands.put(CommandNames.CREATE_CHECK_FORM, new CreateCheckForm());
        commands.put(CommandNames.CHECK_LIST, new CheckList());
        commands.put(CommandNames.REPORT, new Report());
        commands.put(CommandNames.ADD_PRODUCT, new AddProduct());
        commands.put(CommandNames.SAVE_CHECK, new SaveCheck());
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
        String path = request.getRequestURI();
        System.out.println(path);
        path = path.replaceAll(".*/api/", "");
        Command command = commands.getOrDefault(path, r -> "/index.jsp");
        String page = command.execute(request);
        if (page.contains("redirect:")) {
            response.sendRedirect(page.replace("redirect:", "/api/"));
        } else {
            request.getRequestDispatcher(page).forward(request, response);
        }
    }
}
