<%@ page import="com.sofserve.lv_427.tourfirm.model.Client" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sofserve.lv_427.tourfirm.service.impl.ClientServiceImpl" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %><%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 20.07.2019
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8" %>
<html>
<head>
    <title>Знайти готель</title>
</head>
<body>
<jsp:include page="../modules/_header.jsp"/>
<div style="padding-left: 15px">
    <h2>Знайти готель</h2>
    <form action="/find" method="post">
        <h3>Клієнт</h3>
        <select name="client">
            <%
                List<Client> clients = new ClientServiceImpl().getClientList();

                for (Client client : clients) { %>
            <option><%=client.getFirstName() + " " + client.getLastName()%>
            </option>
            <% } %>
        </select>

        <h3>Дата заїзду</h3>
        <input type="date" name="start_date"
               value=
                   <%= new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()) %>
                       min= <%= new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()) %>>

        <h3>Дата виїзду</h3>
        <input type="date" name="end_date"
               value="2019-07-28"
               min=<%= new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()) %>>

        <br>
        <button type="submit">Знайти</button>
    </form>
</div>
</body>
</html>
