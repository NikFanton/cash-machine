package ua.training.model.dao.mapper.impl;

import ua.training.constant.database.CheckFieldsNames;
import ua.training.model.dao.mapper.BaseMapper;
import ua.training.model.entity.Check;
import ua.training.model.entity.Employee;
import ua.training.model.entity.enums.CheckType;
import ua.training.model.entity.enums.Role;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class CheckMapper implements BaseMapper<Check> {
    @Override
    public Check extractFromResultSet(ResultSet resultSet, String prefix) throws SQLException {
        Employee employee = new Employee();
        Long id = resultSet.getLong(prefix + CheckFieldsNames.ID);
        LocalTime time = resultSet.getTime(prefix + CheckFieldsNames.DATE_TIME).toLocalTime();
        LocalDate date = resultSet.getDate(prefix + CheckFieldsNames.DATE_TIME).toLocalDate();
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        BigInteger cashPayment = BigInteger.valueOf(resultSet.getInt(prefix + CheckFieldsNames.CASH_PAYMENTS));
        BigInteger cashlessPayment = BigInteger.valueOf(resultSet.getInt(prefix + CheckFieldsNames.CASHLESS_PAYMENTS));
        String typeName = resultSet.getString(prefix + CheckFieldsNames.CHECK_TYPE);
        employee.setId(resultSet.getLong(prefix + CheckFieldsNames.E_ID));
        employee.setFirstName(resultSet.getString(prefix + CheckFieldsNames.E_FIRST_NAME));
        employee.setLastName(resultSet.getString(prefix + CheckFieldsNames.E_LAST_NAME));
        employee.setRole(Role.valueOf(resultSet.getString(prefix + CheckFieldsNames.E_ROLE)));
        CheckType type = CheckType.valueOf(typeName);
        return Check.builder()
                .setId(id)
                .setDateTime(dateTime)
                .setCashPayment(cashPayment)
                .setCashlessPayment(cashlessPayment)
                .setEmployee(employee)
                .setCheckType(type)
                .build();
    }
}
