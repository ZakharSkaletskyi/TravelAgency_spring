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
    <title>Сонечко - ${country.name} </title>
    <jsp:include page="../modules/_header.jsp"/>
</head>
<body>
<div class="content">
    <div class="flex-content">
        <div class="country-about">
            <h1 class="header">${country.name}</h1>
            <div class="description">
                <h2>Про країну</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Adipisci architecto at commodi delectus
                    dolorem
                    harum illum inventore molestiae numquam odio, officia possimus quasi qui quisquam vero. Incidunt
                    laborum
                    possimus quo.</p>
            </div>
            <h2>Міста</h2>
            <form action="/city" method="POST">
                <select name="cityId">
                    <c:forEach var="city" items="${country.cities}">
                        <option value="${city.id}">${city.name}</option>
                    </c:forEach>
                </select>

                <button type="submit">Відкрити</button>
            </form>
        </div>
        <img src="../../../res/img/country.jpg" alt="" width="500">
    </div>
</div>
</body>
</html>
