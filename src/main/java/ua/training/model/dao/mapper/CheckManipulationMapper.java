package ua.training.model.dao.mapper;

import ua.training.model.entity.Check;
import ua.training.model.entity.CheckManipulation;
import ua.training.model.entity.Employee;
import ua.training.model.entity.ProductInCheck;
import ua.training.model.entity.enums.CheckManipulationType;
import ua.training.model.entity.enums.ProductInCheckType;
import ua.training.model.entity.enums.ProductType;
import ua.training.model.entity.enums.Role;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;

import static java.util.Objects.nonNull;

public class CheckManipulationMapper implements BaseMapper<CheckManipulation> {
    @Override
    public CheckManipulation extractFromResultSet(ResultSet resultSet, String prefix) throws SQLException {
        Employee employee = new Employee();
        Long id = resultSet.getLong(prefix + "id");
        String typeName = resultSet.getString(prefix + "check_manipulation_type");
        CheckManipulationType type = CheckManipulationType.valueOf(typeName);
        LocalTime time = resultSet.getTime(prefix + "date_time_of_operation").toLocalTime();
        LocalDate date = resultSet.getDate(prefix + "date_time_of_operation").toLocalDate();
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        employee.setId(resultSet.getLong(prefix + "e_id"));
        employee.setFirstName(resultSet.getString(prefix + "e_first_name"));
        employee.setLastName(resultSet.getString(prefix + "e_last_name"));
        employee.setRole(Role.valueOf(resultSet.getString(prefix + "e_role")));
        Long checkId = resultSet.getLong(prefix + "check_id");
        Long productId = resultSet.getLong(prefix + "product_id");
        ProductInCheck product = null;
        if (productId != 0) {
            String productName = resultSet.getString(prefix + "p_name");
            Double quantity = resultSet.getDouble(prefix + "p_quantity");
            Double price = resultSet.getDouble(prefix + "p_price");
            ProductType productType = ProductType.valueOf(resultSet.getString(prefix + "p_product_type"));
            String productInCheckTypeName = resultSet.getString(prefix + "p_product_in_check_type");
            ProductInCheckType productInCheckType = ProductInCheckType.valueOf(productInCheckTypeName);
            product = new ProductInCheck(productId, productName, quantity, price, productType, productInCheckType);
        }

        return CheckManipulation.builder()
                .id(id)
                .checkManipulationType(type)
                .dateTime(dateTime)
                .checkId(checkId)
                .employee(employee)
                .product(product)
                .build();
    }
}
