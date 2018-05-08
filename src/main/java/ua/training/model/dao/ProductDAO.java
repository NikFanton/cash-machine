package ua.training.model.dao;

import ua.training.model.entity.Product;

import java.util.List;

public interface ProductDAO extends GenericDAO<Product, Long> {
    List<Product> getProductsByName(String name);
}
