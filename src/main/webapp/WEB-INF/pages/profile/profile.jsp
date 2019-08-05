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
    <title>The Sun - Profile</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/profile.css"/>
    <%--<link rel="stylesheet" href="../../../res/css/index.css"/>--%>
    <jsp:include page="../modules/_header.jsp"/>
</head>
<body>
<button class="buttonBack" onclick="goBack()">List of clients</button>
<script>
    function goBack() {
        window.history.back();
    }
</script>
<br/>
<div class="profileContent">
    <p class="infoParam">First name</p>
    <p class="info">${ProfileClientDTO.firstName}</p>
    <p class="infoParam">Last name</p>
    <p class="info">${ProfileClientDTO.lastName}</p>
    <p class="infoParam">Phone number</p>
    <p class="info">${ProfileClientDTO.phoneNumber}</p>
    <p class="infoParam">List of countries visited by the client</p>
    <div class="country">
        <c:forEach var="country" items="${ProfileClientDTO.countries}">
            <option value="${country.id}">${country.name}</option>
        </c:forEach>
    </div>

    <p class="infoParam">List of visas</p>
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
