package ua.training.model.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.model.entity.Entity;

import java.util.List;

public interface GenericDAO <T extends Entity<Key>, Key> extends AutoCloseable {
//    TODO write JavaDOC here
    Logger logger = LogManager.getLogger(GenericDAO.class);

    void add(T t);
    T getById(Key id);
    List<T> getAll();
    void update(T t);
    void delete(Key id);
}
