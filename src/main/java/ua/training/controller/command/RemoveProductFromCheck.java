package ua.training.controller.command;

import ua.training.controller.constant.CommandNames;
import ua.training.controller.constant.Pages;
import ua.training.controller.util.ProductsHolder;
import ua.training.model.service.ProductService;

import javax.servlet.http.HttpServletRequest;

public class RemoveFromCheck implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        Long productId = Long.valueOf(request.getParameter("productId"));
        ProductsHolder.removeProduct(productId);
        return Pages.REDIRECT + CommandNames.CREATE_CHECK_FORM;
    }
}
