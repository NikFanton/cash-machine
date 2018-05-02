package ua.training.model.entity;

import ua.training.model.entity.enums.ProductInCheckType;
import ua.training.model.entity.enums.ProductType;

import java.math.BigInteger;
import java.util.Objects;

public class ProductInCheck extends Product {
    private ProductInCheckType productInCheckType;

    public ProductInCheck() {
    }

    public ProductInCheck(Long id, String name, double quantity, BigInteger price, ProductType productType, ProductInCheckType productInCheckType) {
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



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductInCheck)) return false;
        ProductInCheck product = (ProductInCheck) o;
        return  Objects.equals(getId(), product.getId()) &&
                Objects.equals(getName(), product.getName()) &&
                getProductType() == product.getProductType() &&
                getProductInCheckType() == product.getProductInCheckType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getProductType());
    }
}
