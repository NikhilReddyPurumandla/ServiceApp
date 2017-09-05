# ServiceApp
An web application for proving support functionality
ServiceApp is j2ee based web application used for recieving request from customer and solving them.
Pre requisites:
Database : Mysql
jdk : 1.8
Eclipse IDE:Oxygen or Neon version.
The project is built as a maven project.
Execution Flow:
1.The Execution starts from index.jsp, where the admin has several options like ,
   a. Add Customer,
   b. View Customer,
   c. View Service.
2. When ever any service is needed, customer contacts the service provider (admin).
3. Admin enters the details and service request of customer into this application.
4.Admin can edit and update details of customer and customer's requests.
5.After the service is provided, admin closes the request ticket and then that particular ticket is removed from "ViewServiceServlet" page.
6.The "ViewCustomerServlet" page shows the details of the customers who laid a ticket for service.
