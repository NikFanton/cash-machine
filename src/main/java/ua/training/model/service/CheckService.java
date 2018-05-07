package ua.training.model.service;

import ua.training.model.dao.factory.DAOFactory;
import ua.training.model.entity.Check;

import java.util.List;

public class CheckService implements Service {
    private DAOFactory daoFactory = DAOFactory.getDaoFactory();

    public List<Check> getAllChecks() {
        return daoFactory.getCheckDAO().getAll();
    }

    public void saveCheck(Check check) {
        daoFactory.getCheckDAO().add(check);
    }
}
