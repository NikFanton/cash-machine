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
  `id`                          INT(32)   AUTO_INCREMENT,
  `money_put_in_cash_machine`   DOUBLE    NOT NULL,
  `seized_money`                BIGINT    NOT NULL,
  `date_time`                   DATETIME  NOT NULL DEFAULT now(),
  `cash_payments`               BIGINT,
  `cashless_payments`           BIGINT,
  `canceled_cash_payments`      BIGINT,
  `canceled_cashless_payments`  BIGINT,
  `canceled_checks_count`       INT(32),
  `checks_count`                INT(32),
  PRIMARY KEY (`id`)
);

ALTER TABLE `check` ADD CONSTRAINT `check_employee` FOREIGN KEY (`employee_id`) REFERENCES `employee`(`id`);
ALTER TABLE `check_product` ADD CONSTRAINT `check_mediator` FOREIGN KEY (`check_id`) REFERENCES `check`(`id`) ON DELETE CASCADE;
ALTER TABLE `check_product` ADD CONSTRAINT `mediator_product` FOREIGN KEY (`product_id`) REFERENCES `product`(`id`);
ALTER TABLE `operations_history` ADD CONSTRAINT `operations_employee` FOREIGN KEY (`employee_id`) REFERENCES `employee`(`id`);
ALTER TABLE `check_manipulation_history` ADD CONSTRAINT `check_manipulation_employee` FOREIGN KEY (`employee_id`) REFERENCES `employee`(`id`);
ALTER TABLE `check_manipulation_history` ADD CONSTRAINT `check_manipulation_check` FOREIGN KEY (`check_id`) REFERENCES `check`(`id`);
ALTER TABLE `check_manipulation_history` ADD CONSTRAINT `check_manipulation_product` FOREIGN KEY (`product_id`) REFERENCES `product`(`id`);

INSERT INTO product (name, price, quantity, product_type) VALUES
  ('Картопля відбірна',                                      2990,   100, 'UNCOUNTABLE'),
  ('Морква мита',                                            2090,   100, 'UNCOUNTABLE'),
  ('Морквяні палички',                                       5820,   200, 'UNCOUNTABLE'),
  ('Томати Гордій коктейльні',                               5790,   50,  'UNCOUNTABLE'),
  ('Томат Черрі',                                            3790,   65,  'UNCOUNTABLE'),
  ('Огірок Гордій колючий фасований',                        4195,   55,  'UNCOUNTABLE'),
  ('Цибуля Кожен день ріпчаста очищена мита ціла',           3250,   20,  'UNCOUNTABLE'),
  ('Капуста червона нарізана соломкою',                      5600,   250, 'UNCOUNTABLE'),
  ('Цикорій білий',                                          5800,   250, 'UNCOUNTABLE'),
  ('Перець жовтий україна',                                  2550,   20,  'UNCOUNTABLE'),
  ('Огірки гладкі Україна вагові',                           2550,   20,  'UNCOUNTABLE'),
  ('Імбир',                                                  2550,   20,  'UNCOUNTABLE'),
  ('Цибуля червона',                                         2550,   20,  'UNCOUNTABLE'),
  ('Капуста червонокачанна',                                 2550,   20,  'UNCOUNTABLE'),
  ('Жув.гумкаОрбіт Солод.мята',                              1000,   210, 'COUNTABLE'),
  ('Жув.гумка Орбіт Білий освіж.мята ',                      1000,   185, 'COUNTABLE'),
  ('Жув.гумкаОрбіт Зимова свіжість ',                        1032,   305, 'COUNTABLE'),
  ('Жув.гумкаОрбітпод.Bubblemint мята',                      1000,   598, 'COUNTABLE'),
  ('Жув.гумка, Oрбiт Яблуко под.',                           1000,   307, 'COUNTABLE'),
  ('Шок, Millenium чорний 90г пор.',                         1968,   524, 'COUNTABLE'),
  ('Millennium Истории Океана кор 16к-т/170г/',              5657,   346, 'COUNTABLE'),
  ('Цукерки Millennium Classik Acorti  молочні 285 г.',      8938,   528, 'COUNTABLE'),
  ('Вода Buvette сильногаз. 1,5л.',                          923,    171, 'COUNTABLE'),
  ('Цукерка Корiвка Рошен 205 г.',                           1600,   533, 'COUNTABLE'),
  ('Цукерки Шалена бджілка Фрутті 200г.',                    1515,   209, 'COUNTABLE'),
  ('Цук.Bonny-Fruit 250г/18 асортi',                         1810,   483, 'COUNTABLE'),
  ('Цук.Bonny-Fruit 250г/18 морське асортi',                 1810,   595, 'COUNTABLE'),
  ('Цук.Bonny-Fruit 250г/18 фрукти',                         1810,   185, 'COUNTABLE'),
  ('цукерки  Shooters ром-ликер 150г',                       3495,   459, 'COUNTABLE'),
  ('цукерки Shooters бренди-ликер 150г',                     3495,   247, 'COUNTABLE'),
  ('цукерки Shooters текила санрайз 150г',                   3495,   170, 'COUNTABLE'),
  ('цукерки Shooters irish coffee 150г',                     3495,   448, 'COUNTABLE'),
  ('Ваф, трубочки Konafetto сгущ,молок-крем  156 г.',        1750,   343, 'COUNTABLE'),
  ('Ваф,трубочки Кonafetto крем-какао 156 г',                1750,   322, 'COUNTABLE'),
  ('Печиво До Кави Пряжене Молоко 185 г',                    815,    402, 'COUNTABLE'),
  ('Печиво-сендвіч з начин. полуниця -крем 195 г',           1255,   291, 'COUNTABLE'),
  ('Крекер Multicake fun & crispi з молоч.-крем.начин.135г', 1255,   582, 'COUNTABLE'),
  ('Крекер Multicake fun & crispi з начин. какао 135г',      1255,   534, 'COUNTABLE'),
  ('Печиво Мульти -Кейк double milk 170г',                   1255,   270, 'COUNTABLE'),
  ('Рулет біск. Вишня-крем 210г',                            2075,   193, 'COUNTABLE'),
  ('Ш-д Рошен Брют ВКФ 90г',                                 2240,   104, 'COUNTABLE'),
  ('Ш-д Рошен экс.черн-др.л.ор.90г',                         2100,   240, 'COUNTABLE'),
  ('Шок. Рошен Мол+др.л.ор 90г',                             2050,   308, 'COUNTABLE'),
  ('Батон Рошен мол.-шок з карам.начинкою 40г.',             710,    260, 'COUNTABLE'),
  ('Coca-Cola 0,5л',                                         1030,   206, 'COUNTABLE'),
  ('Sprite 0,5л',                                            1030,   494, 'COUNTABLE'),
  ('Фанта Апельсин 0,5л.',                                   1030,   118, 'COUNTABLE'),
  ('Bonagua 0,5л газована',                                  700,    252, 'COUNTABLE'),
  ('Bonagua 0,5л негаз.',                                    700,    340, 'COUNTABLE'),
  ('Bonagua негаз, 1л',                                      780,    350, 'COUNTABLE'),
  ('Вафлi Roshen Wafers горiх 72г.',                         700,    571, 'COUNTABLE'),
  ('Вафлi Roshen Wafers молоко 72г.',                        700,    478, 'COUNTABLE'),
  ('Вафлi Roshen Wafers шоколад 72г.',                       700,    496, 'COUNTABLE'),
  ('цукерки Киев Вечерний Весна 176 г',                      8950,   584, 'COUNTABLE'),
  ('Батон Рошен мол.-шок з нач.крем-брюле 43г.',             710,    544, 'COUNTABLE'),
  ('Соса - Соlа 1л',                                         1485,   262, 'COUNTABLE'),
  ('Спрайт 1л',                                              1435,   535, 'COUNTABLE'),
  ('Фанта Апельсин 1л',                                      1435,   489, 'COUNTABLE'),
  ('Bonagua 1л газована',                                    780 ,   562, 'COUNTABLE'),
  ('BURN 0,25л.',                                            2060,   178, 'COUNTABLE'),
  ('Вода мiнеральна Бонаква 1.5л газ',                       845,    116, 'COUNTABLE'),
  ('Вода мiнеральна Бонаква 1.5л негаз.',                    845,    218, 'COUNTABLE'),
  ('1,5л. Спрайт',                                           1720,   258, 'COUNTABLE'),
  ('1,5 л. Кока Кола',                                       1815,   221, 'COUNTABLE'),
  ('1,5 л. Фанта-апельсин',                                  1720,   420, 'COUNTABLE'),
  ('Ш-д Рошен экстр. черн 90г',                              1865,   430, 'COUNTABLE'),
  ('Цукерка Цитрусовий мiкс 200 г.',                         1115,   574, 'COUNTABLE'),
  ('Рулет Сгущ. мол. 200г',                                  2075,   434, 'COUNTABLE'),
  ('Рулет Шокол 240г',                                       2320,   153, 'COUNTABLE'),
  ('Бісквіт згущене молоко 300г.',                           3565,   397, 'COUNTABLE'),
  ('Бісквіт шоколад 300г.',                                  3565,   447, 'COUNTABLE'),
  ('Сiк Рiч екзотiк 1л',                                     2275,   351, 'COUNTABLE'),
  ('Сiк Рiч яблуко 1л',                                      2275,   223, 'COUNTABLE'),
  ('Шок, Millenium молочный 90г пор',                        1968,   517, 'COUNTABLE'),
  ('Цукерки Millenium Riviera Nice  асорт, 250г',            8772,   592, 'COUNTABLE'),
  ('Шок, Millenium молоч.-бiлий 32г пор',                    869,    175, 'COUNTABLE'),
  ('Сок Рич томат  1л',                                      2275,   562, 'COUNTABLE'),
  ('Сок Рич Апельсин  1л.',                                  2435,   327, 'COUNTABLE'),
  ('Сiк Рiч кiдс мiкс 0,2л',                                 680,    125, 'COUNTABLE'),
  ('Десерт Чарівний Вечір молочний 85г.',                    798,    593, 'COUNTABLE'),
  ('Шок, Millenium  бел, порист, 90г',                       1925,   311, 'COUNTABLE'),
  ('Шок, Millenium Gold мол, с цел, орех 100г',              2890,   332, 'COUNTABLE'),
  ('Шок, Millenium   черный  порист.90г',                    2890,   190, 'COUNTABLE'),
  ('Любимов Kids мол.з мол.нач.50г',                         1060,   303, 'COUNTABLE'),
  ('Шокол. батон. SNICKERS - SUPER+1 112,5г',                2490,   226, 'COUNTABLE'),
  ('Баунти шок.бат. 57г',                                    1245,   501, 'COUNTABLE'),
  ('Твікс мол 50 гр.',                                       1245,   536, 'COUNTABLE'),
  ('Твікс Екстра мол.шок.75 гр',                             2225,   210, 'COUNTABLE'),
  ('Баунти ТРИО 85г',                                        2225,   211, 'COUNTABLE'),
  ('ММs  арахис  45г.',                                      1495,   266, 'COUNTABLE'),
  ('"М-Мs"драже шок.глаз46г',                                1495,   578, 'COUNTABLE'),
  ('Вода Buvette сильногаз. 0,5л.',                          710,    235, 'COUNTABLE'),
  ('Вода Buvette негаз 0,5л.',                               710,    192, 'COUNTABLE'),
  ('Вода Buvette негаз 1,5л.',                               930,    322, 'COUNTABLE'),
  ('Цукерки Любимов в молоч.шок.125г',                       4045,   452, 'COUNTABLE'),
  ('персиковый сок с мякотью 0,95л',                         2000,   190, 'COUNTABLE'),
  ('Сок Апельсиновый 1л /слим/',                             3135,   571, 'COUNTABLE'),
  ('Нектар Сандора Мультивитамин 1л /слим/',                 2600,   130, 'COUNTABLE'),
  ('Вода газ Бон Буассон 0,5 л.',                            600,    567, 'COUNTABLE'),
  ('Вода газ Бон Буассон 1 л.',                              700,    153, 'COUNTABLE'),
  ('енерг.напій Black 0,5л.',                                1100,   294, 'COUNTABLE'),
  ('енерг.напій Black 1,0л.',                                1755,   289, 'COUNTABLE'),
  ('Вода газ.Бон-Буассон напій лимонад 1л',                  1180,   282, 'COUNTABLE'),
  ('Жув.гумка Орбіт Білий клас(под)',                        1180,   383, 'COUNTABLE'),
  ('Жув.гумка Орбіт Фантастичний Апельсин (под)',            2850,   500, 'COUNTABLE'),
  ('Любимов к/у мол.орех',                                   2850,   233, 'COUNTABLE'),
  ('насіння  "Бубка с солью" 50г',                           2850,   468, 'COUNTABLE'),
  ('Чiпси картоплянi Золотистi, бекон, 50 г.',               2000,   387, 'COUNTABLE'),
  ('Чiпси картоплянi Золотистi, сир 50 г.',                  1090,   209, 'COUNTABLE'),
  ('Арахiс ТМ Alex 60г.',                                    1135,   331, 'COUNTABLE'),
  ('Шоколад Любимов 38 г. тiрамiсу',                         1135,   244, 'COUNTABLE'),
  ('Fanta лимон 0,5л.',                                      5595,   375, 'COUNTABLE'),
  ('Берн 0,5л',                                              2835,   327, 'COUNTABLE'),
  (' Кока -Кола 0,33 л',                                     1585,   489, 'COUNTABLE'),
  ('Фанта Апельсин 0,33л',                                   1680,   203, 'COUNTABLE'),
  ('Спрайт 0,33 л',                                          1585,   288, 'COUNTABLE'),
  ('Напiй Medovo Смак Квiткового Меду 1,5л',                 1000,   198, 'COUNTABLE'),
  ('Напiй Medovo Яблуко та Женшень 1,5л',                    1755,   291, 'COUNTABLE'),
  ('Напiй Medovo Лайм та Iмбир 1,5л',                        1755,   258, 'COUNTABLE'),
  ('Цукерки RoshenAssortment145г.Elegant',                   1755,   355, 'COUNTABLE'),
  ('Чай Fuze черный с лимоном 0,5 л',                        2025,   155, 'COUNTABLE'),
  ('Цукерки Любимов Фрукти в шоколаді 150г.',                1950,   369, 'COUNTABLE'),
  ('Мультивитаминний сік 0,2л.',                             1950,   303, 'COUNTABLE'),
  ('Яблучно-виноградний нектар0,2л',                         840,    200, 'COUNTABLE'),
  ('Чипси Lays бекон 28 г',                                  880,    594, 'COUNTABLE'),
  ('Чипси Lays сир 28 г',                                    1350,   589, 'COUNTABLE'),
  ('Чипси Lays краб 28 г',                                   900,    149, 'COUNTABLE'),
  ('Чипси Lays сметана та зелинь 30 г',                      1000,   198, 'COUNTABLE'),
  ('Чипси Lays бекон 85г',                                   1000,   485, 'COUNTABLE'),
  ('Чипси Lays краб 102 г',                                  1965,   148, 'COUNTABLE'),
  ('Чипси Lays сир 85 г',                                    600,    522, 'COUNTABLE'),
  ('Цук.Рошен Пташине молоко  вершкове 150г.',               700,    157, 'COUNTABLE'),
  ('Ш-д Рошен Elegance экст.молочний горіх 100г.',           700,    342, 'COUNTABLE'),
  ('Millennium Gold с лес.ор.мол.шок.кор18к-т/205',          1000,   512, 'COUNTABLE'),
  ('Напiй Мультивiтамiн з соком 2л.',                        775,    112, 'COUNTABLE'),
  ('Оболонь-Живчик 0,5л',                                    945,    482, 'COUNTABLE'),
  ('Жув. Гумка Орбіт Евкаліпт ',                             3340,   581, 'COUNTABLE');

INSERT INTO employee (first_name, last_name, login, password, role) VALUES
  ('Barry',   'Edwards',    'admin',    '$2a$10$DmCCW5FnIllrELWUPcIle.Fi75LWlsxx7Gnl6xGNzV.581K9Py3VG', 'ADMIN'),           -- market1203 --
  ('Irene',   'Rhodes',     'irene',    '$2a$10$0SGo1y/MSE30GmVY0ElI/eOvRcglX7zWNQWlG7/57htRoqu8hn9V2', 'SENIOR_CASHIER'),  -- suit93 --
  ('Frank',   'Parker',     'frank',    '$2a$10$cBts1eIkCYp53yKtSy.6ee0KC2N4KPlnqP6iJ4M.UguBZQixLYCV.', 'CASHIER'),         -- 8272clothe --
  ('Eric',  	'Griffin',    'eric',  	  '$2a$10$Bb7QfASHG5St/p62Nxm7tui5DumW/YXnqWWTc1AQYitk/cRb6Et6K', 'MERCHANT'),        -- 8419thick --
  ('Philip',  'Lopez',      'philip',   '$2a$10$pTtntPPN1KPRiIFKMrtbaek8YqSrcNA4ZOe/d.LEoA1DRlSLLaViG', 'CASHIER'),         -- 35linux --
  ('Kevin', 	'Simmons',    'kevin', 	  '$2a$10$Y6Dmhy6kTpV/P48zh8w0TOuMdav3BbzP1BB1TiTS8fPiHxMyw3SzG', 'CASHIER'),         -- floor67 --
  ('Steve', 	'Henderson',  'steve', 	  '$2a$10$/eZZeU5gUxiix4qCkr24A.436DBSLPj8lhtNyXz25eR/md.RDVjQy', 'SENIOR_CASHIER'),  -- 50sentence --
  ('Randy', 	'Gonzales',   'randy', 	  '$2a$10$ajQer3NToBGltqayNHwOZO/Y6WWFek4xf5YHjElW9EhGvgOSJNz9e', 'CASHIER'),         -- 18particular --
  ('Jose',  	'Roberts',    'jose',  	  '$2a$10$khUAQxSiSiQ9VyXgPrsdPe4Td258Gibb6xhu7E/zBdG/i1Ie01m9K', 'CASHIER'),         -- length56 --
  ('Edward',  'Lewis',      'edward',   '$2a$10$kRzplHObXOvGLVw85ZGJfOzOTLKYSMmLiPDTsm26vtCAWnW/retKK', 'CASHIER'),         -- drop32 --
  ('Maurice',	'Tucker',     'maurice',  '$2a$10$HSxagXhq70rmSB/W3p212.mTAvmgZ6uoYbxn/KoSNrdsBiZ3LguXu', 'CASHIER'),         -- speech12 --
  ('Cody',	  'Rodriquez',  'cody',	    '$2a$10$iEhAW.gxzoUZBodGAEfSvuwvrE4BrpksR00cXzpblDzfgleNQr5Wm', 'CASHIER'),         -- able2 --
  ('Dean',	  'Lee',        'lee',	    '$2a$10$.pdoAVXMaZ/1gEYXjiq2cuTT4/583wp.O6ANj2mBBCXrdAtm8MB4u', 'SENIOR_CASHIER'),  -- while26 --
  ('Drew',	  'Mcguire',    'drew',	    '$2a$10$fs8cRhXY60YSGMPHX64wkuHhs7OybPdqZTC4B2YlwAWXuZ/uG2uyq', 'CASHIER'),         -- center65 --
  ('John',	  'Peterson',   'john',	    '$2a$10$tWuZQKkZ.R5TFhIqSb5uKOBmgfSAxQn3jJm2EALlz8ozRYppiFEPi', 'CASHIER'),         -- there36 --
  ('Tracy',	  'Padilla',    'tracy',	  '$2a$10$8IBzE/fcf2WWGWJj3E.rJ.I5qHe7U.lN34EL7xw05hkqa8EpIgcLO', 'CASHIER');         -- guide19 --

INSERT INTO `check` (date_time, cash_payments, cashless_payments, employee_id, check_type) VALUES
  ('2018-05-21T19:31:59', 55350, 0, 2, 'NORMAL'),
  ('2018-05-21T19:39:04', 9670, 0, 2, 'NORMAL'),
  ('2018-05-21T19:39:20', 12770, 0, 3, 'ALTERED'),
  ('2018-05-21T19:39:28', 13730, 0, 2, 'NORMAL'),
  ('2018-05-21T19:39:33', 2090, 0, 2, 'NORMAL'),
  ('2018-05-21T19:39:37', 11580, 0, 6, 'NORMAL'),
  ('2018-05-21T19:39:41', 6270, 0, 2, 'CANCELED'),
  ('2018-05-21T19:39:51', 11640, 0, 7, 'ALTERED'),
  ('2018-05-21T19:40:15', 11028, 0, 7, 'ALTERED'),
  ('2018-05-21T19:40:28', 7635, 0, 8, 'NORMAL'),
  ('2018-05-21T20:23:35', 21110, 0, 2, 'NORMAL'),
  ('2018-05-21T20:48:16', 11670, 0, 2, 'ALTERED'),
  ('2018-05-21T20:48:20', 6990, 0, 2, 'NORMAL'),
  ('2018-05-21T20:48:22', 5980, 0, 2, 'NORMAL'),
  ('2018-05-21T20:48:35', 44850, 0, 2, 'CANCELED'),
  ('2018-05-21T20:48:43', 2090, 0, 2, 'NORMAL'),
  ('2018-05-21T20:48:54', 923, 0, 2, 'NORMAL'),
  ('2018-05-21T20:49:01', 6675, 0, 2, 'NORMAL'),
  ('2018-05-21T20:49:15', 11190, 0, 2, 'NORMAL'),
  ('2018-05-21T20:49:26', 5341, 0, 2, 'CANCELED'),
  ('2018-05-21T20:49:47', 22000, 0, 2, 'NORMAL'),
  ('2018-05-21T20:50:01', 2090, 0, 2, 'NORMAL'),
  ('2018-05-21T20:50:14', 69970, 0, 2, 'NORMAL'),
  ('2018-05-21T20:50:22', 24165, 0, 2, 'NORMAL'),
  ('2018-05-21T20:50:26', 5980, 0, 2, 'NORMAL'),
  ('2018-05-21T20:50:37', 17195, 0, 2, 'NORMAL'),
  ('2018-05-21T20:50:50', 2130, 0, 2, 'ALTERED'),
  ('2018-05-21T20:51:01', 14815, 0, 2, 'CANCELED'),
  ('2018-05-21T20:51:28', 0, 18200, 2, 'ALTERED'),
  ('2018-05-21T20:51:38', 8950, 0, 2, 'ALTERED'),
  ('2018-05-21T20:51:47', 7650, 0, 2, 'ALTERED'),
  ('2018-05-21T20:51:54', 8550, 0, 2, 'NORMAL'),
  ('2018-05-21T20:52:02', 0, 2360, 2, 'NORMAL'),
  ('2018-05-21T20:52:15', 0, 2850, 2, 'NORMAL'),
  ('2018-05-21T20:52:23', 3405, 0, 2, 'NORMAL'),
  ('2018-05-21T20:52:47', 2510, 0, 2, 'ALTERED'),
  ('2018-05-21T20:52:56', 0, 3765, 2, 'NORMAL'),
  ('2018-05-21T20:53', 7580, 0, 2, 'NORMAL'),
  ('2018-05-21T21:01:01', 17875, 0, 2, 'ALTERED'),
  ('2018-05-21T21:01:11', 1810, 0, 2, 'NORMAL'),
  ('2018-05-21T21:01:17', 5100, 0, 2, 'CANCELED'),
  ('2018-05-21T21:01:21', 2000, 0, 2, 'CANCELED'),
  ('2018-05-21T21:01:39', 9760, 0, 2, 'NORMAL'),
  ('2018-05-21T21:02:46', 6026, 0, 2, 'NORMAL'),
  ('2018-05-21T21:02:51', 5250, 0, 2, 'NORMAL'),
  ('2018-05-21T21:02:55', 2840, 0, 2, 'NORMAL'),
  ('2018-05-21T21:03:04', 11190, 0, 2, 'NORMAL'),
  ('2018-05-21T21:03:10', 0, 28950, 2, 'NORMAL'),
  ('2018-05-21T21:03:16', 13560, 0, 2, 'CANCELED'),
  ('2018-05-21T21:03:52', 0, 114650, 2, 'NORMAL'),
  ('2018-05-21T21:04:06', 0, 4100, 2, 'ALTERED'),
  ('2018-05-21T21:04:10', 11640, 0, 2, 'CANCELED'),
  ('2018-05-21T21:04:31', 5595, 0, 2, 'ALTERED'),
  ('2018-05-21T21:04:36', 7650, 0, 2, 'NORMAL'),
  ('2018-05-21T21:04:42', 27470, 0, 2, 'NORMAL'),
  ('2018-05-21T21:04:50', 0, 3900, 2, 'NORMAL');
-- 9999-12-31 23:59:59

INSERT INTO `check_product` (check_id, product_id, quantity, price) VALUES
  (1, 10, 5, 2550),
  (1, 21, 2, 5657),
  (1, 23, 32, 923),
  (1, 34, 1, 1750),
  (2, 2, 1, 2090),
  (2, 5, 2, 3790),
  (3, 5, 3, 3790),
  (3, 100, 2, 700),
  (4, 2, 1, 2090),
  (4, 3, 2, 5820),
  (5, 2, 1, 2090),
  (6, 4, 2, 5790),
  (7, 2, 3, 2090),
  (8, 3, 2, 5820),
  (9, 2, 1, 2090),
  (9, 22, 1, 8938),
  (10, 2, 1, 2090),
  (10, 5, 1, 3790),
  (10, 120, 1, 1755),
  (11, 1, 2, 2990),
  (11, 2, 1, 2090),
  (11, 3, 2, 5820),
  (11, 100, 2, 700),
  (12, 3, 1, 5820),
  (12, 123, 3, 1950),
  (13, 32, 2, 3495),
  (14, 1, 2, 2990),
  (15, 123, 23, 1950),
  (16, 2, 1, 2090),
  (17, 23, 1, 923),
  (18, 89, 3, 2225),
  (19, 112, 2, 5595),
  (20, 23, 2, 923),
  (20, 32, 1, 3495),
  (21, 2, 4, 2090),
  (21, 4, 2, 5790),
  (21, 47, 2, 1030),
  (22, 2, 1, 2090),
  (23, 1, 23, 2990),
  (23, 99, 2, 600),
  (24, 4, 2, 5790),
  (24, 6, 3, 4195),
  (25, 1, 2, 2990),
  (26, 9, 2, 5800),
  (26, 66, 3, 1865),
  (27, 55, 3, 710),
  (28, 6, 3, 4195),
  (28, 67, 2, 1115),
  (29, 6, 4, 4195),
  (29, 92, 2, 710),
  (30, 54, 1, 8950),
  (31, 10, 3, 2550),
  (32, 106, 3, 2850),
  (33, 104, 2, 1180),
  (34, 105, 1, 2850),
  (35, 111, 3, 1135),
  (36, 39, 2, 1255),
  (37, 37, 3, 1255),
  (38, 5, 2, 3790),
  (39, 2, 2, 2090),
  (39, 10, 2, 2550),
  (39, 13, 2, 2550),
  (39, 32, 1, 3495),
  (40, 26, 1, 1810),
  (41, 14, 2, 2550),
  (42, 15, 2, 1000),
  (43, 5, 2, 3790),
  (43, 109, 2, 1090),
  (44, 2, 1, 2090),
  (44, 20, 2, 1968),
  (45, 33, 3, 1750),
  (46, 55, 4, 710),
  (47, 112, 2, 5595),
  (48, 4, 5, 5790),
  (49, 1, 2, 2990),
  (49, 5, 2, 3790),
  (50, 12, 2, 2550),
  (50, 24, 42, 1600),
  (50, 34, 23, 1750),
  (50, 42, 1, 2100),
  (51, 43, 2, 2050),
  (52, 3, 2, 5820),
  (53, 66, 3, 1865),
  (54, 12, 3, 2550),
  (55, 5, 3, 3790),
  (55, 53, 23, 700),
  (56, 123, 2, 1950);

INSERT INTO z_report (money_put_in_cash_machine, seized_money, cash_payments, cashless_payments, canceled_cash_payments,
                      canceled_cashless_payments, canceled_checks_count, checks_count, date_time) VALUES
(2250, 382046, 384296, 27175, 71276, 0, 4, 38, '2018-05-21T20:59:46'),
(2250, 27195, 29445, 0, 7100, 0, 2, 5, '2018-05-21T21:02:33'),
(2250, 8090, 38866, 28950, 0, 0, 0, 6, '2018-05-21T21:03:19'),
(2250, 38465, 40715, 122650, 11640, 0, 1, 7, '2018-05-21T21:05:01');
