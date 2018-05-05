package ua.training.controller.command;

import ua.training.controller.constant.Templates;

import javax.servlet.http.HttpServletRequest;

public class CreateCheck implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return Templates.REDIRECT + Templates.CREATE_CHECK;
    }
}
