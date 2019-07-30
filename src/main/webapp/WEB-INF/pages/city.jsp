<%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 30.07.2019
  Time: 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title> ${city.name} </title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/style.css"/>
    <jsp:include page="modules/_header.jsp"/>
</head>
<body>
<div class="content">
    <h1>${city.name}</h1>
    <p class="description">${city.countryName}</p>
    <h2>Готелі</h2>
    <form action="${pageContext.request.contextPath}/hotel" method="POST">
        <select name="hotelId">
            <c:forEach var="hotel" items="${city.hotels}">
                <option value="${hotel.id}">${hotel.name}</option>
            </c:forEach>
        </select>
        <button type="submit">Відкрити
        </button>
    </form>
</div>
</body>
</html>
