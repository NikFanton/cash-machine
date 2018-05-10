package ua.training.controller.command.direction;

import ua.training.controller.command.Command;
import ua.training.controller.constant.Pages;
import ua.training.controller.util.ProductsHolder;

import javax.servlet.http.HttpServletRequest;

public class CreateCheckForm implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute("products", ProductsHolder.getList());
        return Pages.CREATE_CHECK;
    }
}
