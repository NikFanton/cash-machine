package ua.training.controller.command.action;

import ua.training.controller.annotation.CommandWithLocation;
import ua.training.controller.command.Command;
import ua.training.constant.AttributeAndParameterNames;
import ua.training.constant.Locations;
import ua.training.model.service.CheckService;

import javax.servlet.http.HttpServletRequest;

@CommandWithLocation(location = Locations.CANCEL_CHECK)
public class CancelCheck implements Command {
    private CheckService checkService;

    public CancelCheck(CheckService checkService) {
        this.checkService = checkService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        Long id = Long.valueOf(request.getParameter(AttributeAndParameterNames.CHECK_ID));
        checkService.cancelCheck(id);
        return Locations.REDIRECT + Locations.CHECK_LIST;
    }
}
