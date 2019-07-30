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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/style.css" />
    <jsp:include page="../modules/_header.jsp"/>
</head>
<body>
<div class = "content">
    <h1>Hotel "${hotelDto.hotelName}"</h1>
    <p class="description">${hotelDto.countryName}, ${hotelDto.cityName}</p>

    <form action="/hotel/availability" method="get">
        <p>Перевірити доступні кімнати</p>
        <p>З: <input type="date" name="startDateAvail" value=${hotelDto.currentDate} min= ${hotelDto.currentDate}>
            до: <input type="date" name="endDateAvail" value=${hotelDto.currentDate} min= ${hotelDto.currentDate}>
        </p>
        <input type="hidden" name="hotelName" value="${hotelDto.hotelName}"/>
        <button type="submit">Перевірити</button>
    </form>

    <form action="/hotel/stat" method="get">
        <p>Cтатистика</p>
        <p>З: <input type="date" name="startDateStat" value= ${hotelDto.currentDate}>
            до: <input type="date" name="endDateStat" value= ${hotelDto.currentDate}>
        </p>
        <input type="hidden" name="hotelName" value="${hotelDto.hotelName}"/>
        <button type="submit">Отримати</button>
    </form>
</div>
</body>
</html>
