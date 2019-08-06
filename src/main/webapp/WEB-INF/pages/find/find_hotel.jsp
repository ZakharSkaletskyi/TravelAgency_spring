<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 22.07.2019
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@page pageEncoding="UTF-8" %>
<html>
<head>
    <title>${findHotelDto.name}</title>
    <jsp:include page="../modules/_header.jsp"/>
</head>
<body>
<div class="content">
    <h2>Hotel ${findHotelDto.name}</h2>


    <p>
        К-сть кімнат: <b>${findHotelDto.roomsCount}</b>
    </p>

    <p style="font-size: 12px;">
        Доступні кімнати в період <b>${findHotelDto.dateStart} </b> до <b>${findHotelDto.dateEnd}
    </b> :
        <c:forEach var="room" items="${findHotelDto.avaibleRoomsNumber}">
            <b><c:out value="№${room} "/></b>
        </c:forEach>


    </p>
    <form action="find_hotel" method="GET"
          modelAttribute="findHotelStatDto">
        <%--  edit path get method , edit button   --%>
        <p>Cтатистика</p>
        <p>
            З: <input type="date" name="start_date_hotel_stat"
                      value=<%=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime())%>>
            до: <input type="date" name="end_date_hotel_stat"
                       value=<%=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime())%>>
        </p>
        <input type="submit" name="action1" value="Отримати"/>
        <form:hidden path="findHotelDto.hotelId"/>

    </form>


    <li>Кількість клієнтів:
        ${findHotelStatDto.clientsCountsForPeriod}
    </li>

    <li>Середній час бронювання:
        ${findHotelStatDto.AverageBookTimeForPeriod}

    </li>

    <%--<li>Завантаженість кімнат:
        <ul>
            <%
                for (int i = 0; i < roomService.getRoomCount(Integer.parseInt(session.getAttribute("hotelId").toString())); i++) {
                    int[] roomsLoading = roomService.LoadingRoomsPeriod(
                            session.getAttribute("start_date_hotel_stat").toString(),
                            session.getAttribute("end_date_hotel_stat").toString(),
                            roomService.getRoomIdByNumber(i + 1,
                                    Integer.parseInt(session.getAttribute("hotelId").toString())));
            %>
            <li><%=i + 1%> кімната: <%=roomsLoading[0]%> / <%=roomsLoading[1]%>
            </li>
            <%
                }
                session.setAttribute("start_date_hotel_stat", null);
                session.setAttribute("end_date_hotel_stat", null);
            %>
        </ul>
    </li>
    </ul>

    --%>

</div>
</body>
</html>
