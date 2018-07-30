<%@ page language="java" contentType="text/html"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<%@include file="Header.jsp" %>
<!--  
<nav class="navbar navbar-inverse">
  <div class="container">
  <div class="navbar-header">
  <a class="navbar-brand" href="#">Mybazar</a></div>
    <ul class="nav navbar-nav">
      <li><a href="home">Home</a></li>
<li><a href="displayProduct">Display Product</a>
</li>
</ul>
</div>
</nav>
-->
<br><br><br>
<c:forEach items="${productlist}" var="product">
<div class="row">
   
   <div class="col-sm-6 col-md-4">
      <div class="thumbnail">
      <h4>
      <span data-toggle="tooltip">${product.productName} &nbsp; Rs.${product.price}/-</span>
      </h4>
    <img src="<c:url value="/resources/images/${product.productId}.jpg"/>" width="100" height="100" alt = "Image not supported">
      <a href="<c:url value="/totalProductInfo/${product.productId}"/>" class="btn btn-primary col-xs-12" role="button">Show this product</a>
      <div class="clearfix"></div>
      
      </div>
      </div>
   </c:forEach> 
</body>
</html>
