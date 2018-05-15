package ua.training.controller.command.action;

import ua.training.controller.command.Command;
import ua.training.constant.AttributeAndParameterNames;
import ua.training.constant.Locations;
import ua.training.constant.Pages;
import ua.training.controller.util.ProductsHolder;

import javax.servlet.http.HttpServletRequest;

public class RemoveProductFromCheck implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        Long productId = Long.valueOf(request.getParameter(AttributeAndParameterNames.PRODUCT_ID));
        ProductsHolder.removeProduct(productId);
        return Locations.REDIRECT + Locations.CREATE_CHECK_FORM;
    }
}
