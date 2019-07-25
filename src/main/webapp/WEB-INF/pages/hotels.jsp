<%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 23.07.2019
  Time: 8:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="com.sofserve.lv_427.tourfirm.model.Hotel" %>
<%@ page import="com.sofserve.lv_427.tourfirm.service.HotelService" %>
<%@ page import="com.sofserve.lv_427.tourfirm.service.impl.HotelServiceImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8" %>
<html>
<head>
    <title>Готелі</title>
</head>
<body>
<jsp:include page="modules/_header.jsp"/>
<div style="padding-left: 15px">
    <h2>Готелі</h2>
    <form action="/hotels" method="post">
        <select name="hotel">
            <%
                HotelService hotelService = new HotelServiceImpl();

                List<Hotel> hotels = hotelService.getAllHotels();

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
