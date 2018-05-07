package ua.training.model.dao.mapper;

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
import java.util.Map;

public class CheckMapper implements BaseMapper<Check> {
    @Override
    public Check extractFromResultSet(ResultSet resultSet) throws SQLException {
        return extractFromResultSet(resultSet, "");
    }

    @Override
    public Check extractFromResultSet(ResultSet resultSet, String prefix) throws SQLException {
        Employee employee = new Employee();
        Long id = resultSet.getLong(prefix + "id");
        LocalTime time = resultSet.getTime(prefix + "date_time").toLocalTime();
        LocalDate date = resultSet.getDate(prefix + "date_time").toLocalDate();
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        BigInteger cashPayment = BigInteger.valueOf(resultSet.getInt(prefix + "cash_payments"));
        BigInteger cashlessPayment = BigInteger.valueOf(resultSet.getInt(prefix + "cashless_payments"));
        String typeName = resultSet.getString(prefix + "check_type");
        employee.setId(resultSet.getLong(prefix + "e_id"));
        employee.setFirstName(resultSet.getString(prefix + "e_first_name"));
        employee.setLastName(resultSet.getString(prefix + "e_last_name"));
        employee.setRole(Role.valueOf(resultSet.getString(prefix + "e_role")));
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
