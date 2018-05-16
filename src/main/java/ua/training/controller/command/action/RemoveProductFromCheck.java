package ua.training.controller.command.action;

import ua.training.controller.annotation.CommandWithLocation;
import ua.training.controller.command.Command;
import ua.training.constant.AttributeAndParameterNames;
import ua.training.constant.Locations;
import ua.training.controller.util.ProductsHolder;

import javax.servlet.http.HttpServletRequest;

@CommandWithLocation(location = Locations.REMOVE_PRODUCT_FROM_CHECK)
public class RemoveProductFromCheck implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        Long productId = Long.valueOf(request.getParameter(AttributeAndParameterNames.PRODUCT_ID));
        ProductsHolder.removeProduct(productId);
        return Locations.REDIRECT + Locations.CREATE_CHECK_FORM;
    }
}
