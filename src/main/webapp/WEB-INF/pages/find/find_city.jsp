<%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 22.07.2019
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>

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
    <form action="/find_city" method="get">
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
      
        <form action="/find_city" method="GET">
			<p style="font-size: 8px; color: red;">
				*Доступні міста ля обраного клієнта в період з ${dateStart} по ${dateEnd} }  
			</p>
			<form:select path="countries" name="selectedCity">
				<c:forEach var="city" items="${cities}">
					<form:option value="${city.id}"
						label="${city.name}" />
				</c:forEach>
			</form:select>

        <button type="submit">Знайти</button>
    </form>
</div>
</body>
</html>
