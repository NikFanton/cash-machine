package ua.training.controller.command.action;

import ua.training.controller.command.Command;
import ua.training.controller.constant.Locations;
import ua.training.model.entity.Product;
import ua.training.model.entity.enums.ProductType;
import ua.training.model.service.ProductService;

import javax.servlet.http.HttpServletRequest;

public class AddProductToStorage implements Command {

    private ProductService productService;

    public AddProductToStorage(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String name = request.getParameter("productName");
        Double quantity = Double.valueOf(request.getParameter("productQuantity"));
        Double price = Double.valueOf(request.getParameter("productPrice"));
        ProductType productType = ProductType.valueOf(request.getParameter("productType"));
        productService.addProduct(Product.builder()
                .setName(name)
                .setQuantity(quantity)
                .setPrice(price)
                .setProductType(productType)
                .build());
        return Locations.REDIRECT + Locations.ADD_PRODUCT_TO_STORAGE_FORM;
    }
}
