package ua.training.model.dao.mapper;

import ua.training.model.entity.Check;
import ua.training.model.entity.enums.CheckType;

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
        Long id = resultSet.getLong(prefix + "id");
        LocalTime time = resultSet.getTime(prefix + "date_time").toLocalTime();
        LocalDate date = resultSet.getDate(prefix + "date_time").toLocalDate();
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        BigInteger cashPayments = BigInteger.valueOf(resultSet.getInt(prefix + "cash_payments"));
        BigInteger cashlessPayments = BigInteger.valueOf(resultSet.getInt(prefix + "cashless_payments"));
        String typeName = resultSet.getString(prefix + "check_type");
        CheckType type = CheckType.valueOf(typeName);
        return new Check(id, dateTime, cashPayments, cashlessPayments, type);
    }

    @Override
    public Check makeUnique(Map<Long, Check> cache, Check check) {
        cache.putIfAbsent(check.getId(), check);
        return cache.get(check.getId());
    }
}
