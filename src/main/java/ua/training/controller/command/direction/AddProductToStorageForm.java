package ua.training.controller.command.direction;

import ua.training.constant.Locations;
import ua.training.controller.annotation.CommandWithLocation;
import ua.training.controller.command.Command;
import ua.training.constant.Pages;

import javax.servlet.http.HttpServletRequest;

@CommandWithLocation(location = Locations.ADD_PRODUCT_TO_STORAGE_FORM)
public class AddProductToStorageForm implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return Pages.ADD_PRODUCT_TO_STORAGE_FORM;
    }
}
