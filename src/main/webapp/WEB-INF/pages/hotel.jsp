<%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 23.07.2019
  Time: 8:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.sofserve.lv_427.tourfirm.model.Room" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sofserve.lv_427.tourfirm.service.RoomService" %>
<%@ page import="com.sofserve.lv_427.tourfirm.service.impl.RoomServiceImpl" %>
<%@ page import="com.sofserve.lv_427.tourfirm.service.HotelService" %>
<%@ page import="com.sofserve.lv_427.tourfirm.service.impl.HotelServiceImpl" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8" %>
<html>
<head>
    <title>
        <%=session.getAttribute("hotel")%>
    </title>
</head>
<body>
<jsp:include page="modules/_header.jsp"/>
<div style="padding-left: 15px">
    <h2>Hotel "<%=session.getAttribute("hotel")%>"
    </h2>

    <% RoomService roomService = new RoomServiceImpl();
        HotelService hotelService = new HotelServiceImpl();
    %>

    <p>К-сть кімнат: <b><%=roomService.getRoomCount(Integer.parseInt(session.getAttribute("hotelId").toString()))%></b></p>

    <% if ((session.getAttribute("start_date") == null) && (session.getAttribute("end_date") == null)) { %>
    <form action="/hotel" method="post">
        <p>Перевірити доступні кімнати</p>
        <p>З: <input type="date" name="start_date"
                     value=
                         <%= new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()) %>
                             min= <%= new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()) %>>
            до: <input type="date" name="end_date"
                       value=
                           <%= new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()) %>
                               min= <%= new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()) %>>
        </p>
        <button type="submit">Перевірити</button>
    </form>

    <% } else {%>
    <p>Доступні кімнати в період <b><%=session.getAttribute("start_date")%>
    </b>
        до <b><%=session.getAttribute("end_date")%>
        </b> :
        <%
            List<Room> rooms = roomService.getAvailableRoomsByHotel(
                    session.getAttribute("start_date").toString(),
                    session.getAttribute("end_date").toString(),
                    Integer.parseInt(session.getAttribute("hotelId").toString()));
            for (Room room : rooms) {
        %>
        <%=room.getRoomNumber()%>,
        <%
            }
        %>
    </p>


    <%}%>

    <% if ((session.getAttribute("start_date_hotel_stat") == null) && (session.getAttribute("end_date_hotel_stat") == null)) { %>
    <form action="/hotel" method="post">
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
