<%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 23.07.2019
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="com.sofserve.lv_427.tourfirm.service.CountryService" %>
<%@ page import="com.sofserve.lv_427.tourfirm.service.impl.CountryServiceImpl" %>
<%@ page import="com.sofserve.lv_427.tourfirm.model.Country" %>
<%@ page import="com.sofserve.lv_427.tourfirm.service.CityService" %>
<%@ page import="com.sofserve.lv_427.tourfirm.service.impl.CityServiceImpl" %>
<%@ page import="com.sofserve.lv_427.tourfirm.model.City" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8" %>
<html>
<head>
    <title>Міста</title>
</head>
<body>
<jsp:include page="modules/_header.jsp"/>
<div style="padding-left: 15px">
    <h2>Міста</h2>
    <form action="/cities" method="post">
        <select name="hotel">
            <%
                CityService cityService = new CityServiceImpl();

                List<City> cities = cityService.getCityList();

                for (City city : cities) { %>
            <option><%=city.getCityName()%>
            </option>
            <% } %>
        </select>
    </form>
</div>
</body>
</html>
