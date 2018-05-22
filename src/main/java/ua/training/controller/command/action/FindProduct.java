package ua.training.controller.command.action;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import ua.training.constant.AttributeAndParameterNames;
import ua.training.constant.Locations;
import ua.training.constant.Pages;
import ua.training.constant.RegEx;
import ua.training.controller.annotation.CommandWithLocation;
import ua.training.controller.command.Command;
import ua.training.model.entity.Product;
import ua.training.model.service.ProductService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CommandWithLocation(location = Locations.FIND_PRODUCT)
public class FindProduct implements Command {
    private ProductService productService;

    public FindProduct(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String name = request.getParameter(AttributeAndParameterNames.NAME).toLowerCase();
        if (name.matches(RegEx.REGEX_NAME)) {
            List<Product> products = productService.getProductsByName(name);
            request.setAttribute(AttributeAndParameterNames.PRODUCTS, products);
        } else {
            System.out.println("Not matches");
        }
        return Pages.FIND_PRODUCT;
    }
}
