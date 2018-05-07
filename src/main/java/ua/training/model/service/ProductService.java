package ua.training.model.service;

import ua.training.model.entity.Product;

public class ProductService implements Service {

    public Product getProductById(Long id) {
        return daoFactory.getProductDAO().getById(id);
    }
}
