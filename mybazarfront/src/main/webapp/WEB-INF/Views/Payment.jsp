<%@ page language="java" contentType="text/html" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="Header.jsp" %>

<body>
<br><br><br><br>
<div class="container">
<table class="table">
<tr>
<td colspan="6"><center><h2> Your Order </h2></center></td>
</tr>
<tr bgcolor="pink">
<td colspan="4"> Total Purchase Amount </td>
<td colspan="2">Rs.${totalPurchaseAmount}/-</td>
</tr>
<br/>
<div class="container">
<form action="<c:url value="/paymentprocess"/>" method="post">
<table class="table" align="center">
<tr>
<td colspan="1"><center><h2> Payment Options </h2></center></td>
</tr>
<tr>
<td colspan="2">
<input type="radio" name="paymenttype" value="CC"/>Credit Card
<input type="radio" name="paymenttype" value="COD"/>Cash On Delivery
 </td>
</tr>

 <tr>
 <td> Card NO : </td>
<td>
<input type="text" name="cardno" required/>
</td>
</tr>
<tr>
 <td> CVV : </td>
<td>
<input type="text" name="cvv"/>
</td>
</tr>
<tr>
 <td>valid upto: </td>
<td>
<input type="text" name="valid"/>
</td>
</tr>
<tr>

<td colspan="3">
<input type="submit" value="Payment"/>
</td>
</tr>
</table>
</form>
</div>
</table>
</div>
</body>
</html>