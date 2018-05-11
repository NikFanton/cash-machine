package ua.training.model.service;

import ua.training.controller.command.direction.Report;

import java.util.List;

public interface ReportService extends Service {
    List<Report> getAllReports();
}
