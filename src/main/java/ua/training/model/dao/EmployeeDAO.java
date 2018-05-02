package ua.training.model.dao;

import ua.training.model.entity.User;

import java.util.List;

public interface UserDAO extends GenericDAO<User, Long> {
    User getByLogin(String login);
    User getByLoginAndPassword(String login, String password);
    List<String> getAllLogin();
}
