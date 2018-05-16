package ua.training.controller.command.action;

import ua.training.controller.annotation.CommandWithLocation;
import ua.training.controller.command.Command;
import ua.training.constant.AttributeAndParameterNames;
import ua.training.constant.Locations;
import ua.training.constant.Pages;
import ua.training.model.entity.Check;
import ua.training.model.service.CheckService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@CommandWithLocation(location = Locations.CHECK_LIST)
public class CheckList implements Command {
//    TODO Move constant CHECKS_PER_PAGE to Constant interface
    private static final Integer CHECKS_PER_PAGE = 9;

    private CheckService checkService;

    public CheckList(CheckService checkService) {
        this.checkService = checkService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        Integer pageNumber = Integer.valueOf(Optional.ofNullable(request.getParameter(AttributeAndParameterNames.PAGE))
                                .orElse(AttributeAndParameterNames.FIRST_PAGE));
        Integer maxPageNumber = (int) Math.ceil(checkService.getNumberOfChecks() / (double) CHECKS_PER_PAGE);
        request.setAttribute(AttributeAndParameterNames.MAX_PAGE_NUMBER, maxPageNumber);
        if (pageNumber > maxPageNumber || pageNumber < 1) {
            request.setAttribute(AttributeAndParameterNames.PAGE, 1);
            return Locations.REDIRECT + Locations.CHECK_LIST;
        }
        else {
            List<Check> checks = checkService.getPartOffAllChecks(CHECKS_PER_PAGE, pageNumber);
            request.setAttribute(AttributeAndParameterNames.CHECKS, checks);
            request.setAttribute(AttributeAndParameterNames.PAGE, pageNumber);
            return Pages.CHECK_LIST;
        }
    }
}
