package ua.training.controller.command;

import ua.training.controller.constant.Locations;
import ua.training.controller.constant.Pages;
import ua.training.controller.util.ProductsHolder;

import javax.servlet.http.HttpServletRequest;

public class RemoveProductFromCheck implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        Long productId = Long.valueOf(request.getParameter("productId"));
        System.out.println("productId = [" + productId + "]");
        ProductsHolder.removeProduct(productId);
        return Locations.REDIRECT + Locations.CREATE_CHECK_FORM;
    }
}
