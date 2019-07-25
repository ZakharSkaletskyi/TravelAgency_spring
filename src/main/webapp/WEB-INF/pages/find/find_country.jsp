<%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 22.07.2019
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="com.sofserve.lv_427.tourfirm.model.Country" %>
<%@ page import="com.sofserve.lv_427.tourfirm.service.impl.ClientServiceImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8" %>
<html>
<head>
    <title>Країни</title>
</head>
<body>
<jsp:include page="../modules/_header.jsp"/>
<div style="padding-left: 15px">
    <h2>Країни</h2>
    <form action="/find_country" method="post">
        <p style="font-size: 8px; color: red;">
            *Доступні країни для <b><%=session.getAttribute("client")%>
        </b>
        </p>

        <select name="country">
            <%
                List<Country> countries = new ClientServiceImpl().getAvailableCountries(
                        Integer.parseInt(session.getAttribute("clientId").toString()));

                for (Country country : countries) { %>
            <option><%=country.getCountryName()%>
            </option>
            <% } %>
        </select>
        <button type="submit">Знайти</button>
    </form>
</div>
</body>
</html>