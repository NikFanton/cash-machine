package ua.training.controller.servlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.controller.command.Command;
import ua.training.controller.command.CreateCheck;
import ua.training.controller.command.LogOut;
import ua.training.controller.constant.CommandNames;
import ua.training.model.dao.CheckDAO;
import ua.training.model.dao.CheckManipulationDAO;
import ua.training.model.dao.EmployeeDAO;
import ua.training.model.dao.factory.DAOFactory;
import ua.training.model.dao.mapper.CheckManipulationMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Servlet extends HttpServlet {
    private static Logger LOGGER = LogManager.getLogger(Servlet.class);
    private Map<String, Command> commands = new HashMap<>();

    @Override
    public void init() {
        CheckManipulationDAO dao = DAOFactory.getDaoFactory().getCheckManipulationDAO();
        System.out.println(dao.getById(1L));

        commands.put(CommandNames.LOGOUT, new LogOut());
        commands.put(CommandNames.CREATE_CHECK, new CreateCheck());
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
