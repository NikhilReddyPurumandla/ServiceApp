# ServiceApp
An web application for proving support functionality

ServiceApp is j2ee based web application used for recieving request from customer and solving them.

## Pre requisites:

Database : Mysql(go through Service.sql file for sql queries to create tables)

jdk : 1.8

Eclipse IDE:Oxygen or Neon version.

The project is built as a maven project.

## Execution Flow:

1.The Execution starts from index.jsp, where the admin has several options like ,
   a. Add Customer,
   b. View Customer,
   c. View Service.

2. When ever any service is needed, customer contacts the service provider (admin).

3. Admin enters the details and service request of customer into this application.

4.Admin can edit and update details of customer and customer's requests.

5.After the service is provided, admin closes the request ticket and then that particular ticket is removed from "ViewServiceServlet" page.

6.The "ViewCustomerServlet" page shows the details of the customers who laid a ticket for service.

## License
MIT License

Copyright (c) [2017] [NikhilReddyPurumandla]

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (teh "Software"), to deal in teh Software wifout restriction, including wifout limitation teh rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of teh Software, and to permit persons to whom teh Software is furnished to do so, subject to teh following conditions:

Teh above copyright notice and this permission notice shall be included in all copies or substantial portions of teh Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
