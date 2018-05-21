package ua.training.model.entity;

import ua.training.model.entity.enums.ProductInCheckType;
import ua.training.model.entity.enums.ProductType;

import java.math.BigInteger;
import java.util.Objects;

public class ProductInCheck extends Product {
    private ProductInCheckType productInCheckType;

    public ProductInCheck() {
    }

    public ProductInCheck(Product product) {
        super(product.getId(), product.getName(), product.getQuantity(), product.getPrice(), product.getProductType());
        this.productInCheckType = ProductInCheckType.NORMAL;
    }

    public ProductInCheck(Long id, String name, double quantity, Double price, ProductType productType,
                          ProductInCheckType productInCheckType) {
        super(id, name, quantity, price, productType);
        this.productInCheckType = productInCheckType;
    }

    public ProductInCheckType getProductInCheckType() {
        return productInCheckType;
    }

    public ProductInCheck setProductInCheckType(ProductInCheckType productInCheckType) {
        this.productInCheckType = productInCheckType;
        return this;
    }
}
