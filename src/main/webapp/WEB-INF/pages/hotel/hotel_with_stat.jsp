<%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 29.07.2019
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title> ${hotelDto.hotelName} </title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/style.css"/>
    <jsp:include page="../modules/_header.jsp"/>
</head>
<body>
<div class="content">
    <h1>Hotel "${hotelDto.hotelName}"</h1>
    <p class="description">${hotelDto.countryName}, ${hotelDto.cityName}</p>

    <form action="/hotel/availability" method="POST">
        <input type="hidden" name="hotelId" value="${hotelDto.hotelId}"/>

        <p>Перевірити доступні кімнати</p>
        <p>З: <input type="date" name="startDateAvail" value=${hotelDto.currentDate} min= ${hotelDto.currentDate}>
            до: <input type="date" name="endDateAvail" value=${hotelDto.currentDate} min= ${hotelDto.currentDate}>
        </p>
        <button type="submit">Перевірити</button>
    </form>

    <p>Статистика за період <b>${hotelDto.startDate}</b> до <b>${hotelDto.endDate}</b></p>
    <ul>
        <li> Кількість клієнтів: ${hotelDto.countOfClient} </li>
        <li> Середній час бронювання: ${hotelDto.averageBookTime} днів</li>
        <li>
            Завантаженість кімнат:
            <ul>
                <c:forEach var="roomLoad" items="${hotelDto.roomLoading}">
                    <li>${roomLoad[0]} / ${roomLoad[1]} </li>
                </c:forEach>
            </ul>
        </li>
    </ul>
</div>
</body>
</html>
