package ua.training.controller.util;

import ua.training.model.entity.ProductInCheck;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ProductHolder {

    private static List<ProductInCheck> products;

    public static List<ProductInCheck> getProductList() {
        if (products == null) {
            synchronized (ProductHolder.class) {
                if (products == null) {
                    products = new CopyOnWriteArrayList<>();
                }
            }
        }
        return products;
    }
}
