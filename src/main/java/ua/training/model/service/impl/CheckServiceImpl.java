package ua.training.model.service.impl;

import ua.training.model.dao.CheckDAO;
import ua.training.model.dao.factory.DAOFactory;
import ua.training.model.entity.Check;
import ua.training.model.exception.NoSuchResultFromDataBaseException;
import ua.training.model.service.CheckService;

import java.util.List;
import java.util.Optional;

public class CheckServiceImpl implements CheckService {
    @Override
    public List<Check> getAllChecks() {
        try (CheckDAO dao = daoFactory.getCheckDAO()) {
            return dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Check> getPartOffAllChecks(int numberOfChecks, int pageNumber) {
        try (CheckDAO dao = DAOFactory.getDaoFactory().getCheckDAO()) {
            return Optional.ofNullable(dao.getPartOfAll(numberOfChecks, pageNumber))
                    .orElseThrow(NoSuchResultFromDataBaseException::new);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
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

    @Override
    public Integer getNumberOfChecks() {
        try (CheckDAO dao = daoFactory.getCheckDAO()) {
            return Optional.ofNullable(dao.getNumberOfChecks()).orElseThrow(NoSuchResultFromDataBaseException::new);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
