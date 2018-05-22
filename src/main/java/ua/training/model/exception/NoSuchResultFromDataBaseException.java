package ua.training.model.exception;

import ua.training.constant.ExceptionMessages;

public class NoSuchResultFromDataBaseException extends Exception {
    @Override
    public String getMessage() {
        return super.getMessage() + " " + ExceptionMessages.DATA_FIND_ERROR;
    }
}
