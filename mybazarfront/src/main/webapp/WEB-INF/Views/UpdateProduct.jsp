<%@ page language="java" contentType="text/html"%>
<%@include file="Header.jsp" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<body>
<br><br><br><br>
<form:form action="../updateProduct/${productId}" modelAttribute="product" method="post">
<table align="center" cellspacing="3">
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
<td colspan="2">Price</td>
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
<tr>

<td colspan="2">

<center><input type="submit" value="UpdateProduct"/></center></td>
</tr>
</table>
</form:form>
</body>
</html>