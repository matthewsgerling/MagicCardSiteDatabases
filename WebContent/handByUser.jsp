<%@ page language="java" contentType="text/html; charset=UTF-8"
 	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Lists</title>
</head>
<body>
<form method = "post" action = "">
<table>
<c:forEach items="${requestScope.AllCards}" var="currentcard">
<tr>
<td><input type="radio" name="id" value="${currentcard.getId()}"></td>
 <td><h2>${currentcard.getHandName()}</h2></td></tr>
 <tr><td colspan="3">Hand Created: ${currentcard.getHandCreated()}</td></tr>
 <tr><td colspan="3">Holder:${currentcard.holder.getHolderName()}</td></tr>
<c:forEach var = "cardVal" items = "${currentcard.magiccards}">
	<tr><td></td><td colspan="3">
		${cardVal.name}, ${cardVal.type},${cardVal.manacost}
			</td>
 		</tr>
	</c:forEach>
</c:forEach>
</table>
<input type = "submit" value = "edit" name="doThisToItem">
<input type = "submit" value = "delete" name="doThisToItem">
<input type="submit" value = "add" name = "doThisToItem">
</form>
<a href="AddCards">Create a new Hand</a>
<a href="index.html">Insert a new Card</a>
</body>
</html>