package ua.training.model.service.impl;

import ua.training.model.dao.CheckDAO;
import ua.training.model.dao.datasource.ConnectionPoolHolder;
import ua.training.model.dao.factory.DAOFactory;
import ua.training.model.entity.Check;
import ua.training.model.service.Service;

import java.math.BigInteger;
import java.sql.Connection;
import java.util.List;

public class CheckService implements Service {
    public List<Check> getAllChecks() {
        try (CheckDAO dao = daoFactory.getCheckDAO()) {
            return dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveCheck(Check check) {
        try (CheckDAO dao = daoFactory.getCheckDAO()) {
            dao.add(check);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
