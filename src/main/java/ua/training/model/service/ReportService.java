package ua.training.model.service;

import ua.training.model.entity.Report;

import java.util.List;

public interface ReportService extends Service {
    List<Report> getAllReports();

    Report makeReport();

    void saveReport(Report report);
}
