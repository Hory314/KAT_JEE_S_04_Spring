<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Title</title>
</head>
<body>
<c:if test="${exist}">
    <form action="/drinks/add" method="post"> <%-- obsluguje tez edycje --%>
        <p><input type="text" name="name" value="${drink.name}" placeholder="Nazwa"></p>
        <p><input type="text" name="vol" value="${drink.vol}" placeholder="Moc"></p>
        <p><textarea name="description" placeholder="Opis">${drink.description}</textarea></p>
        <p><select name="category_id">
            <c:forEach var="category" items="${categories}">
                <option value="${category.id}"
                        <c:if test="${category.id == drink.category.id}">selected</c:if>>${category.name}</option>
            </c:forEach>
        </select></p>
        <input type="hidden" name="id" value="${drink.id}">
        <p><input type="submit" value="Dodaj drinka"></p>
    </form>
</c:if>
<c:if test="${not exist}">
    <h1>404</h1>
    <p>Nie ma takiego drinka.</p>
</c:if>
<p><a href="/drinks">Lista drinków</a></p>
</body>
</html>
