package ua.training.model.service.impl;

import ua.training.model.dao.ProductDAO;
import ua.training.model.dao.factory.DAOFactory;
import ua.training.model.entity.Product;
import ua.training.model.service.Service;

public class ProductService implements Service {
    public Product getProductById(Long id) {
        try (ProductDAO dao = daoFactory.getProductDAO()) {
            return dao.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
