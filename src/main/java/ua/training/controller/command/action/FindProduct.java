package ua.training.controller.command.action;

import ua.training.constant.Locations;
import ua.training.controller.annotation.CommandWithLocation;
import ua.training.controller.command.Command;
import ua.training.constant.AttributeAndParameterNames;
import ua.training.constant.Pages;
import ua.training.model.entity.Product;
import ua.training.model.service.ProductService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CommandWithLocation(location = Locations.FIND_PRODUCT)
public class FindProduct implements Command {
//    TODO move REGEX_NAME to constant interface
    private static final String REGEX_NAME = "[1-9a-zа-щьюяґіїє `'\"\\-]{1,20}";

    private ProductService productService;

    public FindProduct(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String name = request.getParameter(AttributeAndParameterNames.NAME).toLowerCase();
        if (name.matches(REGEX_NAME)) {
            List<Product> products = productService.getProductsByName(name);
            request.setAttribute(AttributeAndParameterNames.PRODUCTS, products);
        } else {
            System.out.println("Not matches");
        }
        return Pages.FIND_PRODUCT;
    }
}
