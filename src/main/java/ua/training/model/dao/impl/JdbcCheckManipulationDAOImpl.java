package ua.training.model.dao.impl;

import ua.training.constant.LogMessages;
import ua.training.model.dao.CheckManipulationDAO;
import ua.training.model.dao.SQLQueries;
import ua.training.model.dao.mapper.impl.CheckManipulationMapper;
import ua.training.model.entity.CheckManipulation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcCheckManipulationDAOImpl implements CheckManipulationDAO {
    private Connection connection;

    public JdbcCheckManipulationDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(CheckManipulation checkManipulation) {

    }

    @Override
    public CheckManipulation getById(Long id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.GET_CHECK_MANIPULATION_BY_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.first()) {
                CheckManipulationMapper manipulationMapper = new CheckManipulationMapper();
                return manipulationMapper.extractFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage() + " " + LogMessages.GET_CHECK_MANIPULATION_ERROR);
            throw new RuntimeException();
        }
        return null;
    }

    @Override
    public List<CheckManipulation> getAll() {
        return null;
    }

    @Override
    public void update(CheckManipulation checkManipulation) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void close() throws Exception {
        connection.close();
    }

    @Override
    public List<CheckManipulation> getCheckManipulationsBuCheckId(Long checkId) {
        return null;
    }
}
