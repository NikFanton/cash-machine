package ua.training.model.service.impl;

import ua.training.model.dao.CheckDAO;
import ua.training.model.dao.datasource.ConnectionPoolHolder;
import ua.training.model.dao.factory.DAOFactory;
import ua.training.model.entity.Check;
import ua.training.model.service.CheckService;
import ua.training.model.service.Service;

import java.math.BigInteger;
import java.sql.Connection;
import java.util.List;

public class CheckServiceImpl implements CheckService {
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

    @Override
    public void cancelCheck(Long id) {
        try (CheckDAO dao = daoFactory.getCheckDAO()) {
            dao.markCheckAsCanceled(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
