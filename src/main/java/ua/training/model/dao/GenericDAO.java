package ua.training.model.dao;

import ua.training.model.entity.Entity;

import java.util.List;

public interface GenericDAO <T extends Entity<Key>, Key> extends AutoCloseable {
    void add(T t);
    T getById(Key id);
    List<T> getAll();
    void update(T t);
    void delete(Key id);
}
