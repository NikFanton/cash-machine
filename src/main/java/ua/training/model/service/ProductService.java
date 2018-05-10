package ua.training.model.service;

import ua.training.model.entity.Product;

import java.util.List;

public interface ProductService extends Service {
    Product getProductById(Long id);
    List<Product> getProductsByName(String name);
}
