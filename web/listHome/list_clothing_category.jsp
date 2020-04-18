<%--
  Created by IntelliJ IDEA.
  User: holoi
  Date: 4/15/20
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Clothing List</title>
</head>
<body>
<h1>Clothing</h1>
<p>
    <a href="${pageContext.request.contextPath}/clothing?action=createClothing">Clothing-Manager</a>
</p>
<div>
    <form method="get" action="${pageContext.request.contextPath}/clothing">

        <button type="submit" name="action" value="search">Tìm kiếm</button>
    </form>
</div>
<table border="1">
    <tr>
        <td>Name</td>
        <td>description</td>
        <td>picture</td>
        <td>price</td>
        <td>origin</td>
        <td>category</td>
        <td>status</td>
    </tr>


    <c:forEach items='${requestScope["clothing"]}' var="clothing">
        <tr>
            <td>${clothing.getName()}</td>
            <td>${clothing.getDescription()}</td>
            <td><img src="${clothing.getPicture()}" alt="img" width="40%" height="auto"></td>
            <td>${clothing.getPrice()}</td>
            <td>${clothing.getOrigin()}</td>
            <td>${clothing.getCategory()}</td>
            <td>${clothing.getStatus()}</td>

        </tr>
    </c:forEach>
</table>
</body>
</html>

