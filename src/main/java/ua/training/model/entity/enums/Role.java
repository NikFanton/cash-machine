package ua.training.model.entity.enums;

import edu.emory.mathcs.backport.java.util.Arrays;
import ua.training.constant.Locations;

import java.util.List;

public enum Role {
    UNKNOWN(Locations.REDIRECT + Locations.LOGIN_FORM, Arrays.asList(new String[]{
                    Locations.LOGIN,
                    Locations.LOGIN_FORM,
                    Locations.LOGOUT })),

    ADMIN(Locations.REDIRECT + Locations.EMPLOYEE_REGISTRATION_FORM, Arrays.asList(new String[]{
                    Locations.EMPLOYEE_REGISTRATION_FORM,
                    Locations.EMPLOYEE_REGISTRATION,
                    Locations.ADMIN_INFO,
                    Locations.LOGOUT})),

    CASHIER(Locations.REDIRECT + Locations.CREATE_CHECK_FORM, Arrays.asList(new String[]{
                    Locations.CREATE_CHECK_FORM,
                    Locations.CREATE_CHECK,
                    Locations.ADD_PRODUCT,
                    Locations.CHECK_LIST,
                    Locations.FIND_PRODUCT_FORM,
                    Locations.FIND_PRODUCT,
                    Locations.LOGOUT})),

    SENIOR_CASHIER(Locations.REDIRECT + Locations.CREATE_CHECK_FORM, Arrays.asList(new String[]{
                    Locations.CREATE_CHECK_FORM,
                    Locations.CREATE_CHECK,
                    Locations.ADD_PRODUCT,
                    Locations.CHECK_LIST,
                    Locations.FIND_PRODUCT_FORM,
                    Locations.FIND_PRODUCT,
                    Locations.REPORT,
                    Locations.MAKE_X_REPORT,
                    Locations.MAKE_Z_REPORT,
                    Locations.REMOVE_PRODUCT_FROM_CHECK,
                    Locations.CANCEL_CHECK,
                    Locations.LOGOUT})),

    MERCHANT(Locations.REDIRECT + Locations.ADD_PRODUCT_TO_STORAGE_FORM,Arrays.asList(new String[]{
                    Locations.ADD_PRODUCT_TO_STORAGE_FORM,
                    Locations.ADD_PRODUCT_TO_STORAGE,
                    Locations.MERCHANT_INFO,
                    Locations.LOGOUT}));

    private String startPage;
    private List<String> accessibleLocations;

    Role(String startPage, List<String> accessibleLocations) {
        this.startPage = startPage;
        this.accessibleLocations = accessibleLocations;
    }

    public String getStartPage() {
        return startPage;
    }

    public List<String> getAccessibleLocations() {
        return accessibleLocations;
    }
}
