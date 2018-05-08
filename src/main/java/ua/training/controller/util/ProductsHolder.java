package ua.training.controller.util;

import ua.training.model.entity.Product;
import ua.training.model.entity.enums.ProductType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ProductsHolder {
    private static final String REGEX_COUNTABLE = "[0-9]{1,10}";
    private static final String REGEX_UNCOUNTABLE = "[0-9]{1,10}((\\.)[0-9]{1,10})?";

    private static Map<Long, Product> products = new ConcurrentHashMap<>();

    public static Map<Long, Product> getProductsInCheck() {
        return products;
    }

    public static void removeProduct(Long id) {
        products.remove(id);
    }

    public static void addProduct(Product product, String quantity) {
        if (isQuantityValueValid(product, quantity)) {
            product.setQuantity(0.0);
            products.putIfAbsent(product.getId(), product);
            Product uniqueProduct = products.get(product.getId());
            uniqueProduct.setQuantity(uniqueProduct.getQuantity() + Double.parseDouble(quantity));
        }
    }

    private static boolean isQuantityValueValid(Product product, String quantity) {
        return product.getProductType().equals(ProductType.COUNTABLE) && quantity.matches(REGEX_COUNTABLE) ||
                product.getProductType().equals(ProductType.UNCOUNTABLE) && quantity.matches(REGEX_UNCOUNTABLE);
    }

    public static List<Product> getList() {
        List<Product> result = new ArrayList<>();
        products.forEach((aLong, product) -> result.add(product));
        return result;
    }

    public static void clear() {
        products.clear();
    }
}
