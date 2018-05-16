package ua.training.model.dao.mapper.impl;

import ua.training.constant.database.CheckManipulationFieldsNames;
import ua.training.model.dao.mapper.BaseMapper;
import ua.training.model.entity.CheckManipulation;
import ua.training.model.entity.Employee;
import ua.training.model.entity.ProductInCheck;
import ua.training.model.entity.enums.CheckManipulationType;
import ua.training.model.entity.enums.ProductInCheckType;
import ua.training.model.entity.enums.ProductType;
import ua.training.model.entity.enums.Role;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class CheckManipulationMapper implements BaseMapper<CheckManipulation> {
    @Override
    public CheckManipulation extractFromResultSet(ResultSet resultSet, String prefix) throws SQLException {
        Employee employee = new Employee();
        Long id = resultSet.getLong(prefix + CheckManipulationFieldsNames.ID);
        String typeName = resultSet.getString(prefix + CheckManipulationFieldsNames.CHECK_MANIPULATION_TYPE);
        CheckManipulationType type = CheckManipulationType.valueOf(typeName);
        LocalTime time = resultSet.getTime(prefix + CheckManipulationFieldsNames.DATE_TIME_OF_OPERATION).toLocalTime();
        LocalDate date = resultSet.getDate(prefix + CheckManipulationFieldsNames.DATE_TIME_OF_OPERATION).toLocalDate();
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        employee.setId(resultSet.getLong(prefix + CheckManipulationFieldsNames.E_ID));
        employee.setFirstName(resultSet.getString(prefix + CheckManipulationFieldsNames.E_FIRST_NAME));
        employee.setLastName(resultSet.getString(prefix + CheckManipulationFieldsNames.E_LAST_NAME));
        employee.setRole(Role.valueOf(resultSet.getString(prefix + CheckManipulationFieldsNames.E_ROLE)));
        Long checkId = resultSet.getLong(prefix + CheckManipulationFieldsNames.CHECK_ID);
        Long productId = resultSet.getLong(prefix + CheckManipulationFieldsNames.PRODUCT_ID);
        ProductInCheck product = null;
        if (productId != 0) {
            String productName = resultSet.getString(prefix + CheckManipulationFieldsNames.P_NAME);
            Double quantity = resultSet.getDouble(prefix + CheckManipulationFieldsNames.P_QUANTITY);
            Double price = resultSet.getDouble(prefix + CheckManipulationFieldsNames.P_PRICE);
            ProductType productType = ProductType.valueOf(resultSet.getString(prefix + CheckManipulationFieldsNames.P_PRODUCT_TYPE));
            String productInCheckTypeName = resultSet.getString(prefix + CheckManipulationFieldsNames.P_PRODUCT_IN_CHECK_TYPE);
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
