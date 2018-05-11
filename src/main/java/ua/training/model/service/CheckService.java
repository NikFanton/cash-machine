package ua.training.model.service;

import ua.training.model.entity.Check;

import java.util.List;

public interface CheckService extends Service {
    List<Check> getAllChecks();

    List<Check> getPartOffAllChecks(int numberOfChecks, int pageNumber);

    void saveCheck(Check check);

    void cancelCheck(Long id);

    Integer getNumberOfChecks();
}
