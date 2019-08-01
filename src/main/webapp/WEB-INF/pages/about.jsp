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
    <title>Сонечко - Про нас</title>
    <jsp:include page="modules/_header.jsp"/>
</head>
<body>
<div class="content">
    <h1 class="header">Про нас</h1>
    <p>На ринку уже понад <b>10</b> років.</p>

    <p><b>${aboutDto.countOfClient}</b> задоволених клієнтів</p>
    <h2>Візи</h2>
    <ul>
        <c:forEach var="visa" items="${aboutDto.visas}">
                <li><b>${visa.get(0)}</b> візи видано в <b>${visa.get(1)}</b> </li>
        </c:forEach>
    </ul>
    <br>
</div>
</body>
</html>
