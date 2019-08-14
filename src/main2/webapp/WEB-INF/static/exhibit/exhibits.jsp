<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: macbookpro
  Date: 7/16/19
  Time: 9:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exhibits</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<jsp:include page="../menu.jsp"/>

<button type="button" class="btn btn-primary" style="float: right" onclick="goToStatistic()">Exhibit statistic</button>
<a href="/exhibit/add" class="btn btn-primary" style="float: right">Add new Exhibit</a>


<c:choose>
    <c:when test="${not empty exhibits}">
        <div class="list-group">
            <c:forEach items="${exhibits}" var="item">
                <a href="?id=${item.id}" class="list-group-item list-group-item-action disabled">${item.name}</a>
            </c:forEach>
        </div>
    </c:when>
    <c:otherwise>
        <h3 class="w3-wide" style="margin: 20px;">Not found any exhibit!</h3>
    </c:otherwise>
</c:choose>


</body>
<script>
    function goToStatistic() {
        window.location.href = "http://localhost:8080/exhibit/stat"
    }
</script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</html>
