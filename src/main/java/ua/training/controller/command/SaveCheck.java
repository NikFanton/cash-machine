package ua.training.controller.command;

import ua.training.controller.constant.CommandNames;
import ua.training.controller.constant.Pages;
import ua.training.controller.util.ProductsHolder;
import ua.training.model.entity.Check;
import ua.training.model.entity.Employee;
import ua.training.model.entity.ProductInCheck;
import ua.training.model.service.CheckService;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class SaveCheck implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        ProductsHolder.getProductsInCheck().forEach((aLong, product) -> System.out.println(product));
//        TODO Get cashier login to save him in check
//        TODO Get payments information
//        TODO Merge Product and ProductInCheck
        List<ProductInCheck> productsInCheck = new ArrayList<>();
        ProductsHolder.getList().forEach(product -> productsInCheck.add(new ProductInCheck(product)));
        CheckService service = new CheckService();
        Check check = Check.builder()
                            .setCashlessPayment(BigInteger.valueOf(0))
                            .setCashPayment(BigInteger.valueOf(0))
                            .setEmployee(Employee.builder().id(3L).build())
                            .setProductsInCheck(productsInCheck)
                            .build();
        service.saveCheck(check);
        ProductsHolder.clear();
        return Pages.REDIRECT + CommandNames.CREATE_CHECK_FORM;
    }
}
