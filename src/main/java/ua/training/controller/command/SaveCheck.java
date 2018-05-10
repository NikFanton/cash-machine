package ua.training.controller.command;

import ua.training.controller.constant.Locations;
import ua.training.controller.constant.Pages;
import ua.training.controller.util.ProductsHolder;
import ua.training.model.entity.Check;
import ua.training.model.entity.Employee;
import ua.training.model.entity.ProductInCheck;
import ua.training.model.entity.enums.CheckType;
import ua.training.model.exception.NoSuchResultFromDataBaseException;
import ua.training.model.service.CheckService;
import ua.training.model.service.EmployeeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class SaveCheck implements Command {
    private CheckService checkService;
    private EmployeeService employeeService;

    public SaveCheck(CheckService checkService, EmployeeService employeeService) {
        this.checkService = checkService;
        this.employeeService = employeeService;
    }

    @Override
    public String execute(HttpServletRequest request) {
//        TODO Get payments information
        HttpSession session = request.getSession();
        List<ProductInCheck> productsInCheck = getListOfProducts();
        productsInCheck.forEach(System.out::println);
        Employee employee = null;
        try {
            employee = employeeService.getEmployee(String.valueOf(session.getServletContext().getAttribute("login")));
        } catch (NoSuchResultFromDataBaseException e) {
            e.printStackTrace();
        }
        checkService.saveCheck(Check.builder()
                                    .setCashlessPayment(BigInteger.valueOf(0))
                                    .setCashPayment(BigInteger.valueOf(0))
                                    .setEmployee(employee)
                                    .setProductsInCheck(productsInCheck)
                                    .setCheckType((ProductsHolder.IsAltered()) ? CheckType.ALTERED : CheckType.NORMAL)
                                    .build());
        ProductsHolder.clear();
        return Locations.REDIRECT + Locations.CREATE_CHECK_FORM;
    }

    private List<ProductInCheck> getListOfProducts() {
//        TODO Merge Product and ProductInCheck
        List<ProductInCheck> productsInCheck = new ArrayList<>();
        ProductsHolder.getList().forEach(product -> productsInCheck.add(new ProductInCheck(product)));
        return productsInCheck;
    }
}
