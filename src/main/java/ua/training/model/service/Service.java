package ua.training.model.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.training.model.dao.factory.DAOFactory;

public interface Service {
    Logger logger = LogManager.getLogger(Service.class);
    DAOFactory daoFactory = DAOFactory.getDaoFactory();
}
