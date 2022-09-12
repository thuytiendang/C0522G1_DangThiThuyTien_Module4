<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/9/2022
  Time: 11:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich Taste</title>
</head>
<body>
<h1 style="color: red">SANDWICH CONDIMENTS</h1>
<form action="/save" method="get">
    <input type="checkbox" value="Lettuce" name="condiment"><b>Lettuce</b>
    <input type="checkbox" value="Tomato" name="condiment"><b>Tomato</b>
    <input type="checkbox" value="Mustard" name="condiment"><b>Mustard</b>
    <input type="checkbox" value="Sprouts" name="condiment"><b>Sprouts</b>
    <hr>
    <button type="submit">SAVE</button>
    <c:forEach items="${condiment}" var="cond">
        <p>${cond}</p>
    </c:forEach>
</form>
</body>
</html>
