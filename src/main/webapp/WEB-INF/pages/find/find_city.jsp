<%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 22.07.2019
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="com.sofserve.lv_427.tourfirm.service.impl.CountryServiceImpl" %>
<%@ page import="com.sofserve.lv_427.tourfirm.model.City" %>
<%@ page import="com.sofserve.lv_427.tourfirm.service.impl.CityServiceImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8" %>
<html>
<head>
    <title>Міста</title>
</head>
<body>
<jsp:include page="../modules/_header.jsp"/>
<div style="padding-left: 15px">
    <h2>Міста</h2>
    <form action="/find_city" method="post">
        <p style="font-size: 8px; color: red;">
            *Доступні міста для <b><%=session.getAttribute("client")%>
        </b>
            в <b><%=session.getAttribute("country")%>
        </b>
            в період <b><%=session.getAttribute("startDate")%>
        </b>
            до <b><%=session.getAttribute("endDate")%>
        </b>

        </p>
        <select name="city">
            <%
                List<City> cities = new CityServiceImpl().getCityWithAvailableHotels
                        (session.getAttribute("startDate").toString(),
                                session.getAttribute("endDate").toString(),
                                new CountryServiceImpl().getCountryIdByName(session.getAttribute("country").toString()));
                for (City city : cities) { %>
            <option><%=city.getCityName()%>
            </option>
            <% } %>
        </select>

        <button type="submit">Знайти</button>
    </form>
</div>
</body>
</html>
