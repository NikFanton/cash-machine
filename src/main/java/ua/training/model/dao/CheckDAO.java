package ua.training.model.dao;

import ua.training.model.entity.Check;
import ua.training.model.entity.Product;

import java.time.LocalDateTime;
import java.util.List;

public interface CheckDAO extends GenericDAO<Check, Long> {
    default void addProductToCheck(Check check, Product product) {
        addProductToCheck(check.getId(), product);
    }

    void addProductToCheck(Long checkId, Product product);

    void markCheckAsCanceled(Long id);

    List<Check> getPartOfAll(int numberOfEntries, int partNumber);

    Integer getNumberOfChecks();

    List<Check> getAllFromCertainDate(LocalDateTime dateTime);
}
