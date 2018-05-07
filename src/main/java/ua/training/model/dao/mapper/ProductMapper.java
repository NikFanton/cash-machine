package ua.training.model.dao.mapper;

import ua.training.model.entity.Product;
import ua.training.model.entity.ProductInCheck;
import ua.training.model.entity.enums.ProductInCheckType;
import ua.training.model.entity.enums.ProductType;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class ProductMapper implements BaseMapper<Product> {
    @Override
    public Product extractFromResultSet(ResultSet resultSet, String prefix) throws SQLException {
        Long id = resultSet.getLong(prefix + "id");
        String name = resultSet.getString(prefix + "name");
        double quantity = resultSet.getDouble(prefix + "quantity");
        BigInteger price = BigInteger.valueOf(resultSet.getInt(prefix + "price"));
        ProductType type = ProductType.valueOf(resultSet.getString(prefix + "product_type"));
        return new Product(id, name, quantity, price, type);
    }
}
