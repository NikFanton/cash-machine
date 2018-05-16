package ua.training.model.dao;

public interface SQLQueries {

    String GET_ALL_PRODUCTS = "SELECT * FROM product";

    String GET_ALL_EMPLOYEES = "SELECT * FROM employee";

    String GET_ALL_CHECKS = "SELECT  c.id, c.date_time, c.cash_payments, c.cashless_payments, c.check_type,\n" +
            "  a.quantity p_quantity, a.product_in_check_type p_product_in_check_type, a.price p_price,\n" +
            "  p.id p_id, p.name p_name, p.product_type p_product_type,\n" +
            "  e.id e_id, e.first_name e_first_name, e.last_name e_last_name, e.role e_role\n" +
            "FROM `check` c\n" +
            "  LEFT JOIN check_product a ON c.`id` = a.`check_id`\n" +
            "  LEFT JOIN product p ON `product_id` = p.id\n" +
            "  LEFT JOIN employee e ON employee_id = e.id\n" +
            "ORDER BY c.id DESC";

    String GET_ALL_CHECKS_FROM_CERTAIN_DATE = "SELECT  c.id, c.date_time, c.cash_payments, c.cashless_payments, c.check_type,\n" +
            "  a.quantity p_quantity, a.product_in_check_type p_product_in_check_type, a.price p_price,\n" +
            "  p.id p_id, p.name p_name, p.product_type p_product_type,\n" +
            "  e.id e_id, e.first_name e_first_name, e.last_name e_last_name, e.role e_role\n" +
            "FROM `check` c\n" +
            "  LEFT JOIN check_product a ON c.`id` = a.`check_id`\n" +
            "  LEFT JOIN product p ON `product_id` = p.id\n" +
            "  LEFT JOIN employee e ON employee_id = e.id\n" +
            "WHERE c.date_time > ?";

    String GET_PART_OF_ALL_CHECKS = "SELECT c.id, c.date_time, c.cash_payments, c.cashless_payments, c.check_type,\n" +
            "  a.quantity p_quantity, a.product_in_check_type p_product_in_check_type, a.price p_price,\n" +
            "  p.id p_id, p.name p_name, p.product_type p_product_type,\n" +
            "  e.id e_id, e.first_name e_first_name, e.last_name e_last_name, e.role e_role\n" +
            "FROM (SELECT * FROM `check` ORDER BY `check`.id DESC LIMIT ? OFFSET ?) c\n" +
            "  LEFT JOIN check_product a ON c.`id` = a.`check_id`\n" +
            "  LEFT JOIN product p ON `product_id` = p.id\n" +
            "  LEFT JOIN employee e ON employee_id = e.id;";

    String GET_NUMBER_OF_CHECKS = "SELECT count(id) count FROM `check`";

    String GET_ALL_REPORTS = "SELECT * FROM z_report ORDER BY id DESC";

    String GET_PRODUCT_BY_ID = "SELECT * FROM product WHERE id = ?";

    String GET_PRODUCT_IN_CHECK_BY_ID = "SELECT cp.quantity, cp.price, cp.product_in_check_type,\n" +
            "  p.id, p.product_type, p.name\n" +
            "FROM check_product cp\n" +
            "LEFT JOIN product p ON cp.product_id = p.id\n" +
            "WHERE check_id = ? AND product_id = ?";

    String GET_PRODUCTS_BY_NAME = "SELECT * FROM product WHERE name LIKE concat('%', ?, '%')";

    String GET_EMPLOYEE_BY_LOGIN = "SELECT * FROM employee WHERE login = ?";

    String GET_EMPLOYEE_BY_LOGIN_AND_PASSWORD = "SELECT * FROM employee WHERE login = ? AND password = ?";

    String GET_CHECK_MANIPULATION_BY_ID = "SELECT cmh.id, cmh.date_time_of_operation, cmh.check_manipulation_type, cmh.check_id, cmh.product_id,\n" +
            "   e.id e_id, e.first_name e_first_name, e.last_name e_last_name, e.role e_role,\n" +
            "   cp.quantity p_quantity, cp.product_in_check_type p_product_in_check_type, cp.price p_price,\n" +
            "   p.id p_id, p.name p_name, p.product_type p_product_type" +
            " FROM check_manipulation_history cmh\n" +
            "   LEFT JOIN employee e ON cmh.employee_id = e.id\n" +
            "   LEFT JOIN `check_product` cp ON cmh.check_id = cp.check_id AND cmh.product_id = cp.product_id\n" +
            "   LEFT JOIN `product` p ON cmh.product_id = p.id\n" +
            " WHERE cmh.id = ?";

    String GET_CHECK_BY_ID = "SELECT  c.id, c.date_time, c.cash_payments, c.cashless_payments, c.check_type,\n" +
            "  a.quantity p_quantity, a.product_in_check_type p_product_in_check_type, a.price p_price,\n" +
            "  p.id p_id, p.name p_name, p.product_type p_product_type,\n" +
            "  e.id e_id, e.first_name e_first_name, e.last_name e_last_name, e.role e_role\n" +
            "FROM `check` c\n" +
            "  LEFT JOIN check_product a ON c.`id` = a.`check_id`\n" +
            "  LEFT JOIN product p ON `product_id` = p.id\n" +
            "  LEFT JOIN employee e ON employee_id = e.id\n" +
            "WHERE c.id = ?";

    String GET_FULL_CHECK_INFORMATION_BY_ID = "SELECT  c.id, c.date_time, c.total_amount, c.check_type," +
            "    a.quantity, a.product_in_check_type," +
            "    p.id, p.name, p.price, p.quantity, p.product_type," +
            "    e.first_name, e.last_name" +
            "    FROM `check` c" +
            "    LEFT JOIN check_product a ON c.`id` = a.`check_id`" +
            "    LEFT JOIN product p ON `product_id` = p.id" +
            "    LEFT JOIN employee e ON employee_id = e.id" +
            "    WHERE c.`id` = ?";

    String GET_LATEST_REPORT = "SELECT * FROM z_report ORDER BY id DESC LIMIT 1";

    String ADD_PRODUCT = "INSERT INTO product (name, quantity, price, product_type) VALUES (?, ?, ?, ?)";

    String ADD_REPORT = "INSERT INTO z_report (money_put_in_cash_machine, seized_money, cash_payments, cashless_payments, canceled_cash_payments, canceled_cashless_payments, canceled_checks_count, checks_count) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    String ADD_EMPLOYEE = "INSERT INTO employee (first_name, last_name, login, password, role) VALUES (?, ?, ?, ?, ?)";

    String ADD_CHECK = "INSERT INTO `check` (cash_payments, cashless_payments, employee_id, check_type) VALUES (?, ?, ?, ?)";

    String ADD_PRODUCT_TO_LATEST_CHECK = "INSERT INTO check_product (check_id, product_id, quantity, price) VALUES (last_insert_id(), ?, ?, ?)";

    String ADD_PRODUCT_TO_CHECK = "INSERT INTO check_product (check_id, product_id, quantity, price) VALUES (?, ?, ?, ?)";

    String UPDATE_PRODUCT = "UPDATE product SET name = ?, quantity = ?, price = ?, product_type = ? WHERE id = ?";

    String UPDATE_EMPLOYEE = "UPDATE employee SET first_name = ?, last_name = ?, login = ?, password = ?, role = ? WHERE id = ?";

    String UPDATE_CHECK = "UPDATE product SET name = ?, quantity = ?, price = ?, product_type = ? WHERE id = ?";

    String DELETE_PRODUCT = "DELETE FROM product WHERE product.id = ?";

    String DELETE_EMPLOYEE = "DELETE FROM employee WHERE employee.id = ?";

    String DELETE_CHECK = "DELETE FROM product WHERE product.id = ?";

    String CANCEL_PRODUCT_FROM_CHECK = "UPDATE `check_product` cp" +
            "    SET cp.`product_in_check_type` = 'CANCELED'" +
            "    WHERE cp.`check_id` = ? AND cp.`product_id` = ?";

    String CANCEL_CHECK = "UPDATE `check`" +
            "    SET `check`.`check_type` = 'CANCELED'" +
            "    WHERE `check`.`id` = ?";
}