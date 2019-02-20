<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit a Deck</title>
</head>
<body>
<form action = "EditDeckServlet" method="post">
Deck Name: <input type ="text" name = "deckName" value="${listToEdit.getDeckName()}"><br />
Creation date: <input type ="text" name = "month" placeholder="mm" size="2" value="${listToEdit.deckCreated.getMonthValue()}"> <input type ="text" name = "day" placeholder="dd" size="2" value="${listToEdit.deckCreated.getDayOfMonth()}">, <input type ="text" name = "year" placeholder="yyyy" size="4" value="${listToEdit.deckCreated.getYear()}">
Holder Name: <input type = "text" name = "holderName" value="${listToEdit.getHolder().getHolderName()}"><br />
<input type = "hidden" name = "id" value="${listToEdit.getId()}">
Current Items:<br />
<select name="currentItems" multiple size="6">
<c:forEach var = "listVal" items = "${listToEdit.listOfCards}">
          <option value = "${listVal.getId()}">${listVal.getName()} | ${listVal.getType()}</option>          
  </c:forEach>
</select>
<br />
Remaining Cards:<br />
<select name="itemsToAdd" multiple size="6">
<c:forEach items="${requestScope.allItemsToAdd}" var="currentcard">
   <option value = "${currentcard.getId()}">${currentcard.getName()} | ${currentcard.getType()}</option>
</c:forEach>
</select>

<br />
<input type = "submit" value="Edit Deck">
</form>
<a href = "index.html">Go add new cards instead.</a>
</body>
</html>