package ua.training.model.service.impl;

import ua.training.model.dao.CheckDAO;
import ua.training.model.dao.ReportDAO;
import ua.training.model.entity.Check;
import ua.training.model.entity.Report;
import ua.training.model.entity.enums.CheckType;
import ua.training.model.exception.NoSuchResultFromDataBaseException;
import ua.training.model.service.ReportService;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class ReportServiceImpl implements ReportService {

//    TODO Move DEFAULT_MONEY_IN_CASH_MACHINE from this class to constant interface
    private static final BigInteger DEFAULT_MONEY_IN_CASH_MACHINE = BigInteger.valueOf(2250);

    @Override
    public List<Report> getAllReports() {
        try (ReportDAO dao = daoFactory.getReportDAO()) {
            return Optional.ofNullable(dao.getAll()).orElseThrow(NoSuchResultFromDataBaseException::new);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Report makeReport() {
        try (ReportDAO reportDAO = daoFactory.getReportDAO();
             CheckDAO checkDAO = daoFactory.getCheckDAO()) {
            Report lastReport = Optional.ofNullable(reportDAO.getLatestReport())
                    .orElse(Report.getBuilder().setDateTime(LocalDateTime.MIN).build());
            List<Check> checks = Optional.ofNullable(checkDAO.getAllFromCertainDate(lastReport.getDateTime()))
                    .orElseThrow(NoSuchResultFromDataBaseException::new);
            return makeReport(checks);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void saveReport(Report report) {
        try (ReportDAO dao = daoFactory.getReportDAO()) {
            dao.add(report);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Report makeReport(List<Check> checks) {
        int numberOfCanceledChecks = 0;
        BigInteger totalCashPayments = BigInteger.ZERO;
        BigInteger totalCashlessPayments = BigInteger.ZERO;
        BigInteger totalCanceledCashPayments = BigInteger.ZERO;
        BigInteger totalCanceledCashlessPayments = BigInteger.ZERO;
        for (Check check : checks) {
            if (check.getCheckType() == CheckType.CANCELED) {
                numberOfCanceledChecks++;
                totalCanceledCashPayments = totalCanceledCashPayments.add(check.getCashPayment());
                totalCanceledCashlessPayments = totalCanceledCashlessPayments.add(check.getCashlessPayment());
            } else {
                totalCashPayments = totalCashPayments.add(check.getCashPayment());
                totalCashlessPayments = totalCashlessPayments.add(check.getCashlessPayment());
            }
        }
        return Report.getBuilder()
                .setMoneyPutInCashMachine(DEFAULT_MONEY_IN_CASH_MACHINE)
                .setSeizedMoney(((totalCanceledCashPayments.compareTo(DEFAULT_MONEY_IN_CASH_MACHINE) > 0)
                                    ? totalCashPayments.subtract(DEFAULT_MONEY_IN_CASH_MACHINE)
                                    : BigInteger.ZERO))
                .setCashPayments(totalCashPayments)
                .setCashlessPayments(totalCashlessPayments)
                .setCanceledCashPayments(totalCanceledCashPayments)
                .setCanceledCashlessPayments(totalCanceledCashlessPayments)
                .setCanceledChecksCount(numberOfCanceledChecks)
                .setChecksCount(checks.size())
                .build();
    }
}
