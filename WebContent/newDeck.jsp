<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a new Deck</title>
</head>
<body>
<form action = "createNewDeck" method="post">
Deck Name: <input type ="text" name = "deckName"><br />
Creation date: <input type ="text" name = "month" placeholder="mm"
size="2"> <input type ="text" name = "day" placeholder="dd"
size="2">, <input type ="text" name = "year" placeholder="yyyy"
size="4">
Holder Name: <input type = "text" name = "holderName"><br />
Available cards:<br />
<select name="allCardsToAdd" multiple size="6">
<c:forEach items="${requestScope.AllCards}" var="currentcard">
 <option value = "${currentcard.getId()}">
 ${currentcard.getName()} |
 ${currentcard.getType()} | 
 ${currentcard.getManaCost()}
 </option>
</c:forEach>
</select>
<br />
<input type = "submit" value="Create Deck and Add Cards">
</form>
<a href = "index.html">Go add new Cards instead.</a>
</body>
</html>