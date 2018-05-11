package ua.training.controller.command.direction;

import ua.training.controller.command.Command;
import ua.training.controller.constant.Pages;

import javax.servlet.http.HttpServletRequest;

public class MerchantInfo implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return Pages.MERCHANT_INFO;
    }
}
