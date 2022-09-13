<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 13/9/2022
  Time: 2:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
        crossorigin="anonymous"></script>
<html>
<head>
    <title>Electronic Email</title>
</head>
<body>
<h1 style="color: green">Electronic Email</h1>
<h3 style="color: green">${mess}</h3>
<table class="table table-striped">
    <tr>
        <td>Number</td>
        <td>Language</td>
        <td>Page Size</td>
        <td>Spams filter</td>
        <td>Signature</td>
        <td>edition</td>
    </tr>
    <c:forEach var="email" items="${electronicEmailList}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${email.language}</td>
            <td>${email.pageSize}</td>
            <td>
                <c:if test="${email.spamsFilter == true}">
                    <p>Enable spams filter</p>
                </c:if>
                <c:if test="${email.spamsFilter == false}">
                    <p>Prevent spams filter</p>
                </c:if>
            </td>
            <td>${email.signature}</td>
            <td>
                <a href="/update?id=${email.id}">
                    <button>Update</button>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
