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
    <link rel="stylesheet" href="../../../res/css/index.css"/>
    <jsp:include page="../modules/_header.jsp"/>
</head>
<body>
<button class="buttonBack" onclick="goBack()">Список клієнтів</button>
<script>
    function goBack() {
        window.history.back();
    }
</script>
<br/>
    <div class="profileContent">
        <p class ="infoParam">Ім'я</p>
            <p class ="info">${ProfileClientDTO.firstName}</p>
        <p class ="infoParam">Прізвище</p>
            <p class ="info">${ProfileClientDTO.lastName}</p>
        <p class ="infoParam">Номер телефону</p>
            <p class ="info">${ProfileClientDTO.phoneNumber}</p>
        <p class ="infoParam">Список країн,які відвідав клієнт</p>
            <div class="country">
                <c:forEach var="country" items="${ProfileClientDTO.countries}">
                    <option value="${country.id}">${country.name}</option>
                </c:forEach>
            </div>

        <p class ="infoParam">Список віз</p>
            <div class="visa">
                <c:forEach var="visa" items="${ProfileClientDTO.visas}">
                    <option value="${visa.id}">${visa.name}</option>
                </c:forEach>
            </div>
        <img src="../../../res/img/alien.jpg" alt="alien" class="alien" align="right">
    </div>
<br/>
</body>
</html>
