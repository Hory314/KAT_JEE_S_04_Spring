<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Title</title>
</head>
<body>
<c:if test="${exist}">
    <ul>
        <li>ID: ${drink.id}</li>
        <li>Nazwa: ${drink.name}</li>
        <li>Moc: ${drink.vol}</li>
        <li>Opis: ${drink.description}</li>
        <li>Kategoria: ${drink.category.name}</li>
    </ul>
    <p><a href="/drinks/edit/${drink.id}" style="color: blue;">Edytuj</a></p>
    <p><a href="/drinks/delete/${drink.id}" style="color: red">Usuń</a></p>
</c:if>
<c:if test="${not exist}">
    <h1>404</h1>
    <p>Nie ma takiego drinka.</p>
</c:if>
<hr>
<p><a href="/drinks">Lista drinków</a></p>
<p><a href="/drinks/add">Dodaj drinka</a></p>
</body>
</html>
