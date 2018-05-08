package ua.training.model.entity.enums;

import ua.training.controller.constant.CommandNames;
import ua.training.controller.constant.Pages;

public enum Role {
    UNKNOWN(Pages.LOGIN),
    ADMIN(Pages.EMPLOYEE_REGISTRATION),
    CASHIER(CommandNames.CREATE_CHECK_FORM),
    SENIOR_CASHIER(CommandNames.CREATE_CHECK_FORM),
    MERCHANT(Pages.ADD_PRODUCT_TO_STORAGE);

    Role(String page) {
        this.page = page;
    }

    private String page;

    public String getPage() {
        return page;
    }

    public void setPage (String page) {
        this.page = page;
    }
}
