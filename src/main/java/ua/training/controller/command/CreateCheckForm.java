package ua.training.controller.command;

import ua.training.controller.constant.Pages;
import ua.training.model.entity.Product;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CreateCheck implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        System.out.println("AFTER REDIRECT");
        Object products = request.getAttribute("products");
        System.out.println(products);
        return Pages.CREATE_CHECK;
    }
}
