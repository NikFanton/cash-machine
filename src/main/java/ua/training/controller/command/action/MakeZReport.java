package ua.training.controller.command.action;

import ua.training.controller.command.Command;
import ua.training.controller.constant.Locations;
import ua.training.model.service.ReportService;

import javax.servlet.http.HttpServletRequest;

public class MakeReport implements Command {

    ReportService reportService;

    public MakeReport(ReportService reportService) {
        this.reportService = reportService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        return Locations.REDIRECT + Locations.REPORT;
    }
}
