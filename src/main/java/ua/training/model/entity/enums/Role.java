package ua.training.model.entity.enums;

import edu.emory.mathcs.backport.java.util.Arrays;
import ua.training.controller.constant.Locations;
import ua.training.controller.constant.Pages;

import java.util.List;

public enum Role {
    UNKNOWN(Pages.LOGIN, Arrays.asList(new String[]{
                    Locations.LOGIN,
                    Locations.LOGIN_FORM,
                    Locations.LOGOUT })),

    ADMIN(Locations.REDIRECT + Locations.EMPLOYEE_REGISTRATION_FORM, Arrays.asList(new String[]{
                    Locations.EMPLOYEE_REGISTRATION_FORM,
                    Locations.LOGOUT})),

    CASHIER(Locations.REDIRECT + Locations.CREATE_CHECK_FORM, Arrays.asList(new String[]{
                    Locations.CREATE_CHECK_FORM,
                    Locations.SAVE_CHECK,
                    Locations.ADD_PRODUCT,
                    Locations.CHECK_LIST,
                    Locations.FIND_PRODUCT_FORM,
                    Locations.FIND_PRODUCT,
                    Locations.REPORT,
                    Locations.LOGOUT})),

    SENIOR_CASHIER(Locations.REDIRECT + Locations.CREATE_CHECK_FORM, Arrays.asList(new String[]{
                    Locations.CREATE_CHECK_FORM,
                    Locations.SAVE_CHECK,
                    Locations.ADD_PRODUCT,
                    Locations.CHECK_LIST,
                    Locations.FIND_PRODUCT_FORM,
                    Locations.FIND_PRODUCT,
                    Locations.REPORT,
                    Locations.REMOVE_PRODUCT_FROM_CHECK,
                    Locations.CANCEL_CHECK,
                    Locations.LOGOUT})),

    MERCHANT(Pages.ADD_PRODUCT_TO_STORAGE,Arrays.asList(new String[]{
                    Locations.LOGOUT}));

    private String startPage;
    private List<String> accessibleActions;

    Role(String startPage, List<String> accessibleActions) {
        this.startPage = startPage;
        this.accessibleActions = accessibleActions;
    }

    public String getStartPage() {
        return startPage;
    }

    public void setStartPage(String startPage) {
        this.startPage = startPage;
    }

    public List<String> getAccessibleActions() {
        return accessibleActions;
    }

    public void setAccessibleActions(List<String> accessibleActions) {
        this.accessibleActions = accessibleActions;
    }
}
