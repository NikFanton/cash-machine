package ua.training.controller.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleHolder {
    private final static String RESOURCE_BUNDLE_BASE_NAME = "l10n";

    private ResourceBundle resourceBundle;

    public ResourceBundleHolder() {
        resourceBundle = ResourceBundle.getBundle(RESOURCE_BUNDLE_BASE_NAME, Locale.getDefault());
    }

    public ResourceBundleHolder(Locale locale) {
        setLocale(locale);
    }

    public void setLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(RESOURCE_BUNDLE_BASE_NAME, locale);
    }

    public String getParameter(String key) {
        return resourceBundle.getString(key);
    }
}
