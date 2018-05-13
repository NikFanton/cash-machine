package ua.training.controller.command.action;

import ua.training.controller.command.Command;
import ua.training.controller.constant.Locations;
import ua.training.model.service.ReportService;

import javax.servlet.http.HttpServletRequest;

public class MakeZReport implements Command {

    ReportService reportService;

    public MakeZReport(ReportService reportService) {
        this.reportService = reportService;
    }

    @Override
    public String execute(HttpServletRequest request) {
//        TODO make Z-Report
        return Locations.REDIRECT + Locations.REPORT;
    }
}
