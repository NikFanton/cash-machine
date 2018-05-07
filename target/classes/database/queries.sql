ALTER TABLE `check` DROP FOREIGN KEY `check_employee`;
ALTER TABLE `check_product` DROP FOREIGN KEY `check_mediator`;
ALTER TABLE `check_product` DROP FOREIGN KEY `mediator_product`;
ALTER TABLE `operations_history` DROP FOREIGN KEY `operations_employee`;
ALTER TABLE `check_manipulation_history` DROP FOREIGN KEY `check_manipulation_employee`;
ALTER TABLE `check_manipulation_history` DROP FOREIGN KEY `check_manipulation_check`;
ALTER TABLE `check_manipulation_history` DROP FOREIGN KEY `check_manipulation_product`;

DROP TABLE IF EXISTS `check`;
DROP TABLE IF EXISTS `product`;
DROP TABLE IF EXISTS `employee`;
DROP TABLE IF EXISTS `check_product`;
DROP TABLE IF EXISTS `operations_history`;
DROP TABLE IF EXISTS `check_manipulation_history`;
DROP TABLE IF EXISTS `z_report`;

CREATE TABLE `check` (
  `id`                INT(32)         AUTO_INCREMENT,
  `date_time`         DATETIME        NOT NULL DEFAULT now(),
  `cash_payments`     BIGINT,
  `cashless_payments` BIGINT,
  `employee_id`       INT(32)         NOT NULL,
  `check_type`        ENUM ('NORMAL', 'ALTERED', 'CANCELED') NOT NULL DEFAULT 'NORMAL',
  PRIMARY KEY (`id`)
);

CREATE TABLE `check_product` (
  `check_id`              INT(32)        NOT NULL,
  `product_id`            INT(32)        NOT NULL,
  `quantity`              DOUBLE         NOT NULL,
  `price`                 BIGINT         NOT NULL,
  `product_in_check_type` ENUM ('NORMAL', 'CANCELED') NOT NULL DEFAULT 'NORMAL',
  UNIQUE(`check_id`, `product_id`)
);

CREATE TABLE `product` (
  `id`            INT(32)         AUTO_INCREMENT,
  `name`          VARCHAR(128)    NOT NULL,
  `quantity`      DOUBLE          NOT NULL,
  `price`         BIGINT          NOT NULL,
  `product_type`  ENUM ('UNKNOWN', 'COUNTABLE', 'UNCOUNTABLE')  NOT NULL DEFAULT 'UNKNOWN',
  PRIMARY KEY (`id`)
);

CREATE TABLE `employee` (
  `id`          INT(32)     AUTO_INCREMENT,
  `first_name`  VARCHAR(64) NOT NULL,
  `last_name`   VARCHAR(64) NOT NULL,
  `login`       VARCHAR(64) NOT NULL,
  `password`    VARCHAR(64) NOT NULL,
  `role`        ENUM ('UNKNOWN', 'ADMIN', 'CASHIER', 'SENIOR_CASHIER', 'MERCHANT') NOT NULL DEFAULT 'UNKNOWN',
  PRIMARY KEY (`id`),
  UNIQUE (`login`)
);

CREATE TABLE check_manipulation_history (
  `id`                      INT(32)      AUTO_INCREMENT,
  `employee_id`             INT(32)      NOT NULL,
  `date_time_of_operation`  DATETIME     NOT NULL DEFAULT now(),
  `check_manipulation_type` ENUM('CREATE_CHECK', 'CANCEL_CHECK', 'CANCEL_PRODUCT')  NOT NULL,
  `check_id`                INT(32)      NOT NULL,
  `product_id`              INT(32),
  PRIMARY KEY (`id`)
);

CREATE TABLE operations_history (
  `id`                     INT(32)      AUTO_INCREMENT,
  `employee_id`            INT(32)      NOT NULL,
  `date_time_of_operation` DATETIME     NOT NULL DEFAULT now(),
  `operation`              ENUM('LOGIN', 'LOGOUT', 'MAKE_X_REPORT')  NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `z_report` (
  `id`                        INT(32)   AUTO_INCREMENT,
  `money_put_in_cash_machine` DOUBLE    NOT NULL,
  `seized_money`              BIGINT    NOT NULL,
  `date_time`                 DATETIME  NOT NULL DEFAULT now(),
  `cash_payments`             BIGINT,
  `cashless_payments`         BIGINT,
  `canceled_payments`            BIGINT,
  `canceled_checks`           INT(32),
  PRIMARY KEY (`id`)
);

# CREATE TABLE operations_history (
#   `id`                     INT(32)      AUTO_INCREMENT,
#   `employee_id`            INT(32)      NOT NULL,
#   `date_time_of_operation` DATETIME     NOT NULL DEFAULT now(),
#   `check_id`               INT(32),
#   `product_id`             INT(32),
#   `z_report_id`            INT(32),
#   `operation`              ENUM('LOGIN', 'LOGOUT', 'BEGIN_OF_THE_WORK_DAY', 'END_OF_THE_WORK_DAY',
#                                 'MAKE_Z_REPORT', 'MAKE_X_REPORT',
#                                 'CANCEL_CHECK', 'CANCEL_PRODUCT')  NOT NULL,
#   PRIMARY KEY (`id`)
# );

ALTER TABLE `check` ADD CONSTRAINT `check_employee` FOREIGN KEY (`employee_id`) REFERENCES `employee`(`id`);
ALTER TABLE `check_product` ADD CONSTRAINT `check_mediator` FOREIGN KEY (`check_id`) REFERENCES `check`(`id`);
ALTER TABLE `check_product` ADD CONSTRAINT `mediator_product` FOREIGN KEY (`product_id`) REFERENCES `product`(`id`);
ALTER TABLE `operations_history` ADD CONSTRAINT `operations_employee` FOREIGN KEY (`employee_id`) REFERENCES `employee`(`id`);
ALTER TABLE `check_manipulation_history` ADD CONSTRAINT `check_manipulation_employee` FOREIGN KEY (`employee_id`) REFERENCES `employee`(`id`);
ALTER TABLE `check_manipulation_history` ADD CONSTRAINT `check_manipulation_check` FOREIGN KEY (`check_id`) REFERENCES `check`(`id`);
ALTER TABLE `check_manipulation_history` ADD CONSTRAINT `check_manipulation_product` FOREIGN KEY (`product_id`) REFERENCES `product`(`id`);

INSERT INTO product (name, product_type, quantity, price) VALUES
  ('peanuts',        'UNCOUNTABLE', 10, 1250),
  ('almond',         'UNCOUNTABLE', 10, 950),
  ('walnut',         'UNCOUNTABLE', 20, 580),
  ('hazelnut',       'UNCOUNTABLE', 50, 1015),
  ('cucumber',       'UNCOUNTABLE', 65, 225),
  ('tomato',         'UNCOUNTABLE', 55, 395),
  ('bulb_onions',    'UNCOUNTABLE', 20, 055),
  ('carrot',         'UNCOUNTABLE', 25, 160),
  ('white_cabbage',  'UNCOUNTABLE', 25, 150),
  ('tea',            'COUNTABLE',   90, 599),
  ('parsley',        'UNCOUNTABLE', 20, 255);

INSERT INTO employee (first_name, last_name, login, password, role) VALUES
  ('Nikita',  'Guchenko',   'nikita',   '1',          'ADMIN'),
  ('Nastia',  'Tishchenko', 'nastia',   '111',        'SENIOR_CASHIER'),
  ('Peter',   'Parker',     'peter',    'spidey',     'CASHIER'),
  ('Eric',  	'Griffin',    'eric',  	  'lkdf234',    'CASHIER'),
  ('Philip',  'Lopez',      'philip',   'lfdkj234',   'CASHIER'),
  ('Kevin', 	'Simmons',    'kevin', 	  'fdkl23',     'CASHIER'),
  ('Steve', 	'Henderson',  'steve', 	  'polko',      'SENIOR_CASHIER'),
  ('Randy', 	'Gonzales',   'randy', 	  'omadr',      'CASHIER'),
  ('Jose',  	'Roberts',    'jose',  	  'fds123vdsv', 'CASHIER'),
  ('Edward',  'Lewis',      'edward',   'sdfasdfljk', 'CASHIER'),
  ('Maurice',	'Tucker',     'maurice',  'tucfdj',     'CASHIER'),
  ('Cody',	  'Rodriquez',  'cody',	    'dfsdf',      'CASHIER'),
  ('Dean',	  'Lee',        'dean',	    'ellen',      'CASHIER'),
  ('Drew',	  'Mcguire',    'drew',	    'fdslkm231',  'CASHIER'),
  ('Steven',	'Singleton',  'steven',	  'sing111',    'CASHIER'),
  ('Tracy',	  'Padilla',    'tracy',	  'pasko',      'CASHIER'),
  ('Jeremy',	'Stevens',    'jeremy',	  'sten123',    'CASHIER'),
  ('Roy',	    'Gill',       'roy',	    'pet128',     'SENIOR_CASHIER'),
  ('Arturo',	'Figueroa',   'arturo',	  'ewre221',    'CASHIER'),
  ('Leo',	    'Fletcher',   'leo',	    'fletpad12',  'CASHIER');

INSERT INTO `check` (date_time, cash_payments, cashless_payments, employee_id) VALUES
  ('2018-04-19 14:25:00', 12000, 0, 2),
  ('2018-04-19 14:30:00', 5000, 0, 3);
-- 9999-12-31 23:59:59

INSERT INTO `check_product` (check_id, product_id, quantity, price) VALUES
  (1, 5,  2.3, 22500),
  (1, 7,  0.8, 05500),
  (1, 8,  3.2, 16000),
  (1, 1,  0.2, 125000),
  (2, 3,  1.0, 58000),
  (2, 7,  1.2, 05500),
  (2, 10, 1,   59900);

-- Template of work day --
INSERT INTO operations_history (employee_id, operation) VALUES (2, 'LOGIN');
UPDATE `check` SET `check`.`check_type` = 'ALTERED' WHERE `check`.`id` = 1;
UPDATE `check_product` cp SET cp.`product_in_check_type` = 'CANCELED' WHERE cp.`check_id` = 1 AND cp.`product_id` = 5;
INSERT INTO check_manipulation_history (employee_id, check_manipulation_type, check_id, product_id) VALUES (7, 'CANCEL_PRODUCT', 1, 5);
INSERT INTO operations_history (employee_id, operation) VALUES (2, 'LOGOUT');
INSERT INTO operations_history (employee_id, operation) VALUES (3, 'LOGIN');
UPDATE `check` SET `check`.`check_type` = 'CANCELED' WHERE `check`.`id` = 2;
INSERT INTO check_manipulation_history (employee_id, check_manipulation_type, check_id) VALUES (3, 'CANCEL_CHECK', 2);
INSERT INTO z_report (money_put_in_cash_machine, seized_money, cash_payments, cashless_payments, canceled_payments, canceled_checks)
VALUES (8632, 4522955, 4512955, 10000, 2550, 1);
INSERT INTO operations_history (employee_id, operation) VALUES (3, 'MAKE_X_REPORT');
INSERT INTO operations_history (employee_id, operation) VALUES (3, 'LOGOUT');

-- employees joined to their accounts --
SELECT e.id, e.first_name, e.last_name, e.role, e.login, e.password
FROM employee e;

-- Full check information --
SELECT  c.id, c.date_time, c.cash_payments, c.cashless_payments, c.check_type,
  a.quantity, a.product_in_check_type, a.price,
  p.id, p.name, p.quantity, p.product_type,
  e.first_name, e.last_name, e.role
FROM `check` c
  LEFT JOIN check_product a ON c.`id` = a.`check_id`
  LEFT JOIN product p ON `product_id` = p.id
  LEFT JOIN employee e ON employee_id = e.id
WHERE c.id = 1;

-- LOGIN, LOGOUT, BEGIN_OF_THE_WORK_DAY, END_OF_THE_WORK_DAY --
-- MAKE_Z_REPORT ?, MAKE_X_REPORT --
-- CREATE_CHECK, CANCEL_CHECK ?, CANCEL_PRODUCT ? ? --
SELECT * FROM operations_history
  LEFT JOIN employee e ON employee_id = e.id;

SELECT * FROM check_manipulation_history
  LEFT JOIN employee e ON employee_id = e.id;

INSERT INTO z_report (money_put_in_cash_machine, seized_money, cash_payments, cashless_payments, canceled_payments, canceled_checks) VALUES (8632, 5522955, 5512955, 20000, 2550, 1);
INSERT INTO z_report (money_put_in_cash_machine, seized_money, cash_payments, cashless_payments, canceled_payments, canceled_checks) VALUES (8632, 6522955, 6512955, 30000, 2550, 1);

-- Get latest report --
SELECT * FROM z_report ORDER BY id DESC LIMIT 1;

-- SQL Queries for Product --
SELECT * FROM product;
SELECT * FROM product WHERE id = ?;
SELECT * FROM product WHERE name = ?;
INSERT INTO product (name, quantity, price, product_type) VALUES (?, ?, ?, ?);
DELETE FROM product WHERE product.id = ?;
UPDATE product SET name = ?, quantity = ?, price = ?, product_type = ? WHERE id = ?;

-- SQL Queries for Employee --
SELECT * FROM employee;
SELECT * FROM employee WHERE login = ?;
SELECT * FROM employee WHERE login = ? AND password = ?;
INSERT INTO employee (first_name, last_name, login, password, role) VALUES (?, ?, ?, ?, ?);
DELETE FROM employee WHERE employee.id = ?;
UPDATE employee SET first_name = ?, last_name = ?, login = ?, password = ?, role = ? WHERE id = ?;

-- SQL Queries for CheckManipulation --
SELECT cmh.id, cmh.date_time_of_operation, cmh.check_manipulation_type, cmh.product_id,
  e.id e_id, e.first_name e_first_name, e.last_name e_last_name, e.role e_role,
  c.id check_id, c.date_time check_date_time, c.cash_payments check_cash_payments, c.cashless_payments check_cashless_payments, c.check_type check_check_type,
  ec.id c_id, ec.first_name c_first_name, ec.last_name c_last_name, ec.role c_role
FROM check_manipulation_history cmh
  LEFT JOIN employee e ON cmh.employee_id = e.id
  LEFT JOIN `check` c ON cmh.check_id = c.id
  LEFT JOIN employee ec ON c.employee_id = ec.id
WHERE cmh.id = 1;

SELECT cp.quantity, cp.price, cp.product_in_check_type,
  p.id, p.product_type, p.name
FROM check_product cp
  LEFT JOIN product p ON cp.product_id = p.id
WHERE check_id = 1 AND product_id = 5;

SELECT cmh.id, cmh.date_time_of_operation, cmh.check_manipulation_type, cmh.product_id,
  e.id e_id, e.first_name e_first_name, e.last_name e_last_name, e.role e_role,
  c.id check_id, c.date_time check_date_time, c.cash_payments check_cash_payments, c.cashless_payments check_cashless_payments, c.check_type check_check_type,
  ec.id c_id, ec.first_name c_first_name, ec.last_name c_last_name, ec.role c_role
FROM check_manipulation_history cmh
  LEFT JOIN employee e ON cmh.employee_id = e.id
  LEFT JOIN `check` c ON cmh.check_id = c.id
  LEFT JOIN employee ec ON c.employee_id = ec.id
WHERE c.id = 2;

-- SQL Queries for Check --
SELECT  c.id, c.date_time, c.cash_payments, c.cashless_payments, c.check_type,
  a.quantity p_quantity, a.product_in_check_type p_product_in_check_type, a.price p_price,
  p.id p_id, p.name p_name, p.product_type p_product_type,
  e.id e_id, e.first_name e_first_name, e.last_name e_last_name, e.role e_role
FROM `check` c
  LEFT JOIN check_product a ON c.`id` = a.`check_id`
  LEFT JOIN product p ON `product_id` = p.id
  LEFT JOIN employee e ON employee_id = e.id
ORDER BY c.id DESC;

SELECT count(id) count FROM `check` WHERE check_type = 'CANCELED';

INSERT INTO `check` (cash_payments, cashless_payments, employee_id, check_type) VALUES (?, ?, ?, ?);
INSERT INTO check_product (check_id, product_id, quantity, price) VALUES (last_insert_id(), ?, ?, ?);

-- SQL Queries for Z-Report --
SELECT * FROM z_report;
INSERT INTO z_report (money_put_in_cash_machine, seized_money, cash_payments, cashless_payments, canceled_payments, canceled_checks) VALUES (?, ?, ?, ?, ?, ?);

-- Get latest report --
SELECT * FROM z_report ORDER BY id DESC LIMIT 1;