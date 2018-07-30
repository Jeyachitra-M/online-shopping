<%@ page language="java" contentType="text/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="Header.jsp" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<body>
<br><br><br><br>
<div class="container">
<form:form action="productInsert" modelAttribute="product1" method="post" enctype="multipart/form-data">
<table align="center" cellspacing="3" class="table">
<tr align="center" bgcolor="pink">
<td colspan="2">Product Manage</td>
</tr>
<tr>
<td> Product Name</td>
<td> <form:input path="productName"/></td>
</tr>
<tr>
<td> Product Description</td>
<td><form:input path="productDesc"/></td>
</tr>
<tr>
<td>Price</td>
<td><form:input path="price"/></td>
</tr>
<tr>
<td> Stock Available</td>
<td><form:input path="stock"/></td>
</tr>
<tr>
<td> Category </td>
<td>
<form:select path="categoryId">
<form:option value="0" label="Select List"/>
<form:options items="${categoryList}"/>
</form:select>
</td>
</tr>
<tr>
<td> Supplier </td>
<td><form:select path="supplierId">
<form:option value="0"  label="Select List"/>
<form:options items="${supplierlist}"/>
</form:select>
</td>
</tr>
<tr>
<td> Product Image</td>
<td><form:input type="file" path="pimage"/></td>
</tr>
<tr>

<td colspan="2">

<center><input type="submit" value="InsertProduct" class="btn btn-info"/></center></td>
</tr>
</table>
</form:form>
<table align="center" class="table">
<tr bgcolor="pink">
<td>Product Id</td>
<td>Product Name</td>
<td>Product Description</td>
<td>Price</td>
<td>Stock</td>
<td>Category</td>
<td>Supplier</td>
<td>Operation</td>
</tr>
<c:forEach items="${productList}" var="p">
<tr>
<td>${p.productId}</td>
<td>${p.productName}</td>
<td>${p.productDesc}</td>
<td>${p.price}</td>
<td>${p.stock}</td>
<td>${p.categoryId}</td>
<td>${p.supplierId}</td>
<td colspan="2">
<a href="<c:url value='/deleteProduct/${p.productId}'/>">Delete</a>
<a href="<c:url value='/editProduct/${p.productId}'/>">Edit</a>
</td>
</tr>
</c:forEach>


</table>

</div></body>
</html>