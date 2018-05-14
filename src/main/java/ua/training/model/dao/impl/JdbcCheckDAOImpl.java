package ua.training.model.dao.impl;

import ua.training.model.dao.CheckDAO;
import ua.training.model.dao.SQLQueries;
import ua.training.model.dao.factory.DAOFactory;
import ua.training.model.dao.mapper.CheckMapper;
import ua.training.model.dao.mapper.ProductInCheckMapper;
import ua.training.model.entity.Check;
import ua.training.model.entity.Employee;
import ua.training.model.entity.Product;
import ua.training.model.entity.ProductInCheck;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;

public class JdbcCheckDAOImpl implements CheckDAO {
    private Connection connection;

    public JdbcCheckDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(Check check) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.ADD_CHECK);
             PreparedStatement addProductToCheckStatement = connection.prepareStatement(SQLQueries.ADD_PRODUCT_TO_LATEST_CHECK)) {
            connection.setAutoCommit(false);
            preparedStatement.setInt(1, check.getCashPayment().intValue());
            preparedStatement.setInt(2, check.getCashlessPayment().intValue());
            preparedStatement.setLong(3, check.getEmployee().getId());
            preparedStatement.setString(4, String.valueOf(check.getCheckType()));
            preparedStatement.executeUpdate();
            for (ProductInCheck product : check.getProductsInCheck()) {
                addProductToCheckStatement.setLong(1, product.getId());
                addProductToCheckStatement.setDouble(2, product.getQuantity());
                addProductToCheckStatement.setInt(3, product.getPrice().intValue());
                addProductToCheckStatement.executeUpdate();
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Check getById(Long id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.GET_CHECK_BY_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Map<Long, Check> checks = extractCheckWithProducts(resultSet);
            return checks.get(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     *
     * @param resultSet
     * @return map of checks with products
     * @throws SQLException
     */
    private Map<Long, Check> extractCheckWithProducts(ResultSet resultSet) throws SQLException {
        Map<Long, Check> checks = new HashMap<>();
        CheckMapper checkMapper = new CheckMapper();
        ProductInCheckMapper productMapper = new ProductInCheckMapper();
        while (resultSet.next()) {
            Check check = checkMapper.extractFromResultSet(resultSet);
            check = checkMapper.makeUnique(checks, check);
            ProductInCheck productInCheck = productMapper.extractFromResultSet(resultSet, "p_");
            check.getProductsInCheck().add(productInCheck);
        }
        return checks;
    }

    @Override
    public List<Check> getAll() {
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQLQueries.GET_ALL_CHECKS)) {
            List<Check> result = new ArrayList<>();
            Map<Long, Check> checks = extractCheckWithProducts(resultSet);
            checks.keySet().forEach(key -> result.add(checks.get(key)));
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Check check) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.UPDATE_CHECK)) {
            preparedStatement.setInt(1, check.getCashPayment().intValue());
            preparedStatement.setInt(2, check.getCashlessPayment().intValue());
            preparedStatement.setLong(3, check.getEmployee().getId());
            preparedStatement.setString(4, String.valueOf(check.getCheckType()));
            preparedStatement.setLong(5, check.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.DELETE_CHECK)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addProductToCheck(Long checkId, Product product) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.ADD_PRODUCT_TO_CHECK)) {
            preparedStatement.setLong(1, checkId);
            preparedStatement.setLong(2, product.getId());
            preparedStatement.setDouble(3, product.getQuantity());
            preparedStatement.setInt(4, product.getPrice().intValue());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    @Override
    public void markCheckAsCanceled(Long id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.CANCEL_CHECK)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Check> getPartOfAll(int numberOfEntries, int partNumber) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.GET_PART_OF_ALL_CHECKS)) {
            preparedStatement.setInt(1, numberOfEntries);
            preparedStatement.setInt(2, numberOfEntries * (partNumber - 1));
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Check> result = new ArrayList<>();
            Map<Long, Check> checks = extractCheckWithProducts(resultSet);
            checks.keySet().forEach(key -> result.add(checks.get(key)));
            result.sort(Comparator.comparingLong(Check::getId));
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer getNumberOfChecks() {
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQLQueries.GET_NUMBER_OF_CHECKS)) {
            if (resultSet.first()) {
                return resultSet.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Check> getAllFromCertainDate(LocalDateTime dateTime) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.GET_ALL_CHECKS_FROM_CERTAIN_DATE)) {
            preparedStatement.setString(1, String.valueOf(dateTime));
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Check> result = new ArrayList<>();
            Map<Long, Check> checks = extractCheckWithProducts(resultSet);
            checks.keySet().forEach(key -> result.add(checks.get(key)));
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void close(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CheckDAO dao = DAOFactory.getDaoFactory().getCheckDAO();
        Employee employee = new Employee();
        employee.setId(5L);
        List<ProductInCheck> products = new ArrayList<>();
        ProductInCheck product1 = new ProductInCheck();
        ProductInCheck product2 = new ProductInCheck();
        ProductInCheck product3 = new ProductInCheck();
        product1.setId(3L);
        product2.setId(9L);
        product3.setId(5L);
        product1.setPrice(20.);
        product2.setPrice(20.);
        product3.setPrice(20.);
        products.add(product1);
        products.add(product2);
        products.add(product3);

//        Check check = new Check(BigInteger.valueOf(0), BigInteger.valueOf(20000), employee, products);
//        dao.add(check);
//        Check check2 = dao.getById(1L);
//        dao.addProductToCheck(check2.getId(), product2);
//        dao.getAll().forEach(System.out::println);
        dao.getPartOfAll(9, 1).forEach(System.out::println);
    }
}
