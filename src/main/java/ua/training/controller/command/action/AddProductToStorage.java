package ua.training.controller.command.action;

import ua.training.controller.annotation.CommandWithLocation;
import ua.training.controller.command.Command;
import ua.training.constant.AttributeAndParameterNames;
import ua.training.constant.Locations;
import ua.training.model.entity.Product;
import ua.training.model.entity.enums.ProductType;
import ua.training.model.service.ProductService;

import javax.servlet.http.HttpServletRequest;

@CommandWithLocation(location = Locations.ADD_PRODUCT_TO_STORAGE)
public class AddProductToStorage implements Command {
    private ProductService productService;

    public AddProductToStorage(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String name = request.getParameter(AttributeAndParameterNames.PRODUCT_NAME);
        Double quantity = Double.valueOf(request.getParameter(AttributeAndParameterNames.PRODUCT_QUANTITY));
        Double price = Double.valueOf(request.getParameter(AttributeAndParameterNames.PRODUCT_PRICE));
        ProductType productType = ProductType.valueOf(request.getParameter(AttributeAndParameterNames.PRODUCT_TYPE));
        productService.addProduct(Product.builder()
                .setName(name)
                .setQuantity(quantity)
                .setPrice(price)
                .setProductType(productType)
                .build());
        return Locations.REDIRECT + Locations.ADD_PRODUCT_TO_STORAGE_FORM;
    }
}
