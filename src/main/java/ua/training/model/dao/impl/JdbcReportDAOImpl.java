package ua.training.model.dao.impl;

import ua.training.model.dao.ReportDAO;
import ua.training.model.dao.SQLQueries;
import ua.training.model.dao.factory.DAOFactory;
import ua.training.model.dao.mapper.ReportMapper;
import ua.training.model.entity.Report;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlReportDAOImpl implements ReportDAO {
    private Connection connection;

    public MySqlReportDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(Report report) {

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
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Report report) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void close() throws Exception {
        connection.close();
    }

    @Override
    public Report getLatestReport() {
        try (ResultSet resultSet = connection.createStatement().executeQuery(SQLQueries.GET_LATEST_REPORT)) {
            ReportMapper mapper = new ReportMapper();
            if (resultSet.first()) {
                return mapper.extractFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        ReportDAO dao = DAOFactory.getDaoFactory().getReportDAO();
        System.out.println(dao.getLatestReport());
    }
}
