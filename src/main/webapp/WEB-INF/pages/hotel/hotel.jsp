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
    <title>Сонечко - ${hotelDto.hotelName} </title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/hotel.css"/>
    <jsp:include page="../modules/_header.jsp"/>
</head>
<body>
<div class="content">
    <div class="flex-content hotel">
        <div class="hotel-about">
            <h1 class="header hotel-name">${hotelDto.hotelName}</h1>
            <span class="location hotel-location">${hotelDto.countryName}, ${hotelDto.cityName}</span>
            <div class="description hotel-description">
                <h2>Про готель</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Adipisci architecto at commodi delectus
                    dolorem
                    harum illum inventore molestiae numquam odio, officia possimus quasi qui quisquam vero. Incidunt
                    laborum
                    possimus quo.</p>
            </div>

            <c:if test="${hotelDto.availableRooms == null}">
                <form action="/hotel/availability" method="POST">
                    <input type="hidden" name="hotelId" value="${hotelDto.hotelId}"/>

                    <h2>Перевірити доступні кімнати</h2>
                    <div class="hotel-form">
                        <p>З: <input type="date" name="startDateAvail"
                                     value=${hotelDto.currentDate} min= ${hotelDto.currentDate} max=${hotelDto.maxDate}>
                            до: <input type="date" name="endDateAvail"
                                       value=${hotelDto.currentDate} min= ${hotelDto.currentDate}
                                       max=${hotelDto.maxDate}>
                        </p>
                        <button type="submit">Перевірити</button>
                    </div>
                </form>
            </c:if>

            <c:if test="${hotelDto.availableRooms != null}">
                <div class="hotel-availability">
                    <hr>
                    Доступні кімнати в період <b>${hotelDto.startDate}</b> до <b>${hotelDto.endDate}</b> :
                    <c:forEach var="room" items="${hotelDto.availableRooms}">
                        ${room.number},
                    </c:forEach>
                </div>
            </c:if>

            <c:if test="${hotelDto.countOfClient == null}">
                <form action="/hotel/statistic" method="POST">
                    <input type="hidden" name="hotelId" value="${hotelDto.hotelId}"/>

                    <h2>Cтатистика</h2>
                    <div class="hotel-form">
                        <p>З: <input type="date" name="startDateStat"
                                     value=${hotelDto.currentDate} min=${hotelDto.minDate} max=${hotelDto.currentDate}>
                            до: <input type="date" name="endDateStat"
                                       value=${hotelDto.currentDate} min=${hotelDto.minDate}
                                       max=${hotelDto.currentDate}>
                        </p>
                        <button type="submit">Отримати</button>
                    </div>
                </form>
            </c:if>

            <c:if test="${hotelDto.countOfClient != null}">
                <div class="hotel-statistic">
                    <hr>
                    Статистика за період <b>${hotelDto.startDate}</b> до <b>${hotelDto.endDate}</b>
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
            </c:if>
        </div>
        <img src="../../../res/img/hotel.jpg" alt="${hotelDto.hotelName}" width="500">
    </div>
</div>
</body>
</html>
