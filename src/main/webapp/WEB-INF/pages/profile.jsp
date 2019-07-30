<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 30.07.2019
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Профіль</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/style.css"/>
    <jsp:include page="modules/_header.jsp"/>
</head>
<body>
<h2>Статистика користувача</h2>
<p>Бла бла бла<b>1,000,000</b> років.</p>
<p><b>бла</b> блаблабла</p>

<form action="/profile" method="POST">
    <select name="clientId">
        <c:forEach var="client" items="${clients}">
            <option value="${client.id}">${client.firstName}</option>
        </c:forEach>
    </select>
    <button type="submit">Відкрити</button>
</form>

<br/>
</body>
</html>
