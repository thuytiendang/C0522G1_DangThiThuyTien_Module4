<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 13/9/2022
  Time: 2:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<h3>SETTINGS</h3>
<form:form action="/update" method="post" modelAttribute="electronicEmail">
    <table>
        <tr>
            <form:hidden path="id"/>
            <td>Languages</td>
            <td>
                <form:select path="language">
                    <form:option value="English"/>
                    <form:option value="Vietnamese"/>
                    <form:option value="Japanese"/>
                    <form:option value="Chinese"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>Page Size:</td>
            <td>
                Show
                <form:select path="pageSize">
                    <form:option value="5"/>
                    <form:option value="10"/>
                    <form:option value="15"/>
                    <form:option value="25"/>
                    <form:option value="50"/>
                    <form:option value="100"/>
                </form:select>
                 emails per page
            </td>
        </tr>
        <tr>
            <td>Spams filter:</td>
            <td>
                <form:checkbox path="spamsFilter" label="Enable spams filter"/>
            </td>
        </tr>
        <tr>
            <td>Signature: </td>
            <td><form:textarea path="signature"/></td>
        </tr>
        <tr>
            <td></td>
            <td><form:button>Update</form:button></td>
        </tr>
    </table>
</form:form>
</body>
</html>
