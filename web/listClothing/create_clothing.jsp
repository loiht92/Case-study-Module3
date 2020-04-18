<%--
  Created by IntelliJ IDEA.
  User: holoi
  Date: 4/15/20
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new clothing</title>
</head>
<body>

<h1 style="text-align: center">Clothing Management</h1>
<h2>
    <a href="${pageContext.request.contextPath}/clothing?action=listClothing">List All clothing</a>
</h2>

<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2 style="text-align: center">Add New clothing</h2>
            </caption>
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="clothing.name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Description:</th>
                <td>
                    <input type="text" name="clothing.description" id="des" size="45"/>
                </td>
            </tr>
            <tr>
                <th>picture:</th>
                <td>
                    <input type="text" name="clothing.picture" id="picture" size="15"/>
                </td>
            </tr>
            <tr>
                <th>price:</th>
                <td>
                    <input type="text" name="clothing.price" id="price" size="15"/>
                </td>
            </tr>
            <tr>
                <th>origin:</th>
                <td>
                    <input type="text" name="clothing.origin" size="15"/>
                </td>
            </tr>
            <tr>
                <th>

                </th>Select a Category:&nbsp;
                    <select name="category">
                        <c:forEach items="${listCategory}" var="category">
                            <option value="${category.id}">${category.name}</option>
                        </c:forEach>
                    </select>
                <br/><br/>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
