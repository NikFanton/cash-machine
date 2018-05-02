package ua.training.model.dao;

import ua.training.model.entity.Check;
import ua.training.model.entity.Product;

public interface CheckDAO extends GenericDAO<Check, Long> {
    default void addProductToCheck(Check check, Product product) {
        addProductToCheck(check.getId(), product);
    }

    void addProductToCheck(Long checkId, Product product);
}
