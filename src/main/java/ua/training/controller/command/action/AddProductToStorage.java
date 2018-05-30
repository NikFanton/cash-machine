package ua.training.controller.command.action;

import ua.training.constant.AttributeAndParameterNames;
import ua.training.constant.Locations;
import ua.training.constant.RegEx;
import ua.training.controller.annotation.CommandWithLocation;
import ua.training.controller.command.Command;
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
        String quantity = request.getParameter(AttributeAndParameterNames.PRODUCT_QUANTITY);
        String price = request.getParameter(AttributeAndParameterNames.PRODUCT_PRICE);
        ProductType productType = ProductType.valueOf(request.getParameter(AttributeAndParameterNames.PRODUCT_TYPE));
        if ((productType == ProductType.COUNTABLE) ? quantity.matches(RegEx.REGEX_QUANTITY_FOR_COUNTABLE)
                                                   : quantity.matches(RegEx.REGEX_QUANTITY_FOR_UNCOUNTABLE)
                && price.matches(RegEx.REGEX_PRICE)
                && name.matches(RegEx.REGEX_NAME)) {
            productService.addProduct(Product.builder()
                    .setName(name)
                    .setQuantity(Double.parseDouble(quantity))
                    .setPrice(Double.valueOf(price) * 100)
                    .setProductType(productType)
                    .build());
        }
        return Locations.REDIRECT + Locations.ADD_PRODUCT_TO_STORAGE_FORM;
    }
}
