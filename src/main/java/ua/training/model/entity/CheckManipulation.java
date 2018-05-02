package ua.training.model.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ua.training.model.entity.enums.CheckManipulationType;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class CheckManipulation {
    private Long id;
    private Employee employee;
    private LocalDateTime dateTime;
    private CheckManipulationType checkManipulationType;
    private Check check;
    private ProductInCheck product;

    public CheckManipulation() {
    }

    public CheckManipulation(Long id, LocalDateTime dateTime, CheckManipulationType checkManipulationType) {
        this.id = id;
        this.dateTime = dateTime;
        this.checkManipulationType = checkManipulationType;
    }

    public CheckManipulation(Employee employee, LocalDateTime dateTime, CheckManipulationType checkManipulationType, Check check, ProductInCheck product) {
        this.employee = employee;
        this.dateTime = dateTime;
        this.checkManipulationType = checkManipulationType;
        this.check = check;
        this.product = product;
    }

    public CheckManipulation(Long id, Employee employee, LocalDateTime dateTime, CheckManipulationType checkManipulationType, Check check, ProductInCheck product) {
        this.id = id;
        this.employee = employee;
        this.dateTime = dateTime;
        this.checkManipulationType = checkManipulationType;
        this.check = check;
        this.product = product;
    }

    @Override
    public String toString() {
        return "CheckManipulation{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", checkManipulationType=" + checkManipulationType +
                ", \nemployee=" + employee +
                ", \ncheck=Check{" + ((check != null) ?
                        "id=" + id +
                        ", dateTime=" + check.getDateTime() +
                        ", cashPayment=" + check.getCashPayment() +
                        ", cashlessPayment=" + check.getCashlessPayment() +
                        ", employee=" + check.getEmployee() +
                        ", productsInCheck=" + check.getProductsInCheck() +
                        ", checkType=" + check.getCheckType() +
                        '}'
                : "null") +
                ", \nproduct=" + product +
                '}';
    }
}
