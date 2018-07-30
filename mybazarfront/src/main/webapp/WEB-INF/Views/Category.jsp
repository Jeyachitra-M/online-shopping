<%@ page language="java" contentType="text/html"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="Header.jsp" %>
<br><br><br><br>
<div class="container">
<c:if test="${flag}">
<form action="<c:url value="/updateCategory"/>" method="post" class="table">
<table align="center">
<tr>
<td>Category Id</td>
<td><input type="text" name="catid" value="${categoryData.categoryId}" readonly/></td>
</tr>
<tr>
<td>Category Name</td>
<td><input type="text" name="catname" value="${categoryData.categoryName}"/></td>
</tr>
<tr>
<td>Category Description</td>
<td><input type="text" name="catDesc" value="${categoryData.categoryDesc}"/></td>
</tr>
<tr>
<td colspan="3">
<center>
<input type="submit" value="UpdateCategory"/>
</center>
	</td>
	</tr>

</table>

</form>
</c:if>

<c:if test="${!flag}">
<form action="<c:url value="/InsertCategory"/>" method="post">
<table align="center">
<tr>
<td>Category Name</td>
<td><input type="text" name="catname"/></td>
</tr>
<tr>
<td>Category Description</td>
<td><input type="text" name="catDesc"/></td>
</tr>
<tr>
<td colspan="3">
<center>
<input type="submit" value="Insert category"/>
</center>
	</td>
	</tr>

</table>

</form>
</c:if>

<table align="center" class="table">
<tr bgcolor="lightblue">
<td>Category Id</td>
<td>Category Name</td>
<td>Category Description</td>
<td colspan="6">Operation</td>
</tr>
<c:forEach items="${categorylist}" var="cat">
<tr>
<td>${cat.categoryId}</td>
<td>${cat.categoryName}</td>
<td>${cat.categoryDesc}</td>
<td colspan="5">
<a href="<c:url value='/deleteCategory/${cat.categoryId}'/>">Delete</a>
</td>
<td colspan="5">
<a href="<c:url value='/editCategory/${cat.categoryId}'/>">Edit</a>
</td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>