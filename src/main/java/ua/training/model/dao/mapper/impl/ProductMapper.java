package ua.training.model.dao.mapper;

import ua.training.constant.database.ProductFieldsNames;
import ua.training.model.entity.Product;
import ua.training.model.entity.enums.ProductType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements BaseMapper<Product> {
    @Override
    public Product extractFromResultSet(ResultSet resultSet, String prefix) throws SQLException {
        Long id = resultSet.getLong(prefix + ProductFieldsNames.ID);
        String name = resultSet.getString(prefix + ProductFieldsNames.NAME);
        double quantity = resultSet.getDouble(prefix + ProductFieldsNames.QUANTITY);
        Double price = resultSet.getDouble(prefix + ProductFieldsNames.PRICE);
        ProductType type = ProductType.valueOf(resultSet.getString(prefix + ProductFieldsNames.PRODUCT_TYPE));
        return new Product(id, name, quantity, price, type);
    }
}
