# cash-machine
Cash-Machine is the cash register system. 

***Cashier*** can open the check, add selected products by code from the database (parsley = 234, bread = 222) or by name, enter number of products or weight. Close check. 

***Senior cashier*** can cancel the check, cancel one item in the check and return the money to the customer.
Make *X and Z reports*.

***Product expert*** can create new products and enter their quantity in the warehouse.

# Author
**Nikita Guchenko** - [NikFanton](https://github.com/NikFanton)

# Database setup
1. Create database with name.
2. Set database properties in resource file ``database/config.properties``
3. Initialize database using resource file [initdb.sql](https://github.com/NikFanton/cash-machine/blob/master/src/main/resources/database/initdb.sql) ``database/initdb.sql``

# Run project

1. Istall maven http://www.apache-maven.ru/install.html
2. Enter command "mvn tomcat7:run"
3. Open browser and follow the link http://localhost:8084/