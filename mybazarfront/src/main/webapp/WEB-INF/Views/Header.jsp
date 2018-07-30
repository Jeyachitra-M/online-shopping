<%@ page language="java" contentType="text/html"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page isELIgnored="false" %>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>

</head>
<body>

<!--  nav class="navbar navbar-inverse"> -->
<div class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
  <div class="navbar-header">
  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"data-target="#bs-navbar-collapse">
  	<span class="sr-only"></span>
  	<span class="icon-bar"></span>
  	<span class="icon-bar"></span>
  	<span class="icon-bar"></span>
  	
  	</button>
  <a class="navbar-brand" href="#">Mybazar</a></div>
    
    <div class="collapse navbar-collapse" id="bs-navbar-collapse">
    <ul class="nav navbar-nav navbar-left">
      <li><a href="home">Home</a></li>
      
    
    
	<c:if test="${sessionScope.loggedIn}">
		<c:if test="${sessionScope.role=='ROLE_ADMIN'}">
	<li><a href="category">Manage Category</a></li>
	<li><a href="product">Manage Product</a></li>
	</c:if>
		<c:if test="${sessionScope.role=='ROLE_USER'}">
	<li><a href="displayProduct">Display Product</a></li>
    
    </c:if>
    </c:if>    
    </ul>
    
    <ul class="nav navbar-nav navbar-right">
    <c:if test="${!sessionScope.loggedIn}">
    <li><a href="${pageContext.request.contextPath}/login"><span class="glyphicon glyphicon-log-in"></span>Login</a></li>
    <li><a href= "register"><span class="glyphicon glyphicon-user"></span>Register</a></li>
    <li><a href="contactus">ContactUs</a></li>
	<li><a href="aboutus">AboutUs</a></li>
	</c:if>
    
  <c:if test="${sessionScope.loggedIn}">
  <font color="white" face="calibri" size="3">Welcome :${username} </font>
  <a href="${pageContext.request.contextPath}/logout"><font color="white" face="calibri" size="2">Logout</font></a>
  </c:if>
  </ul>
 </div>
  </div>
 </div> 
</nav>




</body></html>