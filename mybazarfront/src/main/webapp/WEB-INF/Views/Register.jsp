   <%@include file="Header.jsp" %>

<%@ page language="java" contentType="text/html" %>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="./resources/css/bg.css">
<link rel="stylesheet" href="./resources/css/caroualresponsive.css">



<title>Registration Page</title>
</head>
<body>

<BR>
<BR>
<BR>
	
	<h2>Registration  </h2>
	<hr>
	 
	<center>
	<form action="registration">
  <div class="containers">
  <table>
  <tr>
    <td><label><b>Customer Name</b></label></td><td>
    <input type="text" placeholder="Enter customername" name="customername" required><td>
    </tr><tr><BR>
     
    <td>
    <label><b>UserName</b></label></td><td>
    <input type="text" placeholder="Enter User Name" name="username" required><td>
   </tr>
    
    <tr>
    <td>
    <label><b>Password</b></label></td><td>
    <input type="password" placeholder="Enter Password" name="password" required><td>
	</tr>
	     
   
    
    <tr>
    <td>
    <label><b>Email</b></label></td><td>
    <input type="text" placeholder="Enter Email" name="email" required><td>
	</tr>
 
    <tr>
    <td><label><b>Phone</b></label></td>
	<td><input type="text" placeholder="Enter Phone Number" name="phone" required></td>
	</tr>
	 
    <tr>
    <td><label><b>City</b></label></td>
	<td><input type="text" placeholder="Enter Address" name="address" required></td>
	</tr>
	 
    
  
   </table>
   <BR>
   <BR>
   

    <div class="clearfix">
     <!--  <button type="button" class="loginbtn" >Cancel</button>
      <button type="submit" class="loginbtn" >Register!</button> -->
      <button type="submit" class="btn btn-success">Register !</button>
      <button type="button" class="btn btn-warning">Cancel</button>
    </div>
  </div>
</form>
</center>
		<jsp:include page="Footer.jsp" />
	
</body>
</html>