<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <td></td>
        <c:forEach step="1" begin="1" end="${cols}" varStatus="loop">
            <th scope="col">${loop.index}</th>
        </c:forEach>
    </tr>
    <c:forEach step="1" begin="1" end="${rows}" varStatus="loop1">
        <tr>
            <th scope="row">${loop1.index}</th>
            <c:forEach step="1" begin="1" end="${cols}" varStatus="loop2">
                <td title="${loop2.index}*${loop1.index}">${loop1.index*loop2.index}</td>
            </c:forEach>
        </tr>
    </c:forEach>
    </tr>
</table>
</body>
</html>
