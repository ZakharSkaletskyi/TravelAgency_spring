<%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 30.07.2019
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title> ${country.name} </title>
    <jsp:include page="modules/_header.jsp"/>
</head>
<body>
<div style="padding-left: 15px">
    <h2>${country.name}</h2>
    <h3>Міста</h3>
    <form action = "/city" method = "GET">
        <select name = "name">
            <c:forEach var="city" items="${country.cities}">
                <option>${city.name}</option>
            </c:forEach>
        </select>

        <button type="submit">Відкрити</button>
    </form>
</div>
</body>
</html>
