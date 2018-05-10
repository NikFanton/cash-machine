package ua.training.model.entity;

import lombok.Builder;
import ua.training.model.entity.enums.CheckType;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Check implements Entity<Long> {
    private Long id;
    private LocalDateTime dateTime;
    private BigInteger cashPayment;
    private BigInteger cashlessPayment;
    private Employee employee;
    private List<ProductInCheck> productsInCheck;
    private CheckType checkType;

    public Check() {
        productsInCheck = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public BigInteger getCashPayment() {
        return cashPayment;
    }

    public void setCashPayment(BigInteger cashPayment) {
        this.cashPayment = cashPayment;
    }

    public BigInteger getCashlessPayment() {
        return cashlessPayment;
    }

    public void setCashlessPayment(BigInteger cashlessPayment) {
        this.cashlessPayment = cashlessPayment;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<ProductInCheck> getProductsInCheck() {
        return productsInCheck;
    }

    public void setProductsInCheck(List<ProductInCheck> productsInCheck) {
        this.productsInCheck = productsInCheck;
    }

    public CheckType getCheckType() {
        return checkType;
    }

    public void setCheckType(CheckType checkType) {
        this.checkType = checkType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Check)) return false;
        Check check = (Check) o;
        return Objects.equals(getDateTime(), check.getDateTime()) &&
                Objects.equals(getCashPayment(), check.getCashPayment()) &&
                Objects.equals(getCashlessPayment(), check.getCashlessPayment()) &&
                Objects.equals(getEmployee(), check.getEmployee());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDateTime(), getCashPayment(), getCashlessPayment(), getEmployee());
    }

    @Override
    public String toString() {
        return "Check{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", cashPayment=" + cashPayment +
                ", cashlessPayment=" + cashlessPayment +
                ", checkType=" + checkType +
                ", \n\temployee=" + employee +
                ", \n\tproductsInCheck=" + productsInCheck +
                '}';
    }

    public static CheckBuilder builder() {
        return new CheckBuilder();
    }

    public static final class CheckBuilder {
        private Long id;
        private LocalDateTime dateTime;
        private BigInteger cashPayment;
        private BigInteger cashlessPayment;
        private Employee employee;
        private List<ProductInCheck> productsInCheck;
        private CheckType checkType;

        public CheckBuilder() {
            productsInCheck = new ArrayList<>();
        }

        public CheckBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public CheckBuilder setDateTime(LocalDateTime dateTime) {
            this.dateTime = dateTime;
            return this;
        }

        public CheckBuilder setCashPayment(BigInteger cashPayment) {
            this.cashPayment = cashPayment;
            return this;
        }

        public CheckBuilder setCashlessPayment(BigInteger cashlessPayment) {
            this.cashlessPayment = cashlessPayment;
            return this;
        }

        public CheckBuilder setEmployee(Employee employee) {
            this.employee = employee;
            return this;
        }

        public CheckBuilder setProductsInCheck(List<ProductInCheck> productsInCheck) {
            this.productsInCheck = productsInCheck;
            return this;
        }

        public CheckBuilder setCheckType(CheckType checkType) {
            this.checkType = checkType;
            return this;
        }

        public Check build() {
            Check check = new Check();
            check.setId(id);
            check.setDateTime(dateTime);
            check.setCashPayment(cashPayment);
            check.setCashlessPayment(cashlessPayment);
            check.setEmployee(employee);
            check.setProductsInCheck(productsInCheck);
            check.setCheckType(checkType);
            return check;
        }
    }
}
