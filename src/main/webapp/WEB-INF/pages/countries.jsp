<%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 23.07.2019
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="com.sofserve.lv_427.tourfirm.service.CountryService" %>
<%@ page import="com.sofserve.lv_427.tourfirm.service.impl.CountryServiceImpl" %>
<%@ page import="com.sofserve.lv_427.tourfirm.model.Country" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8" %>
<html>
<head>
    <title>Країни</title>
</head>
<body>
<jsp:include page="modules/_header.jsp"/>
<div style="padding-left: 15px">
    <h2>Країни</h2>
    <form action="/countries" method="post">
        <select name="hotel">
            <%
                CountryService countryService = new CountryServiceImpl();

                List<Country> countries = countryService.getCountryList();

                for (Country country : countries) { %>
            <option><%=country.getCountryName()%>
            </option>
            <% } %>
        </select>
    </form>
</div>
</body>
</html>
