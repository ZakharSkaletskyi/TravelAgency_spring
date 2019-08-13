<%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 25.07.2019
  Time: 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>The Sun - About</title>
    <jsp:include page="modules/_header.jsp"/>
</head>
<body>
<div class="content">
    <h1 class="header">About us</h1>
    <p>On the market for more than <b>10</b> years.</p>

    <p><b>${aboutDto.countOfClient}</b> satisfied customers</p>
    <h2>Visas</h2>
    <ul>
        <c:forEach var="visa" items="${aboutDto.visas}">
            <li><b>${visa.get(0)}</b> visas issued in <b>${visa.get(1)}</b></li>
        </c:forEach>
    </ul>
    <br>
</div>
</body>
</html>
