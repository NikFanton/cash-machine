package ua.training.model.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ua.training.model.entity.enums.CheckManipulationType;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@Builder
public class CheckManipulation implements Entity<Long> {
    private Long id;
    private Employee employee;
    private LocalDateTime dateTime;
    private CheckManipulationType checkManipulationType;
    private Long checkId;
    private ProductInCheck product;

    public CheckManipulation() {
    }

    public CheckManipulation(Long id, Employee employee, LocalDateTime dateTime,
                             CheckManipulationType checkManipulationType,
                             Long checkId, ProductInCheck product) {
        this.id = id;
        this.employee = employee;
        this.dateTime = dateTime;
        this.checkManipulationType = checkManipulationType;
        this.checkId = checkId;
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CheckManipulation)) return false;
        CheckManipulation that = (CheckManipulation) o;
        return Objects.equals(getEmployee(), that.getEmployee()) &&
                Objects.equals(getDateTime(), that.getDateTime()) &&
                getCheckManipulationType() == that.getCheckManipulationType() &&
                Objects.equals(getCheckId(), that.getCheckId()) &&
                Objects.equals(getProduct(), that.getProduct());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployee(), getDateTime(), getCheckManipulationType(), getCheckId(), getProduct());
    }

    @Override
    public String toString() {
        return "CheckManipulation{" +
                "id=" + id +
                ", employee=" + employee +
                ", dateTime=" + dateTime +
                ", checkManipulationType=" + checkManipulationType +
                ", checkId=" + checkId +
                ", product=" + product +
                '}';
    }

    //    @Override
//    public String toString() {
//        return "CheckManipulation{" +
//                "id=" + id +
//                ", dateTime=" + dateTime +
//                ", checkManipulationType=" + checkManipulationType +
//                ", \nemployee=" + employee +
//                ", \ncheck=Check{" + ((check != null) ?
//                        "id=" + id +
//                        ", dateTime=" + check.getDateTime() +
//                        ", cashPayment=" + check.getCashPayment() +
//                        ", cashlessPayment=" + check.getCashlessPayment() +
//                        ", employee=" + check.getEmployee() +
//                        ", productsInCheck=" + check.getProductsInCheck() +
//                        ", checkType=" + check.getCheckType() +
//                        '}'
//                : "null") +
//                ", \nproduct=" + product +
//                '}';
//    }
}
