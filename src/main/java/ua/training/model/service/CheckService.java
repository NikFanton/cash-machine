package ua.training.model.service;

import ua.training.model.entity.Check;

import java.util.List;

public interface CheckService extends Service {
    List<Check> getAllChecks();

    void saveCheck(Check check);

    void cancelCheck(Long id);
}
