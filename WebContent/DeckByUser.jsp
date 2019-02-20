<%@ page language="java" contentType="text/html; charset=UTF-8"
 	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Deck List</title>
</head>
<body>
<form method = "post" action = "HolderNavigation">
<table>
<c:choose>
<c:when test="${requestScope.AllDecks==' '}">
<tr>
<td>No Decks Found</td>
</tr>
</c:when>
<c:otherwise>
<c:forEach items="${requestScope.AllDecks}" var="currentdeck">
<tr>
<td><input type="radio" name="id" value="${currentdeck.getId()}"></td>
 <td><h2>${currentdeck.getDeckName()}</h2></td></tr>
 <tr><td colspan="3">Hand Created: ${currentdeck.getDeckCreated()}</td></tr>
 <tr><td colspan="3">Holder:${currentdeck.getHolder().getHolderName()}</td></tr>
<c:forEach var = "cardVal" items = "${currentdeck.getListOfCards()}">
	<tr><td></td><td colspan="3">
		${cardVal.getName()}, ${cardVal.getType()},${cardVal.getManaCost()}
			</td>
 		</tr>
	</c:forEach>
</c:forEach>
</c:otherwise>
</c:choose>
</table>
<input type = "submit" value = "edit" name="doThisToItem">
<input type = "submit" value = "delete" name="doThisToItem">
<input type="submit" value = "add" name = "doThisToItem">
</form>
<a href="NewDeckServlet">Create a new Deck</a>
<a href="index.html">Insert a new Card</a>
</body>
</html>