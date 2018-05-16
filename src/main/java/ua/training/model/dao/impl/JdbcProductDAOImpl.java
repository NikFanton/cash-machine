package ua.training.model.dao.impl;

import ua.training.constant.LogMessages;
import ua.training.model.dao.ProductDAO;
import ua.training.model.dao.SQLQueries;
import ua.training.model.dao.mapper.impl.ProductMapper;
import ua.training.model.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcProductDAOImpl implements ProductDAO {
    private Connection connection;

    public JdbcProductDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(Product product) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.ADD_PRODUCT)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getQuantity());
            preparedStatement.setInt(3, product.getPrice().intValue());
            preparedStatement.setString(4, product.getProductType().name());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage() + " " + LogMessages.CREATE_PRODUCT_ERROR);
            throw new RuntimeException();
        }
    }

    @Override
    public Product getById(Long id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.GET_PRODUCT_BY_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            ProductMapper mapper = new ProductMapper();
            if (resultSet.first()) {
                return mapper.extractFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage() + " " + LogMessages.GET_PRODUCT_BY_ID_ERROR);
            throw new RuntimeException();
        }
        return null;
    }

    @Override
    public List<Product> getAll() {
        List<Product> users = new ArrayList<>();
        try (ResultSet resultSet = connection.createStatement().executeQuery(SQLQueries.GET_ALL_PRODUCTS)) {
            ProductMapper mapper = new ProductMapper();
            while (resultSet.next()) {
                users.add(mapper.extractFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            logger.error(e.getMessage() + " " + LogMessages.GET_ALL_PRODUCTS_ERROR);
            throw new RuntimeException();
        }
        return users;
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Product> getProductsByName(String name) {
        List<Product> users = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.GET_PRODUCTS_BY_NAME)) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            ProductMapper mapper = new ProductMapper();
            while (resultSet.next()) {
                users.add(mapper.extractFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            logger.error(e.getMessage() + " " + LogMessages.GET_PRODUCTS_BY_NAME_ERROR);
            throw new RuntimeException();
        }
        return users;
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }
}
