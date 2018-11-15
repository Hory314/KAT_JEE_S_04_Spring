<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Title</title>
</head>
<body>
<p><a href="/drinks/add">Dodaj drinka</a></p>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Nazwa</th>
        <th>Moc</th>
        <th>Opis</th>
        <th>Kategoria</th>
    </tr>
    <c:forEach var="drink" items="${drinks}">
        <tr>
            <td>${drink.id}</td>
            <td><a href="/drinks/${drink.id}">${drink.name}</a></td>
            <td>${drink.vol}</td>
            <td>${drink.description}</td>
            <td>${drink.category.name}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
