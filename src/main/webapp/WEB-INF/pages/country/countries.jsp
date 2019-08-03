<%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 23.07.2019
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Сонечко - Countries </title>
    <jsp:include page="../modules/_header.jsp"/>
</head>
<body>
<div class="content">
    <h2>Countries</h2>
    <form action = "/country" method = "GET">
        <select name="id">
            <c:forEach var="country" items="${countries}">
                <option value="${country.id}">${country.name}</option>
            </c:forEach>
        </select>

        <button type="submit">Відкрити</button>
    </form>
</div>
</body>
</html>