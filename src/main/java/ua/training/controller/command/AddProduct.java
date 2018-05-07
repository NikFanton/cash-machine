package ua.training.controller.command;

import ua.training.controller.constant.CommandNames;
import ua.training.controller.constant.Pages;
import ua.training.controller.util.ProductsHolder;
import ua.training.model.entity.Product;
import ua.training.model.service.ProductService;

import javax.servlet.http.HttpServletRequest;

public class AddProduct implements Command {
    public static final String REGEX_ID = "[0-9]{1,18}";
    public static final String REGEX_NAME = "[A-Za-z \"']+";

    @Override
    public String execute(HttpServletRequest request) {
        String id = request.getParameter("id");
        String quantity = request.getParameter("quantity");
        ProductService service = new ProductService();
        if (id.matches(REGEX_ID)) {
            // TODO exclude null capability
            Product product = service.getProductById(Long.valueOf(id));
            ProductsHolder.addProduct(product, quantity);
            ProductsHolder.getProductsInCheck().forEach((aLong, product1) -> System.out.println(product1));
        } else if (id.matches(REGEX_NAME)) {
            // TODO make search by name
        } else {
            System.out.println("Not matches");
        }
        return Pages.REDIRECT + CommandNames.CREATE_CHECK_FORM;
    }
}
