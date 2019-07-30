<%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 30.07.2019
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title> ${country.name} </title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/style.css" />
    <jsp:include page="modules/_header.jsp"/>
</head>
<body>
<div class="content">
    <h1>${country.name}</h1>
    <h2>Міста</h2>
    <form action = "/city" method = "POST">
        <select name = "cityId">
            <c:forEach var="city" items="${country.cities}">
                <option value="${city.id}">${city.name}</option>
            </c:forEach>
        </select>

        <button type="submit">Відкрити</button>
    </form>
</div>
</body>
</html>
