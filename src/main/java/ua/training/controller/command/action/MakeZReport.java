package ua.training.controller.command.action;

import ua.training.controller.command.Command;
import ua.training.constant.Locations;
import ua.training.model.entity.Report;
import ua.training.model.service.ReportService;

import javax.servlet.http.HttpServletRequest;

public class MakeZReport implements Command {

    private ReportService reportService;

    public MakeZReport(ReportService reportService) {
        this.reportService = reportService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        Report report = reportService.makeReport();
        reportService.saveReport(report);
        return Locations.REDIRECT + Locations.REPORT;
    }
}
