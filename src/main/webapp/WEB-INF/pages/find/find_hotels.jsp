<%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 22.07.2019
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page pageEncoding="UTF-8"%>
<html>
<head>
<title>Міста</title>
</head>
<body>
	<jsp:include page="../modules/_header.jsp" />
	<div style="padding-left: 15px">
		<h2>Готелі</h2>
		<form action="/find_hotel" method="post" modelAttribute="ClientPeriodDto">
			<p style="font-size: 8px; color: red;">
				*Доступні міста для <b>${ClientPeriodDto.firstName}
					${ClientPeriodDto.lastName}</b> в період з ${ClientPeriodDto.dateStart}
				по ${ClientPeriodDto.dateEnd}

			</p>
			<form:select path="hotels" name="selectedHotel">
				<c:forEach var="hotel" items="${hotels}">
					<form:option value="${hotel.id}" label="${hotel.name}" />
				</c:forEach>
			</form:select>
			<button type="submit">Відкрити</button>
			<form:hidden path="ClientPeriodDto.id" />
			<form:hidden path="ClientPeriodDto.dateStart" />
			<form:hidden path="ClientPeriodDto.dateEnd" />
			<form:hidden path="ClientPeriodDto.firstName" />
			<form:hidden path="ClientPeriodDto.lastName" />
		</form>
	</div>
</body>
</html>

