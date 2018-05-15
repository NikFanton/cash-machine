package ua.training.controller.command.direction;

import ua.training.controller.command.Command;
import ua.training.constant.AttributeAndParameterNames;
import ua.training.constant.Pages;
import ua.training.controller.util.ProductsHolder;

import javax.servlet.http.HttpServletRequest;

public class CreateCheckForm implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        System.out.println("loginAfter = [" + request.getSession().getAttribute(AttributeAndParameterNames.LOGIN)+ "]");
        request.setAttribute(AttributeAndParameterNames.PRODUCTS, ProductsHolder.getList());
        return Pages.CREATE_CHECK_FORM;
    }
}
