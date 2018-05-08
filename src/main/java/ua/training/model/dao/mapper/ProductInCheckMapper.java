package ua.training.model.dao.mapper;

import ua.training.model.entity.ProductInCheck;
import ua.training.model.entity.enums.ProductInCheckType;
import ua.training.model.entity.enums.ProductType;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class ProductInCheckMapper implements BaseMapper<ProductInCheck> {
    @Override
    public ProductInCheck extractFromResultSet(ResultSet resultSet, String prefix) throws SQLException {
        Long id = resultSet.getLong(prefix + "id");
        String name = resultSet.getString(prefix + "name");
        Double quantity = resultSet.getDouble(prefix + "quantity");
        Double price = resultSet.getDouble(prefix + "price");
        ProductType productType = ProductType.valueOf(resultSet.getString(prefix + "product_type"));
        String typeName = resultSet.getString(prefix + "product_in_check_type");
        ProductInCheckType type = ProductInCheckType.valueOf(typeName);
        return new ProductInCheck(id, name, quantity, price, productType, type);
    }
}
