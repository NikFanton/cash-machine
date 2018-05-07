package ua.training.model.exception;

import ua.training.controller.constant.ExceptionMeassages;
import ua.training.controller.util.ResourceBundleHolder;

public class InvalidQuantityException extends Exception {
    @Override
    public String getMessage() {
        return ResourceBundleHolder.getParameter(ExceptionMeassages.INVALID_QUANTITY_EXCEPTION);
    }
}
