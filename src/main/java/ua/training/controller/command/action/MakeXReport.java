package ua.training.controller.command.action;

import ua.training.controller.command.Command;
import ua.training.constant.AttributeAndParameterNames;
import ua.training.constant.Locations;
import ua.training.constant.Pages;
import ua.training.model.entity.Report;
import ua.training.model.service.ReportService;

import javax.servlet.http.HttpServletRequest;

public class MakeXReport implements Command {
    private ReportService reportService;

    public MakeXReport(ReportService reportService) {
        this.reportService = reportService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        Report report = reportService.makeReport();
        request.setAttribute(AttributeAndParameterNames.X_REPORT, report);
        System.out.println(report);
        return Pages.X_REPORT;
    }
}
