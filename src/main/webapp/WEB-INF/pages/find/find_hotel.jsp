
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 22.07.2019
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8" %>
<html>
<head>
    <title>
        <%=session.getAttribute("hotel")%>
    </title>
</head>
<body>
<jsp:include page="../modules/_header.jsp"/>
<div style="padding-left: 15px">
    <h2>Hotel "<%=session.getAttribute("hotel")%>"
    </h2>

    <% RoomService roomService = new RoomServiceImpl();
        HotelService hotelService = new HotelServiceImpl();

        List<Room> rooms = roomService.getAvailableRoomsByHotel(
                session.getAttribute("startDate").toString(),
                session.getAttribute("endDate").toString(),
                hotelService.getHotelIdByName(session.getAttribute("hotel").toString())
        );%>
    <p>К-сть кімнат: <b><%=roomService.getRoomCount(Integer.parseInt(session.getAttribute("hotelId").toString()))%></b></p>

    <p style="font-size: 12px;">
        Доступні кімнати
        в період <b><%=session.getAttribute("startDate")%>
    </b>
        до <b><%=session.getAttribute("endDate")%>
    </b> :

        <%
            for (Room room : rooms) { %>
        <b>
            <%=room.getRoomNumber()%>,
        </b>
        <% } %>
    </p>
    <% if ((session.getAttribute("start_date_hotel_stat") == null) && (session.getAttribute("end_date_hotel_stat") == null)) { %>
    <form action="/find_hotel" method="post">
        <p>Cтатистика</p>
        <p>З: <input type="date" name="start_date_hotel_stat"
                     value=
            <%= new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()) %>>
            до: <input type="date" name="end_date_hotel_stat"
                       value=
                <%= new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()) %>></p>
        <button type="submit">Отримати</button>
    </form>

    <% } else {%>
    <p>Статистика за період <b><%=session.getAttribute("start_date_hotel_stat")%>
    </b>
        до <b><%=session.getAttribute("end_date_hotel_stat")%>
        </b>
    </p>
    <ul>
        <li>
            Кількість клієнтів: <%=hotelService.getClientCountForPeriod(
                hotelService.getHotelIdByName(session.getAttribute("hotel").toString()),
                session.getAttribute("start_date_hotel_stat").toString(),
                session.getAttribute("end_date_hotel_stat").toString()
        )%>
        </li>

        <li>
            Середній час
            бронювання: <%=hotelService.getAverageBookTime(hotelService.getHotelIdByName(session.getAttribute("hotel").toString()),
                session.getAttribute("start_date_hotel_stat").toString(),
                session.getAttribute("end_date_hotel_stat").toString())%> днів
        </li>

        <li>
            Завантаженість кімнат:
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

    <%}%>

</div>
</body>
</html>
