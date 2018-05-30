package ua.training.constant;

public interface RegEx {
    String REGEX_NAME = "[1-9a-zа-щьюяґіїє `'\"\\-]{1,20}";
    String REGEX_PRICE = "^\\d+(\\.\\d{1,2})?$";
    String REGEX_QUANTITY_FOR_COUNTABLE = "^\\d{1,6}$";
    String REGEX_QUANTITY_FOR_UNCOUNTABLE = "^\\d+(\\.\\d{1,3})?$";
}
