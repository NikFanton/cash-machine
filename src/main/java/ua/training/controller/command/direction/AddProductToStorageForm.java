package ua.training.controller.command.direction;

import ua.training.controller.command.Command;
import ua.training.controller.constant.Pages;

import javax.servlet.http.HttpServletRequest;

public class AddProductToStorageForm implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return Pages.ADD_PRODUCT_TO_STORAGE_FORM;
    }
}
