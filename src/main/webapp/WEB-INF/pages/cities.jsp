<%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 23.07.2019
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title> Cities </title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/style.css" />
    <jsp:include page="modules/_header.jsp"/>
</head>
<body>
<div class="content">
    <h2>Cities</h2>
    <form action = "/city" method = "POST">
        <select name = "cityId">
            <c:forEach var="city" items="${cities}">
                <option value="${city.id}">${city.name}</option>
            </c:forEach>
        </select>

        <button type="submit">Відкрити</button>
    </form>
</div>
</body>
</html>
