package ua.training.model.dao.impl;

import ua.training.model.dao.ProductDAO;
import ua.training.model.dao.SQLQueries;
import ua.training.model.dao.factory.DAOFactory;
import ua.training.model.dao.mapper.ProductMapper;
import ua.training.model.entity.Product;

import java.sql.*;
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
            e.printStackTrace();
        }
    }

    @Override
    public Product getById(Long id) {
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
            throw new RuntimeException(e);
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
    public void close() throws Exception {
        connection.close();
    }

    public static void main(String[] args) {
        ProductDAO dao = DAOFactory.getDaoFactory().getProductDAO();
        dao.getAll().forEach(System.out::println);
    }
}
