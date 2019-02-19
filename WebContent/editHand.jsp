<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit a Hand</title>
</head>
<body>
<form action = "editExistingListServlet" method="post">
Hand Name: <input type ="text" name = "listName" value="${listToEdit.getHolderName()}"><br />
Creation date: <input type ="text" name = "month" placeholder="mm" size="4" value="${listToEdit.handCreated.getMonthValue()}"> <input type ="text" name = "day" placeholder="dd" size="4" value="${listToEdit.handCreated.getDayOfMonth()}">, <input type ="text" name = "year" placeholder="yyyy" size="4" value="${listToEdit.handCreated.getYear()}">
Holder Name: <input type = "text" name = "shopperName" value="${listToEdit.CardHolder.getHolderName()}"><br />
<input type = "hidden" name = "id" value="${listToEdit.getId()}">
Current Items:<br />
<select name="currentItems" multiple size="6">
<c:forEach var = "listVal" items = "${listToEdit.listOfItems}">
          <option value = "${listVal.getId()}">${listVal.getName()} | ${listVal.getType()}</option>          
  </c:forEach>
</select>
<br />
Remaining Cards:<br />
<select name="itemsToAdd" multiple size="6">
<c:forEach items="${requestScope.allItemsToAdd}" var="currenthand">
   <option value = "${currenthand.getId()}">${currenthand.getName()} | ${currenthand.getType()}</option>
</c:forEach>
</select>

<br />
<input type = "submit" value="Edit List and Edit Items">
</form>
<a href = "index.html">Go add new cards instead.</a>
</body>
</html>