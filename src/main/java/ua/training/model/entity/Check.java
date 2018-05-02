package ua.training.model.entity;

import ua.training.model.entity.enums.CheckType;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Check {
    private Long id;
    private LocalDateTime dateTime;
    private BigInteger cashPayment;
    private BigInteger cashlessPayment;
    private Employee employee;
    private List<ProductInCheck> productsInCheck;
    private CheckType checkType;

    public Check() {
    }

    public Check(BigInteger cashPayment, BigInteger cashlessPayment, Employee employee, List<ProductInCheck> productsInCheck) {
        this.cashPayment = cashPayment;
        this.cashlessPayment = cashlessPayment;
        this.employee = employee;
        this.productsInCheck = productsInCheck;
    }

    public Check(Long id, LocalDateTime dateTime, BigInteger cashPayment, BigInteger cashlessPayment, CheckType checkType) {
        this.id = id;
        this.dateTime = dateTime;
        this.cashPayment = cashPayment;
        this.cashlessPayment = cashlessPayment;
        this.checkType = checkType;
    }

    public Check(LocalDateTime dateTime, BigInteger cashPayment, BigInteger cashlessPayment,
                 Employee employee, List<ProductInCheck> productsInCheck, CheckType checkType) {
        this.dateTime = dateTime;
        this.cashPayment = cashPayment;
        this.cashlessPayment = cashlessPayment;
        this.employee = employee;
        this.productsInCheck = productsInCheck;
        this.checkType = checkType;
    }

    public Check(Long id, LocalDateTime dateTime, BigInteger cashPayment, BigInteger cashlessPayment,
                 Employee employee, List<ProductInCheck> productsInCheck, CheckType checkType) {
        this.id = id;
        this.dateTime = dateTime;
        this.cashPayment = cashPayment;
        this.cashlessPayment = cashlessPayment;
        this.employee = employee;
        this.productsInCheck = productsInCheck;
        this.checkType = checkType;
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
        return Objects.equals(getId(), check.getId()) &&
                Objects.equals(getDateTime(), check.getDateTime()) &&
                Objects.equals(getCashPayment(), check.getCashPayment()) &&
                Objects.equals(getCashlessPayment(), check.getCashlessPayment()) &&
                Objects.equals(getEmployee(), check.getEmployee()) &&
                Objects.equals(getProductsInCheck(), check.getProductsInCheck());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getDateTime(), getCashPayment(), getCashlessPayment(), getEmployee(), getProductsInCheck());
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
}
