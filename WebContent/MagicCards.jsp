<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MagicCards</title>
</head>
<body>
<form method = "post" action = "navigation">
<table>
<c:choose>
<c:when test="${requestScope.AllCards==' '}">
<tr>
<td>No Cards Found</td>
</tr>
</c:when>
<c:otherwise>
<c:forEach items="${requestScope.AllCards}" var="currentcard">
<tr>
 <td><input type="radio" name="id" value="${currentcard.getId()}"></td>
 <td>${currentcard.getName()}</td>
 <td>${currentcard.getType()}</td>
 <td>${currentcard.getManaCost()}</td>
 </tr>
</c:forEach>
</c:otherwise>
</c:choose>
</table>
<input type = "submit" value = "edit" name="doThisToCard">
<input type = "submit" value = "delete" name="doThisToCard">
<input type="submit" value = "add" name = "doThisToCard">
</form>
</body>
</html>