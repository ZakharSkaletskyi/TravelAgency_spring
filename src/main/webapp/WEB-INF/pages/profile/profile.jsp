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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/profile.css"/>
    <jsp:include page="../modules/_header.jsp"/>
</head>
<body>
<button onclick="goBack()">Список користувачів</button>
<script>
    function goBack() {
        window.history.back();
    }
</script>
<br/>

<h1>Ім'я</h1>
<p>${ProfileClientDTO.firstName}</p>
<h1>Прізвище</h1>
<p>${ProfileClientDTO.lastName}</p>
<h1>Номер телефону</h1>
<p>${ProfileClientDTO.phoneNumber}</p>
<h1>Список країн,які відвідав клієнт</h1>
<div class="country">
    <c:forEach var="country" items="${ProfileClientDTO.countries}">
        <option value="${country.id}">${country.name}</option>
    </c:forEach>
</div>

<h1>Список віз</h1>
<div class="visa">
    <c:forEach var="visa" items="${ProfileClientDTO.visas}">
        <option value="${visa.id}">${visa.name}</option>
    </c:forEach>
</div>

<br/>
</body>
</html>
