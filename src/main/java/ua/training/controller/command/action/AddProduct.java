package ua.training.controller.command.action;

import ua.training.controller.command.Command;
import ua.training.controller.constant.Locations;
import ua.training.controller.constant.Pages;
import ua.training.controller.util.ProductsHolder;
import ua.training.model.entity.Product;
import ua.training.model.service.ProductService;

import javax.servlet.http.HttpServletRequest;

public class AddProduct implements Command {
    private static final String REGEX_ID = "[0-9]{1,18}";

    private ProductService productService;

    public AddProduct(ProductService service) {
        this.productService = service;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String id = request.getParameter("id");
        String quantity = request.getParameter("quantity");
        if (id.matches(REGEX_ID)) {
            // TODO exclude null capability
            Product product = productService.getProductById(Long.valueOf(id));
            ProductsHolder.addProduct(product, quantity);
            ProductsHolder.getProductsInCheck().forEach((aLong, product1) -> System.out.println(product1));
        } else {
            System.out.println("Not matches");
        }
        return Locations.REDIRECT + Locations.CREATE_CHECK_FORM;
    }
}
