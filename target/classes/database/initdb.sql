ALTER TABLE `check` DROP FOREIGN KEY `check_employee`;
ALTER TABLE `check_product` DROP FOREIGN KEY `check_mediator`;
ALTER TABLE `check_product` DROP FOREIGN KEY `mediator_product`;
ALTER TABLE operations_history DROP FOREIGN KEY `log_employee`;

DROP TABLE IF EXISTS `check`;
DROP TABLE IF EXISTS `product`;
DROP TABLE IF EXISTS `employee`;
DROP TABLE IF EXISTS `check_product`;
DROP TABLE IF EXISTS `operations_history`;
DROP TABLE IF EXISTS `z_report`;

CREATE TABLE `check` (
  `id`                INT(32)         AUTO_INCREMENT,
  `date_time`         DATETIME        NOT NULL DEFAULT now(),
  `cash_payments`     DECIMAL(10, 4),
  `cashless_payments` DECIMAL(10, 4),
  `employee_id`       INT(32)         NOT NULL,
  `check_type`        ENUM ('NORMAL', 'ALTERED', 'CANCELED') NOT NULL DEFAULT 'NORMAL',
  PRIMARY KEY (`id`)
);

CREATE TABLE `check_product` (
  `check_id`              INT(32)        NOT NULL,
  `product_id`            INT(32)        NOT NULL,
  `quantity`              DOUBLE         NOT NULL,
  `price`                 DECIMAL(10, 4) NOT NULL,
  `name`                  VARCHAR(128)   NOT NULL,
  `product_in_check_type` ENUM ('NORMAL', 'CANCELED') NOT NULL DEFAULT 'NORMAL',
  UNIQUE(`check_id`, `product_id`)
);

CREATE TABLE `product` (
  `id`            INT(32)     AUTO_INCREMENT,
  `name`          VARCHAR(128) NOT NULL,
  `quantity`      DOUBLE      NOT NULL,
  `price`         DECIMAL(10, 4)      NOT NULL,
  `product_type`  ENUM ('UNKNOWN', 'COUNTABLE', 'UNCOUNTABLE')  NOT NULL DEFAULT 'UNKNOWN',
  PRIMARY KEY (`id`)
);

CREATE TABLE `employee` (
  `id`          INT(32)     AUTO_INCREMENT,
  `first_name`  VARCHAR(64) NOT NULL,
  `last_name`   VARCHAR(64) NOT NULL,
  `account_id`  INT(32)     NOT NULL,
  `login`    VARCHAR(64) NOT NULL,
  `password` VARCHAR(64) NOT NULL,
  `role`     ENUM ('UNKNOWN', 'ADMIN', 'CASHIER', 'SENIOR_CASHIER', 'MERCHANT') NOT NULL DEFAULT 'UNKNOWN',
  PRIMARY KEY (`id`),
  UNIQUE (`login`)
);

CREATE TABLE operations_history (
  `id`                     INT(32) AUTO_INCREMENT,
  `employee_id`            INT(32) NOT NULL,
  `date_time_of_operation` DATETIME NOT NULL DEFAULT now(),
  `operation`              VARCHAR(64),
  PRIMARY KEY (`id`)
);

CREATE TABLE `z_report` (
  `id`                        INT(32)           AUTO_INCREMENT,
  `money_put_in_cash_machine` DOUBLE            NOT NULL,
  `seized_money`              DECIMAL(10, 4)    NOT NULL,
  `date_time`                 DATETIME          NOT NULL DEFAULT now(),
  `cash_payments`             DECIMAL(10, 4),
  `cashless_payments`         DECIMAL(10, 4),
  `canceled_money`            DECIMAL(10, 4),
  `canceled_checks`           INT(32),
  PRIMARY KEY (`id`)
);

ALTER TABLE `check` ADD CONSTRAINT `check_employee` FOREIGN KEY (`employee_id`) REFERENCES `employee`(`id`);
ALTER TABLE `check_product` ADD CONSTRAINT `check_mediator` FOREIGN KEY (`check_id`) REFERENCES `check`(`id`);
ALTER TABLE `check_product` ADD CONSTRAINT `mediator_product` FOREIGN KEY (`product_id`) REFERENCES `product`(`id`);
ALTER TABLE operations_history ADD CONSTRAINT `log_employee` FOREIGN KEY (`employee_id`) REFERENCES `employee`(`id`);

INSERT INTO product (name, product_type, quantity, price) VALUES
  ('peanuts',        'UNCOUNTABLE', 10, 12.50),
  ('almond',         'UNCOUNTABLE', 10, 9.50),
  ('walnut',         'UNCOUNTABLE', 20, 5.80),
  ('hazelnut',       'UNCOUNTABLE', 50, 10.15),
  ('cucumber',       'UNCOUNTABLE', 65, 2.25),
  ('tomato',         'UNCOUNTABLE', 55, 3.95),
  ('bulb_onions',    'UNCOUNTABLE', 20, 0.55),
  ('carrot',         'UNCOUNTABLE', 25, 1.60),
  ('white_cabbage',  'UNCOUNTABLE', 25, 1.50),
  ('tea',            'COUNTABLE',   90, 5.99),
  ('parsley',        'UNCOUNTABLE', 20, 2.55);

INSERT INTO employee (first_name, last_name, account_id, login, password, role) VALUES
  ('Nikita',  'Guchenko',   1,  'nikita',   '1',          'ADMIN'),
  ('Nastia',  'Tishchenko', 2,  'nastia',   '111',        'SENIOR_CASHIER'),
  ('Peter',   'Parker',     3,  'peter',    'spidey',     'CASHIER'),
  ('Eric',  	'Griffin',    4,  'eric',  	  'lkdf234',    'CASHIER'),
  ('Philip',  'Lopez',      5,  'philip',   'lfdkj234',   'CASHIER'),
  ('Kevin', 	'Simmons',    6,  'kevin', 	  'fdkl23',     'CASHIER'),
  ('Steve', 	'Henderson',  7,  'steve', 	  'polko',      'SENIOR_CASHIER'),
  ('Randy', 	'Gonzales',   8,  'randy', 	  'omadr',      'CASHIER'),
  ('Jose',  	'Roberts',    9,  'jose',  	  'fds123vdsv', 'CASHIER'),
  ('Edward',  'Lewis',      10, 'edward',   'sdfasdfljk', 'CASHIER'),
  ('Maurice',	'Tucker',     11, 'maurice',  'tucfdj',     'CASHIER'),
  ('Cody',	  'Rodriquez',  12, 'cody',	    'dfsdf',      'CASHIER'),
  ('Dean',	  'Lee',        13, 'dean',	    'ellen',      'CASHIER'),
  ('Drew',	  'Mcguire',    14, 'drew',	    'fdslkm231',  'CASHIER'),
  ('Steven',	'Singleton',  15, 'steven',	  'sing111',    'CASHIER'),
  ('Tracy',	  'Padilla',    16, 'tracy',	  'pasko',      'CASHIER'),
  ('Jeremy',	'Stevens',    17, 'jeremy',	  'sten123',    'CASHIER'),
  ('Roy',	    'Gill',       18, 'roy',	    'pet128',     'SENIOR_CASHIER'),
  ('Arturo',	'Figueroa',   19, 'arturo',	  'ewre221',    'CASHIER'),
  ('Leo',	    'Fletcher',   20, 'leo',	    'fletpad12',  'CASHIER');

INSERT INTO `check` (date_time, cash_payments, employee_id) VALUES
  ('2018-04-19 14:25:00', 120, 2),
  ('2018-04-19 14:30:00', 50, 3);
-- 9999-12-31 23:59:59

INSERT INTO `check_product` (check_id, product_id, quantity, name, price) VALUES
  (1, 5,  2.3, 'cucumber',    2.25),
  (1, 7,  0.8, 'bulb_onions', 0.55),
  (1, 8,  3.2, 'carrot',      1.60),
  (1, 1,  0.2, 'peanuts',     12.50),
  (2, 3,  1.0, 'walnut',      5.80),
  (2, 7,  1.2, 'bulb_onions', 0.55),
  (2, 10, 1,   'tea',         5.99);

-- Template of work day --
INSERT INTO operations_history (employee_id, operation) VALUES (2, 'BEGIN_OF_THE_WORK_DAY');
INSERT INTO operations_history (employee_id, operation) VALUES (2, 'LOGIN');
UPDATE `check` SET `check`.`check_type` = 'ALTERED' WHERE `check`.`id` = 1;
UPDATE `check_product` cp SET cp.`product_in_check_type` = 'CANCELED' WHERE cp.`check_id` = 1 AND cp.`product_id` = 5;
INSERT INTO operations_history (employee_id, operation) VALUES (2, 'CANCEL_PRODUCT 1 5');
INSERT INTO operations_history (employee_id, operation) VALUES (2, 'LOGOUT');
INSERT INTO operations_history (employee_id, operation) VALUES (3, 'LOGIN');
UPDATE `check` SET `check`.`check_type` = 'CANCELED' WHERE `check`.`id` = 2;
INSERT INTO operations_history (employee_id, operation) VALUES (3, 'CANCEL_CHECK 2');
INSERT INTO z_report (money_put_in_cash_machine, seized_money, cash_payments, cashless_payments, canceled_money, canceled_checks)
VALUES (86.32, 45229.55, 45129.55, 100.00, 25.50, 1);
INSERT INTO operations_history (employee_id, operation) VALUES (3, 'MAKE_X_REPORT');
INSERT INTO operations_history (employee_id, operation) VALUES (3, 'LOGOUT');
INSERT INTO operations_history (employee_id, operation) VALUES (3, 'END_OF_THE_WORK_DAY');

-- employees joined to their accounts --
SELECT e.id, e.first_name, e.last_name, e.role, e.login, e.password
FROM employee e;

-- Full check information --
SELECT  c.id, c.date_time, c.cash_payments, c.cashless_payments, c.check_type,
  a.quantity, a.product_in_check_type, a.price, a.name,
  p.id, p.quantity, p.product_type,
  e.first_name, e.last_name, e.role
FROM `check` c
  LEFT JOIN check_product a ON c.`id` = a.`check_id`
  LEFT JOIN product p ON `product_id` = p.id
  LEFT JOIN employee e ON employee_id = e.id;

-- LOGIN, LOGOUT, BEGIN_OF_THE_WORK_DAY, END_OF_THE_WORK_DAY --
-- MAKE_Z_REPORT ?, MAKE_X_REPORT --
-- CANCEL_CHECK ?, CANCEL_PRODUCT ? ? --
SELECT * FROM operations_history
  LEFT JOIN employee e ON employee_id = e.id;

INSERT INTO z_report (money_put_in_cash_machine, seized_money, cash_payments, cashless_payments, canceled_money, canceled_checks) VALUES (86.32, 55229.55, 55129.55, 200.00, 25.50, 1);
INSERT INTO z_report (money_put_in_cash_machine, seized_money, cash_payments, cashless_payments, canceled_money, canceled_checks) VALUES (86.32, 65229.55, 65129.55, 300.00, 25.50, 1);

-- Get latest report --
SELECT * FROM z_report ORDER BY id DESC LIMIT 1;