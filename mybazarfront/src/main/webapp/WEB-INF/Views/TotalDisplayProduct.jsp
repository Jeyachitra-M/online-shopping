<%@ page language="java" contentType="text/html"%>
<%@include file="Header.jsp" %>
<html>
<body>
<div class="container">
<table class="table">
<tr>
<td rowspan="9">
<img src="<c:url value="/resources/images/${product.productId}.jpg"/>" width="300" height="300">
</td>
</tr>
<tr>
<td>Product Id</td>
<td>${product.productId}
</td>
</tr>
<tr>
<td>Product Name</td>
<td>${product.productName}
</td>
</tr>
<tr>
<td>Price</td>
<td>${product.price}
</td>
</tr>
<tr>
<td>Shop</td>
<td>${supplier}
</td>
</tr>
<tr>
<td>Stock</td>
<td>${product.stock}
</td>
</tr>
<tr>
<td>Category</td>
<td>${category}
</td>
</tr>
<form action="<c:url value="/Addtocart/${product.productId}"/>" method="post">
<tr>
<td>Quantity</td>
<td>
<select name="quantity" class="form-control btn-block">
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
</select>
</td>
</tr>
<tr>
<td colspan="2">
<input type="submit" value="AddToCart" class="btn btn-info btn-block"/>
</td>
</tr>
</form>
</table>
</div>
</bocy>
</html>