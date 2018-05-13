package ua.training.model.service.impl;

import ua.training.model.dao.ProductDAO;
import ua.training.model.dao.factory.DAOFactory;
import ua.training.model.entity.Product;
import ua.training.model.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    public Product getProductById(Long id) {
        try (ProductDAO dao = daoFactory.getProductDAO()) {
            return dao.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> getProductsByName(String name) {
        try (ProductDAO dao = daoFactory.getProductDAO()) {
            return dao.getProductsByName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addProduct(Product product) {
        try(ProductDAO dao = DAOFactory.getDaoFactory().getProductDAO()) {
            dao.add(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
