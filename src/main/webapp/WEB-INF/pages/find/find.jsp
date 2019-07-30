<%@ page import="java.util.List"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Calendar"%><%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 20.07.2019
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Знайти готель</title>
</head>
<body>
	<jsp:include page="../modules/_header.jsp" />
	<div style="padding-left: 15px">
		<h2>Знайти готель</h2>
		<form:select path="clients">
			<c:forEach var="name" items="${clients}">
				<form:option value="${name.id}"
					label="${name.firstName} ${name.lastName}" />
			</c:forEach>
		</form:select>
		
		<form action="/find" method="POST">
			<h3>Дата заїзду  edit!!!</h3>
			  <input type="date" name="dateStart"
               value=
                   <%= new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()) %>
                       min= <%= new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()) %>>

        <h3>Дата виїзду</h3>
        <input type="date" name="dateEnd"
               value="2019-07-30"
               min=<%= new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()) %>>

        <br>
        <input type="submit" value="Знайти">
        <button type="submit">Знайти</button>
		</form>
</body>
</html>
