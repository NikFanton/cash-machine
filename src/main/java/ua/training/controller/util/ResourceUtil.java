package ua.training.controller.util;

import javax.servlet.ServletRequest;

public class ResourceUtil {
    private static ResourceBundleHolder resourceBundleHolder = new ResourceBundleHolder();

    public static void setAttributesCreateCheckForm(ServletRequest servletRequest) {
        servletRequest.setAttribute("date_time", resourceBundleHolder.getParameter("msg"));
    }
}
