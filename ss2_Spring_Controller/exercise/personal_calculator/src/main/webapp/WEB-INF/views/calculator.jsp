<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/9/2022
  Time: 2:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form action="/calculate" method="get">
    <table>
        <tr>
            <th style="color: seagreen" colspan="4">Calculator</th>
        </tr>
        <tr>
            <td colspan="2"><input type="text" name="number1" placeholder="input a number"></td>
            <td colspan="2"><input type="text" name="number2" placeholder="input a number"></td>
        </tr>
        <tr>
            <td>
                <button type="submit" name="calculator" value="addition">Addition(+)</button>
            </td>
            <td>
                <button type="submit" name="calculator" value="subtraction">Subtraction(-)</button>
            </td>
            <td>
                <button type="submit" name="calculator" value="multiplication">Multiplication(x)</button>
            </td>
            <td>
                <button type="submit" name="calculator" value="division">Division(/)</button>
            </td>
        </tr>
        <tr>
            <td>Result:</td>
            <td colspan="3">${result}</td>
        </tr>
    </table>
</form>
</body>
</html>
