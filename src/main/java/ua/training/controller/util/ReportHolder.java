package ua.training.controller.util;

import ua.training.model.entity.Report;

public class ReportHolder {
    private static Report report;

    public static Report getReport() {
        return report;
    }

    public static void setReport(Report report) {
        ReportHolder.report = report;
    }
}
