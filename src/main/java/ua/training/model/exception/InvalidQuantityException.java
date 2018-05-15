package ua.training.model.exception;

import ua.training.controller.util.ResourceBundleHolder;

public class InvalidQuantityException extends Exception {
    private String INVALID_QUANTITY_EXCEPTION = "exception.bad.quantity";

    @Override
    public String getMessage() {
        return ResourceBundleHolder.getParameter(INVALID_QUANTITY_EXCEPTION);
    }
}
