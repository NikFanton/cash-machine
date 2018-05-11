package ua.training.controller.command.direction;

import ua.training.controller.command.Command;
import ua.training.controller.constant.Pages;

import javax.servlet.http.HttpServletRequest;

public class AdminInfo implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return Pages.ADMIN_INFO;
    }
}
