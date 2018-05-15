package ua.training.controller.command.action;

import ua.training.controller.command.Command;
import ua.training.constant.AttributeAndParameterNames;
import ua.training.constant.Locations;
import ua.training.controller.util.PaymentType;
import ua.training.controller.util.ProductUtil;
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
import java.util.List;

public class CreateCheck implements Command {
    private CheckService checkService;
    private EmployeeService employeeService;

    public CreateCheck(CheckService checkService, EmployeeService employeeService) {
        this.checkService = checkService;
        this.employeeService = employeeService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        if (ProductsHolder.notIsEmpty()) {
            HttpSession session = request.getSession();
            List<ProductInCheck> productsInCheck = ProductUtil.getListOfProducts();
            Employee employee = null;
            try {
                String login = String.valueOf(session.getServletContext().getAttribute(AttributeAndParameterNames.LOGIN));
                employee = employeeService.getEmployee(login);
            } catch (NoSuchResultFromDataBaseException e) {
                e.printStackTrace();
            }
            PaymentType paymentType = PaymentType.valueOf(request.getParameter(AttributeAndParameterNames.PAYMENT_TYPE));
            BigInteger total = BigInteger.ZERO;
            for (ProductInCheck product : productsInCheck) {
                total = total.add(BigInteger.valueOf((long) (product.getPrice() * product.getQuantity())));
            }
            checkService.saveCheck(Check.builder()
                    .setCashPayment(((paymentType == PaymentType.CASH)) ? total : BigInteger.ZERO)
                    .setCashlessPayment(((paymentType == PaymentType.CASHLESS)) ? total : BigInteger.ZERO)
                    .setEmployee(employee)
                    .setProductsInCheck(productsInCheck)
                    .setCheckType((ProductsHolder.isAltered()) ? CheckType.ALTERED : CheckType.NORMAL)
                    .build());
            ProductsHolder.clear();
        }
        return Locations.REDIRECT + Locations.CREATE_CHECK_FORM;
    }
}
