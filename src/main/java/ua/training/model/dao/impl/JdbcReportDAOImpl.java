package ua.training.model.dao.impl;

import ua.training.constant.LogMessages;
import ua.training.model.dao.ReportDAO;
import ua.training.model.dao.SQLQueries;
import ua.training.model.dao.mapper.impl.ReportMapper;
import ua.training.model.entity.Report;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcReportDAOImpl implements ReportDAO {
    private Connection connection;

    public JdbcReportDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(Report report) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.ADD_REPORT)) {
            preparedStatement.setLong(1, report.getMoneyPutInCashMachine().longValue());
            preparedStatement.setLong(2, report.getSeizedMoney().longValue());
            preparedStatement.setLong(3, report.getCashPayments().longValue());
            preparedStatement.setLong(4, report.getCashlessPayments().longValue());
            preparedStatement.setLong(5, report.getCanceledCashPayments().longValue());
            preparedStatement.setLong(6, report.getCanceledCashlessPayments().longValue());
            preparedStatement.setInt(7, report.getCanceledChecksCount());
            preparedStatement.setInt(8, report.getChecksCount());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage() + " " + LogMessages.ADD_REPORT_ERROR);
            throw new RuntimeException();
        }
    }

    @Override
    public Report getById(Long id) {
        return null;
    }

    @Override
    public List<Report> getAll() {
        try(ResultSet resultSet = connection.createStatement().executeQuery(SQLQueries.GET_ALL_REPORTS)) {
            List<Report> reports = new ArrayList<>();
            ReportMapper mapper = new ReportMapper();
            while (resultSet.next()) {
                Report report = mapper.extractFromResultSet(resultSet);
                reports.add(report);
            }
            return reports;
        } catch (SQLException e) {
            logger.error(e.getMessage() + " " + LogMessages.GET_ALL_REPORTS_ERROR);
            throw new RuntimeException();
        }
    }

    @Override
    public void update(Report report) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Report getLatestReport() {
        try (ResultSet resultSet = connection.createStatement().executeQuery(SQLQueries.GET_LATEST_REPORT)) {
            ReportMapper mapper = new ReportMapper();
            if (resultSet.first()) {
                return mapper.extractFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage() + " " + LogMessages.GET_LATEST_REPORT_ERROR);
            throw new RuntimeException();
        }
        return null;
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }
}
