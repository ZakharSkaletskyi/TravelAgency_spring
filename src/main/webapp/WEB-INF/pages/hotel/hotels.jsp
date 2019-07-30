<%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 29.07.2019
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title> Hotels </title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/style.css" />
    <jsp:include page="../modules/_header.jsp"/>
</head>
<body>
<div class="content">
    <h2>Hotels</h2>
    <form action="/hotel" method="get">
        <select name="name">
            <c:forEach var="hotel" items="${hotels}">
                <option>${hotel.name}</option>
            </c:forEach>
        </select>
        <button type="submit">Відкрити
        </button>
    </form>
</div>
</body>
</html>
