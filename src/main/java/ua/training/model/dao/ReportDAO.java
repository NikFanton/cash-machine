package ua.training.model.dao;

import ua.training.model.entity.Report;

public interface ReportDAO extends GenericDAO<Report, Long> {
    Report getLatestReport();
}
