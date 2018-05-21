package ua.training.model.service.impl;

import ua.training.constant.LogMessages;
import ua.training.model.dao.ProductDAO;
import ua.training.model.entity.Product;
import ua.training.model.exception.NoSuchResultFromDataBaseException;
import ua.training.model.service.ProductService;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {
    public Product getProductById(Long id) {
        try (ProductDAO dao = daoFactory.getProductDAO()) {
            return dao.getById(id);
        } catch (Exception e) {
            logger.error(e.getMessage() + " " + LogMessages.GET_PRODUCT_BY_ID_ERROR);
            return null;
        }
    }

    @Override
    public List<Product> getProductsByName(String name) {
        try (ProductDAO dao = daoFactory.getProductDAO()) {
            return Optional.ofNullable(dao.getProductsByName(name)).orElseThrow(NoSuchResultFromDataBaseException::new);
        } catch (Exception e) {
            logger.error(e.getMessage() + " " + LogMessages.GET_PRODUCTS_BY_NAME_ERROR);
            return null;
        }
    }

    @Override
    public void addProduct(Product product) {
        try(ProductDAO dao = daoFactory.getProductDAO()) {
            dao.add(product);
        } catch (Exception e) {
            logger.error(e.getMessage() + " " + LogMessages.CREATE_PRODUCT_ERROR);
        }
    }
}
