<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a new Hand</title>
</head>
<body>
<form action = "createNewListServlet" method="post">
Hand Name: <input type ="text" name = "listName"><br />
Creation date: <input type ="text" name = "month" placeholder="mm"
size="4"> <input type ="text" name = "day" placeholder="dd"
size="4">, <input type ="text" name = "year" placeholder="yyyy"
size="4">
holder Name: <input type = "text" name = "holderName"><br />
Available cards:<br />
<select name="allCardsToAdd" multiple size="6">
<c:forEach items="${requestScope.allCards}" var="currentcard">
 <option value = "${currentcard.getId()}">${currentcard.getName()} |
${currentitem.getType()} | ${currentcard.getManaCost()}</option>
</c:forEach>
</select>
<br />
<input type = "submit" value="Create Hand and Add Cards">
</form>
<a href = "index.html">Go add new Cards instead.</a>
</body>
</html>