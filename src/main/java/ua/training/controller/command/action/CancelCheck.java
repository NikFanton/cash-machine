package ua.training.controller.command;

import ua.training.controller.constant.Locations;
import ua.training.controller.constant.Pages;
import ua.training.model.service.CheckService;

import javax.servlet.http.HttpServletRequest;

public class CancelCheck implements Command {
    private CheckService checkService;

    public CancelCheck(CheckService checkService) {
        this.checkService = checkService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        Long id = Long.valueOf(request.getParameter("checkId"));
        checkService.cancelCheck(id);
        return Locations.REDIRECT + Locations.CHECK_LIST;
    }
}
