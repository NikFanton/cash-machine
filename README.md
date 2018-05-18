# cash-machine
Cash-Machine is the cash register system. 

***Cashier*** can open the check, add selected products by code from the database (parsley = 234, bread = 222) or by name, enter number of products or weight. Close check. 

***Senior cashier*** can cancel the check, cancel one item in the check and return the money to the customer.
Make *X and Z reports*.

***Product expert*** can create new products and enter their quantity in the warehouse.

# Author
**Nikita Guchenko** - [NikFanton](https://github.com/NikFanton)

# Run project

1. Istall maven http://www.apache-maven.ru/install.html
2. In project directory open PowerShell
3. Enter command "mvn tomcat7:run"
4. Open browser and follow the link http://localhost:8084/
End with an example of getting some data out of the system or using it for a little demo