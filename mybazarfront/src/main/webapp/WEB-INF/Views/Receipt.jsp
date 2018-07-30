<%@ page language="java" contentType="text/html" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="Header.jsp" %>

<body>
<br><br><br><br>
<div class="container">
<table class="table">
<tr bgcolor="lightblue">
<td colspan="6"><center><h2> Receipt </h2></center></td>
</tr>
<tr>
<td>Order Id</td>
<td>ORD000${orderDetail.orderId}</td>
<td> Order Date </td>
<td>${orderDetail.orderDate}</td>
</tr>
<tr bgcolor="lightgreen">
<td>Product Name</td>
<td>Quantity</td>
<td>Price</td>
<td>DeliveryCharge</td>
<td>Total Price</td>
</tr>
<c:if test="${empty cartItem}">
<tr>
<td colspan="6"><center>Your cart is empty!!!!!!!</center></td></tr>
</c:if>
<c:if test="${not empty cartItem}">
<c:forEach items="${cartItem}" var="cartItem">
<form action="<c:url value="/updateCartItem/${cartItem.cartItemId}"/>" method="get">
<tr>
<td>${cartItem.productName}</td>
<td><"${cartItem.quantity}"/></td>
<td>${cartItem.price}</td>
<td> 50 </td>
<td>${cartItem.quantity*cartItem.price}</td>
</tr>
</form>
</c:forEach>
</c:if>
<tr bgcolor="pink">
<td colspan="4"> Total Purchase Amount </td>
<td colspan="2">${totalPurchaseAmount}</td>
</tr>

<tr bgcolor="Green">
<td colspan="1"><a href="<c:url value="/ok"/>" class="btn btn-info">Ok</a></td> 

</tr>

</table>

</div>


</body>
</html>