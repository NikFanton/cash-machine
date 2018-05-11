package ua.training.controller.command.action;

import ua.training.controller.command.Command;
import ua.training.controller.constant.Locations;
import ua.training.controller.constant.Pages;
import ua.training.model.entity.Check;
import ua.training.model.service.CheckService;
import ua.training.model.service.impl.CheckServiceImpl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

public class CheckList implements Command {
    private static final Integer CHECKS_PER_PAGE = 9;

    private CheckService checkService;

    public CheckList(CheckService checkService) {
        this.checkService = checkService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        Integer pageNumber = Integer.valueOf(Optional.ofNullable(request.getParameter("page")).orElse("1"));
        Integer maxPageNumber = (int) Math.ceil(checkService.getNumberOfChecks() / (double) CHECKS_PER_PAGE);
        request.setAttribute("maxPageNumber", maxPageNumber);
        if (pageNumber > maxPageNumber || pageNumber < 1) {
            request.setAttribute("page", 1);
            return Locations.REDIRECT + Locations.CHECK_LIST;
        }
        else {
            List<Check> checks = checkService.getPartOffAllChecks(CHECKS_PER_PAGE, pageNumber);
            request.setAttribute("checks", checks);
            request.setAttribute("page", pageNumber);
            return Pages.CHECK_LIST;
        }
    }
}
