package ua.training.controller.command.direction;

import ua.training.controller.command.Command;
import ua.training.constant.AttributeAndParameterNames;
import ua.training.constant.Pages;
import ua.training.model.entity.Report;
import ua.training.model.service.ReportService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class MakeReport implements Command {

    private ReportService reportService;

    public MakeReport(ReportService reportService) {
        this.reportService = reportService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        List<Report> reports = reportService.getAllReports();
        request.setAttribute(AttributeAndParameterNames.REPORTS, reports);
        return Pages.MAKE_REPORT;
    }
}
