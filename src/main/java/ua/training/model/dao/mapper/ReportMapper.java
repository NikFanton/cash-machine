package ua.training.model.dao.mapper;

import ua.training.model.entity.Report;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;

public class ReportMapper implements BaseMapper<Report> {

    @Override
    public Report extractFromResultSet(ResultSet resultSet, String prefix) throws SQLException {
        Long id = resultSet.getLong("id");
        BigInteger moneyPutInCashMachine = BigInteger.valueOf(resultSet.getInt(prefix + "money_put_in_cash_machine"));
        BigInteger seizedMoney = BigInteger.valueOf(resultSet.getInt(prefix + "seized_money"));
        BigInteger cashPayments = BigInteger.valueOf(resultSet.getInt(prefix + "cash_payments"));
        BigInteger cashlessPayments = BigInteger.valueOf(resultSet.getInt(prefix + "cashless_payments"));
        BigInteger canceledPayments = BigInteger.valueOf(resultSet.getInt(prefix + "canceled_payments"));
        LocalTime time = resultSet.getTime(prefix + "date_time").toLocalTime();
        LocalDate date = resultSet.getDate(prefix + "date_time").toLocalDate();
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        Integer canceledChecks = resultSet.getInt(prefix + "canceled_checks");
        return Report.getBuilder()
                .setId(id)
                .setMoneyPutInCashMachine(moneyPutInCashMachine)
                .setSeizedMoney(seizedMoney)
                .setCashPayments(cashPayments)
                .setCashlessPayments(cashlessPayments)
                .setCanceledPayments(canceledPayments)
                .setDateTime(dateTime)
                .setCanceledChecksCount(canceledChecks)
                .build();
    }

    @Override
    public Report makeUnique(Map<Long, Report> cache, Report report) {
        cache.putIfAbsent(report.getId(), report);
        return cache.get(report.getId());
    }
}
