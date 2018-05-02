-- employees joined to their accounts --
SELECT e.id, e.first_name, e.last_name, a.role, a.login, a.password
FROM employee e LEFT JOIN account a ON account_id = a.id;

-- Check information --
SELECT * FROM `check` WHERE id = ?;

-- Full check information --
SELECT  c.id, c.date_time, c.total_amount, c.check_type,
  a.quantity, a.product_in_check_type,
  p.id, p.name, p.price, p.quantity, p.product_type,
  e.first_name, e.last_name
FROM `check` c
  LEFT JOIN check_product a ON c.`id` = a.`check_id`
  LEFT JOIN product p ON `product_id` = p.id
  LEFT JOIN employee e ON employee_id = e.id;

-- Add product to check --
INSERT INTO `check_product` (check_id, product_id, quantity) VALUES (?, ?, ?);

-- Cancel product in the check --
UPDATE `check_product` cp
SET cp.`product_in_check_type` = 'CANCELED'
WHERE cp.`check_id` = 1 AND cp.`product_id` = 5;

-- Cancel check --
UPDATE `check`
SET `check`.`check_type` = 'CANCELED'
WHERE `check`.`id` = 2;

INSERT INTO `product` (name, product_type, quantity, price) VALUES (?, ?, ?, ?);

INSERT INTO `account` (login, password, role) VALUES (?, ?, ?);

INSERT INTO `employee` (first_name, last_name, account_id) VALUES (?, ?, ?);

INSERT INTO `check` (date_time, total_amount, employee_id) VALUES (?, ?, ?);

INSERT INTO `check_product` (check_id, product_id, quantity) VALUES (?, ?, ?);


SELECT * FROM check_product;

SELECT * FROM product;

SELECT * FROM employee;

SELECT e.id, e.first_name, e.last_name, a.role, a.login, a.password
FROM employee e LEFT JOIN account a ON account_id = a.id
WHERE a.login = ? AND password = ?;

SELECT * FROM `account`
WHERE `account`.`login` = ? AND `account`.`password` = ?;

INSERT INTO `account` (login, password, role) VALUES ('tonystark', 'stark111', 'SENIOR_CASHIER');
INSERT INTO `employee` (first_name, last_name, account_id) VALUES ('Tony', 'Stark', last_insert_id());

INSERT INTO `check` (total_amount, employee_id) VALUES
  (120, 2);