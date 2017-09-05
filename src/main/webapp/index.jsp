<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	  <%
  response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);



 
  %> 
<style>
<link href="https://fonts.googleapis.com/css?family=Indie+Flower" rel="stylesheet"> 
.navbar
{
width:100%; background-color:teal; height:55px;
font-family: 'Indie Flower', cursive;
}
.dropbtn {
    background-color:teal;
    color: white;
    padding: 16px;
    font-size: 16px;
}
.right{
	float: right;			
}
.a{
font-family: 'Indie Flower', cursive;
}			
.rightbar{
	background-color: teal;				
	width: 20%;	
	padding: 25px;
	height:10cm;
						
	}
			
.container{
	margin-left: 20px;
	padding: 10px;				
	width: 100%;	
			
	}
body{
background-repeat:repeat;
background-size:100%;
}
</style>
</head>
<body background="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQGp25MOfvTKpR18RKfSx7vbF4A3HayFaPrEBatJCZi5skpdR9FSQ" >
<br>

<div class="navbar">

<a href=index.jsp><button class="dropbtn">Home</button></a>
<a href=AddCustomer.jsp ><button class="dropbtn">AddCustomers</button></a>
<a href="ViewCustomersServlet"><button class="dropbtn">View Customers</button></a>

<a href="ViewServiceServlet"><button class="dropbtn">view service request</button></a>




</div>
<br>
<br><br><br>
<h1>Welcome to Request handling portal</h1>
</body>

</html>