package ua.training.controller.command;

import ua.training.controller.constant.Pages;

import javax.servlet.http.HttpServletRequest;

public class FindProductPage implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return Pages.FIND_PRODUCT;
    }
}