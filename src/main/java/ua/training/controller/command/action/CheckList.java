package ua.training.controller.command;

import ua.training.controller.constant.Pages;
import ua.training.model.entity.Check;
import ua.training.model.service.CheckService;
import ua.training.model.service.impl.CheckServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CheckList implements Command {

    private CheckService checkService;

    public CheckList(CheckService checkService) {
        this.checkService = checkService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        List<Check> checks = checkService.getAllChecks();
        request.setAttribute("checks", checks);
        return Pages.CHECK_LIST;
    }
}
