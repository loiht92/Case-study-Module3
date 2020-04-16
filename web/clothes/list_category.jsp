<%--
  Created by IntelliJ IDEA.
  User: holoi
  Date: 4/16/20
  Time: 15:38
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
<%--    //<a href="${pageContext.request.contextPath}/clothing?action=createClothing">Create new clothing</a>--%>
    <a href="${pageContext.request.contextPath}/clothing?action=createCategory">Create new category</a>
</p>
<div>
    <form method="get" action="${pageContext.request.contextPath}/clothing?action=listCategory">

        <button type="submit" name="action" value="search">Tìm kiếm</button>
    </form>
</div>
<table border="1">
    <tr>
        <td>category</td>
        <td>status</td>
        <td>action</td>
    </tr>


    <c:forEach items='${requestScope["categories"]}' var="categories">
        <tr>
            <td>${categories.getName()}</td>
            <td>${categories.getStatus()}</td>
            <td><a href="/clothing?action=editCategory&id=${categories.getId()}">edit</a></td>
            <td><a href="/clothing?action=deleteCategory&id=${categories.getId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

