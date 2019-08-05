<%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 22.07.2019
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@page pageEncoding="UTF-8"%>
<html>
<head>
<title>Країни</title>
</head>
<body>
	<jsp:include page="../modules/_header.jsp" />
	<div style="padding-left: 15px">
		<h2>Країни</h2>
		<form action="/find_city" method="POST" modelAttribute="ClientPeriodDto">
			<p style="font-size: 8px; color: red;">
				*Доступні країни для <b>${ClientPeriodDto.firstName} ${ClientPeriodDto.lastName}  </b>
				<%--*Доступні країни для ${clientWithPeriod.firstName} ${clientWithPeriod.lastName}  </b>--%>
			</p>
			<form:select path="countries" name="selectedCountry">
				<c:forEach var="country" items="${countries}">
					<form:option value="${country.id}"
						label="${country.name}" />
				</c:forEach>
			</form:select>
			<button type="submit">Знайти</button>
			<form:hidden path="ClientPeriodDto.id"  />
			<form:hidden path="ClientPeriodDto.dateStart" />
			<form:hidden path="ClientPeriodDto.dateEnd"  />
			<form:hidden path="ClientPeriodDto.firstName"  />
			<form:hidden path="ClientPeriodDto.lastName"  />
		</form>
	</div>
</body>
</html>