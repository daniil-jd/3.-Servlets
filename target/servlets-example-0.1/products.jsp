<%--
  Created by IntelliJ IDEA.
  User: Daniil
  Date: 14.03.2018
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<style>
    td {
        text-align: center;
    }
</style>
<head>
    <title>Products</title>
</head>
<body>

    <table style="margin:auto">
        <tr>
            <td> Таблица с товарами (products) </td>
        <tr>
    </table>
    <br>
    <table>

        <tr>
            <td> Название товара </td>
            <td> Количество товаров </td>
            <td> Стоимость единицы товара </td>
        <tr>
        <c:forEach items="${products}" var="item">
            <tr>
                <td>${item.name}</td>
                <td>${item.count}</td>
                <td>${item.price}</td>
            </tr>

        </c:forEach>
    </table>
    <br>
    <%=(request.getAttribute("status"))%>

    <form action="" method = "POST" name="" value="Добавить товар (product):">
        <table>

            <tr>
                <td style="text-align: left"> Название: </td>
                <td> <input type="text" name="name"> </td>
            </tr>
            <tr>
                <td style="text-align: left"> Количество: </td>
                <td> <input type="text" name="count"> </td>
            </tr>
            <tr>
                <td style="text-align: left"> Цена: </td>
                <td> <input type="text" name="price"> </td>
            </tr>
            <tr>
                <td> </td>
                <td style="text-align: left"> <input type="submit" name="exit" value="Добавить"> </td>
            </tr>

        </table>
    </form>
</body>
</html>
