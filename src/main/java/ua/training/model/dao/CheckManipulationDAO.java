package ua.training.model.dao;

import ua.training.model.entity.CheckManipulation;

import java.util.List;

public interface CheckManipulationDAO extends GenericDAO<CheckManipulation, Long> {
    List<CheckManipulation> getCheckManipulationsBuCheckId(Long checkId);
}
