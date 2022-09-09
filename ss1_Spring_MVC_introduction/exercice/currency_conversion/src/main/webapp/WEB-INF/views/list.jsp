<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/9/2022
  Time: 3:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CURRENCY CONVERSION</title>
</head>
<body>
<form action="/exchange" method="get">
<input value="usd" type="number" name="money" placeholder="Input money">
    <button type="submit">change</button>
<input value="${result}" type="number" disabled>
</form>
</body>
</html>
