package ua.training.model.entity;

import ua.training.model.entity.enums.ProductType;

import java.math.BigInteger;
import java.util.Objects;

public class Product implements Entity<Long> {
    private Long id;
    private String name;
    private double quantity;
    private Double price;
    private ProductType productType;

    public Product() {
    }

    public Product(String name, double quantity, Double price, ProductType productType) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.productType = productType;
    }

    public Product(Long id, String name, double quantity, Double price, ProductType productType) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.productType = productType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public static ProductBuilder builder() {
        return new ProductBuilder();
    }

    public static final class ProductBuilder {
        private Long id;
        private String name;
        private double quantity;
        private Double price;
        private ProductType productType;

        public ProductBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public ProductBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder setQuantity(double quantity) {
            this.quantity = quantity;
            return this;
        }

        public ProductBuilder setPrice(Double price) {
            this.price = price;
            return this;
        }

        public ProductBuilder setProductType(ProductType productType) {
            this.productType = productType;
            return this;
        }

        public Product build() {
            Product product = new Product();
            product.setId(id);
            product.setName(name);
            product.setQuantity(quantity);
            product.setPrice(price);
            product.setProductType(productType);
            return product;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(getName(), product.getName()) &&
                getProductType() == product.getProductType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getProductType());
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", productType=" + productType +
                '}';
    }
}
