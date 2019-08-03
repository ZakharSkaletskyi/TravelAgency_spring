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
    <title>Сонечко - ${city.name} </title>
    <jsp:include page="../modules/_header.jsp"/>
</head>
<body>
<div class="content">
    <div class="flex-content city">
        <div class="city-about">
            <h1 class="header">${city.name}</h1>
            <span class="location hotel-location">
                <a href="/country?id=${city.country.id}">${city.country.name}</a>
            </span>
            <div class="description">
                <h2>Про місто</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Adipisci architecto at commodi delectus
                    dolorem
                    harum illum inventore molestiae numquam odio, officia possimus quasi qui quisquam vero. Incidunt
                    laborum
                    possimus quo.</p>
            </div>

            <h2>Готелі</h2>
            <form action="${pageContext.request.contextPath}/hotel" method="GET">
                <select name="id">
                    <c:forEach var="hotel" items="${city.hotels}">
                        <option value="${hotel.id}">${hotel.name}</option>
                    </c:forEach>
                </select>
                <button type="submit">Відкрити</button>
            </form>
        </div>
        <img src="../../../res/img/city.jpg" alt="" width="500">
    </div>
</div>
</body>
</html>
