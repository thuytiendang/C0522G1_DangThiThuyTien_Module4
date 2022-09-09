<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/9/2022
  Time: 4:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<h1>English-Vietnamese Dictionary</h1>
<form action="/search" method="get">
    <input type="text" name="word" placeholder="Input word">
    <button type="submit" value="submit">Search</button>
    <p>${result}</p>
</form>
</body>
</html>
