package ua.training.controller.command;

import ua.training.controller.constant.Pages;
import ua.training.model.entity.Check;
import ua.training.model.service.CheckService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CheckList implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        CheckService service = new CheckService();
        List<Check> checks = service.getAllChecks();
        request.setAttribute("checks", checks);
        return Pages.CHECK_LIST;
    }
}
