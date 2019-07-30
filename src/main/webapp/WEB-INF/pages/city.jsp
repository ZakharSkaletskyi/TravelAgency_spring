<%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 30.07.2019
  Time: 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title> ${city.name} </title>
    <jsp:include page="modules/_header.jsp"/>
</head>
<body>
<div style="padding-left: 15px">
    <h2 style="text-align: center;margin-bottom: 0;font-size: 40px;">${city.name}</h2>
    <p style="margin: 0;
    font-size: 12px;
    text-align: center;">${city.countryName}</p>
    <h5 style="
    margin-bottom: 5px;
    margin-top: 5px;">Готелі</h5>
    <form action="/hotel" method="get">
        <select name="name" style="
    width: auto;
    height: 25px;
    border-radius: 5px;
    display: block;
    border: 1px solid #aaa;">
            <c:forEach var="hotel" items="${city.hotels}">
                <option>${hotel.name}</option>
            </c:forEach>
        </select>
        <button type="submit" style=" margin-top: 5px;
    background-color: lightgray;
    width: auto;
    height: 25px;
    border-radius: 5px;
    border: 2px solid gray;">Відкрити
        </button>
    </form>
</div>
</body>
</html>
