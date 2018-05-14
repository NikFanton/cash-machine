package ua.training.controller.util;

import ua.training.model.entity.ProductInCheck;

import java.util.ArrayList;
import java.util.List;

public class ProductUtil {
    public static List<ProductInCheck> getListOfProducts() {
        List<ProductInCheck> productsInCheck = new ArrayList<>();
        ProductsHolder.getList().forEach(product -> productsInCheck.add(new ProductInCheck(product)));
        return productsInCheck;
    }
}
