package ua.training.controller.command.direction;

import ua.training.constant.Locations;
import ua.training.controller.annotation.CommandWithLocation;
import ua.training.controller.command.Command;
import ua.training.constant.AttributeAndParameterNames;
import ua.training.constant.Pages;
import ua.training.controller.util.ProductsHolder;

import javax.servlet.http.HttpServletRequest;

@CommandWithLocation(location = Locations.CREATE_CHECK_FORM)
public class CreateCheckForm implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute(AttributeAndParameterNames.PRODUCTS, ProductsHolder.getList());
        return Pages.CREATE_CHECK_FORM;
    }
}
