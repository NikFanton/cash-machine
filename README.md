# cash-machine
Cash-Machine is the cash register system. 

***Cashier*** can open the check, add selected products by code from the database (parsley = 234, bread = 222), find products by name, enter number of products or weight. Close check. 

***Senior cashier*** can cancel the check, cancel one item in the check, return the money to the customer.
Make *X and Z reports*.

***Product expert*** can create new products and enter their quantity in the warehouse.

# Author
**Nikita Guchenko** - [NikFanton](https://github.com/NikFanton)

# Database setup
1. Create database with name.
2. Change database properties in resource file ``database/config.properties``
3. Initialize database using resource file [initdb.sql](https://github.com/NikFanton/cash-machine/blob/master/src/main/resources/database/initdb.sql) ``database/initdb.sql``

# Run project

1. Install maven http://www.apache-maven.ru/install.html
2. Enter command "mvn tomcat7:run"
3. Open browser and follow the link http://localhost:8084/
4. To register new employees, use an administrator account or use existing accounts
```
Administrator: 
    login: admin
    password: market1203
    
Senior cashier:
    login: irene 
    password:suit93
    
Cashier: 
    login: frank
    password: 8272clothe
    
Product expert: 
    login: eric
    password: 8419thick
```