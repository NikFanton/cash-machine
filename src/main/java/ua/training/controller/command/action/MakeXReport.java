package ua.training.controller.command.action;

import ua.training.controller.command.Command;
import ua.training.controller.constant.Locations;

import javax.servlet.http.HttpServletRequest;

public class MakeXReport implements Command {
    @Override
    public String execute(HttpServletRequest request) {
//        TODO make X-Report
        return Locations.REDIRECT + Locations.REPORT;
    }
}
