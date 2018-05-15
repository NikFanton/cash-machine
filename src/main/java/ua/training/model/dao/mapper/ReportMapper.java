package ua.training.model.dao.mapper;

import ua.training.constant.database.ReportFieldsNames;
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
        Long id = resultSet.getLong(ReportFieldsNames.ID);
        BigInteger moneyPutInCashMachine = BigInteger.valueOf(resultSet.getInt(prefix + ReportFieldsNames.MONEY_PUT_IN_CASH_MACHINE));
        BigInteger seizedMoney = BigInteger.valueOf(resultSet.getInt(prefix + ReportFieldsNames.SEIZED_MONEY));
        BigInteger cashPayments = BigInteger.valueOf(resultSet.getInt(prefix + ReportFieldsNames.CASH_PAYMENTS));
        BigInteger cashlessPayments = BigInteger.valueOf(resultSet.getInt(prefix + ReportFieldsNames.CASHLESS_PAYMENTS));
        BigInteger canceledCashPayments = BigInteger.valueOf(resultSet.getInt(prefix + ReportFieldsNames.CANCELED_CASH_PAYMENTS));
        BigInteger canceledCashlessPayments = BigInteger.valueOf(resultSet.getInt(prefix + ReportFieldsNames.CANCELED_CASHLESS_PAYMENTS));
        LocalTime time = resultSet.getTime(prefix + ReportFieldsNames.DATE_TIME).toLocalTime();
        LocalDate date = resultSet.getDate(prefix + ReportFieldsNames.DATE_TIME).toLocalDate();
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        Integer canceledChecksCount = resultSet.getInt(prefix + ReportFieldsNames.CANCELED_CHECKS_COUNT);
        Integer checksCount = resultSet.getInt(prefix + ReportFieldsNames.CHECKS_COUNT);
        return Report.getBuilder()
                .setId(id)
                .setMoneyPutInCashMachine(moneyPutInCashMachine)
                .setSeizedMoney(seizedMoney)
                .setCashPayments(cashPayments)
                .setCashlessPayments(cashlessPayments)
                .setCanceledCashPayments(canceledCashPayments)
                .setCanceledCashlessPayments(canceledCashlessPayments)
                .setDateTime(dateTime)
                .setCanceledChecksCount(canceledChecksCount)
                .setChecksCount(checksCount)
                .build();
    }
}
