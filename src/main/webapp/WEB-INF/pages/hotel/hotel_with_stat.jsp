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
    <jsp:include page="../modules/_header.jsp"/>
</head>
<body>
<div style="padding-left: 15px">
    <h2>Hotel "${hotelDto.hotelName}"</h2>
    <p>${hotelDto.countryName}, ${hotelDto.cityName}</p>

    <form action="/hotel/availability" method="get">
        <p>Перевірити доступні кімнати</p>
        <p>З: <input type="date" name="startDateAvail" value=${hotelDto.currentDate} min= ${hotelDto.currentDate}>
            до: <input type="date" name="endDateAvail" value=${hotelDto.currentDate} min= ${hotelDto.currentDate}>
        </p>
        <input type="hidden" name="hotelName" value="${hotelDto.hotelName}"/>
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
