package ua.training.controller.command.action;

import ua.training.controller.command.Command;
import ua.training.controller.constant.Pages;

import javax.servlet.http.HttpServletRequest;

public class Report implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return Pages.REPORT;
    }
}