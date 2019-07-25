<%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 22.07.2019
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="com.sofserve.lv_427.tourfirm.service.impl.CityServiceImpl" %>
<%@ page import="com.sofserve.lv_427.tourfirm.model.Hotel" %>
<%@ page import="com.sofserve.lv_427.tourfirm.service.HotelService" %>
<%@ page import="com.sofserve.lv_427.tourfirm.service.impl.HotelServiceImpl" %>
<%@ page import="com.sofserve.lv_427.tourfirm.service.CityService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8" %>
<html>
<head>
    <title>Міста</title>
</head>
<body>
<jsp:include page="../modules/_header.jsp"/>
<div style="padding-left: 15px">
    <h2>Готелі</h2>
    <form action="/find_hotels" method="post">
        <p style="font-size: 8px; color: red;">
            *Доступні готелі для <b><%=session.getAttribute("client")%>
        </b>
            в <b><%=session.getAttribute("country")%>
        </b>,<b><%=session.getAttribute("city")%>
        </b>
            в період <b><%=session.getAttribute("startDate")%>
        </b>
            до <b><%=session.getAttribute("endDate")%>
        </b>

        </p>
        <select name="hotel">
            <%
                HotelService hotelService = new HotelServiceImpl();
                CityService cityService = new CityServiceImpl();

                List<Hotel> hotels = hotelService.getAvailableHotelsInCity(
                        cityService.getCityIdByName(
                                session.getAttribute("city").toString()),
                        session.getAttribute("startDate").toString(),
                        session.getAttribute("endDate").toString());

                for (Hotel hotel : hotels) { %>
            <option><%=hotel.getHotelName()%>
            </option>
            <% } %>
        </select>

        <button type="submit">Відкрити</button>
    </form>
</div>
</body>
</html>

