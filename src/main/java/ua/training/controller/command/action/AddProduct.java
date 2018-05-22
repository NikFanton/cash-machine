package ua.training.controller.command.action;

import ua.training.controller.annotation.CommandWithLocation;
import ua.training.controller.command.Command;
import ua.training.constant.AttributeAndParameterNames;
import ua.training.constant.Locations;
import ua.training.controller.util.ProductsHolder;
import ua.training.model.entity.Product;
import ua.training.model.service.ProductService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@CommandWithLocation(location = Locations.ADD_PRODUCT)
public class AddProduct implements Command {
    private static final String REGEX_ID = "[0-9]{1,18}";

    private ProductService productService;

    public AddProduct(ProductService service) {
        this.productService = service;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String id = request.getParameter(AttributeAndParameterNames.ID);
        String quantity = request.getParameter(AttributeAndParameterNames.QUANTITY);
        try {
            Optional<Product> product = Optional.of(productService.getProductById(Long.valueOf(id)));
            ProductsHolder.addProduct(product.get(), quantity);
        } catch (NumberFormatException | NullPointerException e) {
            logger.debug(e.getMessage() + " " + " there are no product with id " + id);
        }
        return Locations.REDIRECT + Locations.CREATE_CHECK_FORM;
    }
}
