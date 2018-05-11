package ua.training.controller.command.action;

import ua.training.controller.command.Command;
import ua.training.controller.constant.Pages;
import ua.training.model.entity.Product;
import ua.training.model.service.ProductService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class FindProduct implements Command {
    private static final String REGEX_NAME = "[A-Za-z \"']+";

    private ProductService productService;

    public FindProduct(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String name = request.getParameter("name");
        System.out.println("name = [" + name + "]");
        if (name.matches(REGEX_NAME)) {
            List<Product> products = productService.getProductsByName(name);
            request.setAttribute("products", products);
        } else {
            System.out.println("Not matches");
        }
        return Pages.FIND_PRODUCT;
    }
}
