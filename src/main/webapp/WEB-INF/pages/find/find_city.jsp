<%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 22.07.2019
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@page pageEncoding="UTF-8"%>
<html>
<head>
    <title>Міста</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/index.css"/>
</head>
<body>
<jsp:include page="../modules/_header.jsp"/>
<div class="content">
    <h2>Міста</h2>
		<form action="/find_hotels" method="POST" modelAttribute="ClientPeriodDto">
			<p style="font-size: 8px; color: red;">
				*Доступні міста для <b>${ClientPeriodDto.firstName}
					${ClientPeriodDto.lastName}</b> в період з ${ClientPeriodDto.dateStart}
				по ${ClientPeriodDto.dateEnd}
			</p>
			<form:select path="cities" name="selectedCity">
				<c:forEach var="city" items="${cities}">
					<form:option value="${city.id}" label="${city.name}" />
				</c:forEach>
			</form:select>

			<button type="submit">Знайти</button>
			<form:hidden path="ClientPeriodDto.id" />
			<form:hidden path="ClientPeriodDto.dateStart" />
			<form:hidden path="ClientPeriodDto.dateEnd" />
			<form:hidden path="ClientPeriodDto.firstName" />
			<form:hidden path="ClientPeriodDto.lastName" />
		</form>
	</div>
</body>
</html>
