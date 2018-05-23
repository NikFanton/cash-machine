package ua.training.model.service.impl;

import ua.training.constant.GlobalConstants;
import ua.training.constant.LogMessages;
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
    @Override
    public List<Report> getAllReports() {
        try (ReportDAO dao = daoFactory.getReportDAO()) {
            return Optional.ofNullable(dao.getAll()).orElseThrow(NoSuchResultFromDataBaseException::new);
        } catch (Exception e) {
            logger.error(e.getMessage() + " " + LogMessages.GET_ALL_REPORTS_ERROR);
            return null;
        }
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
            logger.error(e.getMessage() + " " + LogMessages.MAKE_REPORT_ERROR);
            return null;
        }
    }

    @Override
    public void saveReport(Report report) {
        try (ReportDAO dao = daoFactory.getReportDAO()) {
            dao.add(report);
        } catch (Exception e) {
            logger.error(e.getMessage() + " " + LogMessages.ADD_REPORT_ERROR);
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
                .setMoneyPutInCashMachine(GlobalConstants.DEFAULT_MONEY_IN_CASH_MACHINE)
                .setSeizedMoney(((totalCanceledCashPayments.compareTo(GlobalConstants.DEFAULT_MONEY_IN_CASH_MACHINE) > 0)
                                    ? totalCashPayments.subtract(GlobalConstants.DEFAULT_MONEY_IN_CASH_MACHINE)
                                    : totalCashPayments))
                .setCashPayments(totalCashPayments)
                .setCashlessPayments(totalCashlessPayments)
                .setCanceledCashPayments(totalCanceledCashPayments)
                .setCanceledCashlessPayments(totalCanceledCashlessPayments)
                .setCanceledChecksCount(numberOfCanceledChecks)
                .setChecksCount(checks.size())
                .build();
    }
}
