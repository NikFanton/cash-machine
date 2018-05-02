package ua.training.model.dao.impl;

import com.sun.xml.internal.bind.v2.TODO;
import ua.training.model.dao.CheckManipulationDAO;
import ua.training.model.dao.SQLQueries;
import ua.training.model.dao.factory.DAOFactory;
import ua.training.model.dao.mapper.*;
import ua.training.model.entity.*;

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
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.first()) {
                    return extractCheckManipulation(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private CheckManipulation extractCheckManipulation(ResultSet resultSet) throws SQLException {
        CheckManipulationMapper manipulationMapper = new CheckManipulationMapper();
        EmployeeMapper employeeMapper = new EmployeeMapper();
        CheckMapper checkMapper = new CheckMapper();
        CheckManipulation checkManipulation = manipulationMapper.extractFromResultSet(resultSet);
        Employee employee = employeeMapper.extractFromResultSetWithoutAccount(resultSet, "e_");
        Employee cashier = employeeMapper.extractFromResultSetWithoutAccount(resultSet, "c_");
        Check check = checkMapper.extractFromResultSet(resultSet, "check_");
        check.setEmployee(cashier);
        ProductInCheck product = extractProductInCheckIfExist(resultSet, check.getId());
        checkManipulation.setEmployee(employee);
        checkManipulation.setCheck(check);
        checkManipulation.setProduct(product);
        return checkManipulation;
    }

    private ProductInCheck extractProductInCheckIfExist(ResultSet resultSet, Long checkId) throws SQLException {
        Long productId = resultSet.getLong("product_id");
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueries.GET_PRODUCT_IN_CHECK_BY_ID)) {
            preparedStatement.setLong(1, checkId);
            preparedStatement.setLong(2, productId);
            try (ResultSet productResultSet = preparedStatement.executeQuery()) {
                if (productResultSet.first()) {
                    ProductInCheckMapper mapper = new ProductInCheckMapper();
                    return mapper.extractFromResultSet(productResultSet);
                }
            }
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

    public static void main(String[] args) {
        CheckManipulationDAO dao = DAOFactory.getDaoFactory().getCheckManipulationDAO();
        System.out.println(dao.getById(1L));
    }
}
