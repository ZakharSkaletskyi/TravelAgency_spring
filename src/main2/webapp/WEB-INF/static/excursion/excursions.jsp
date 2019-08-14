<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Katay
  Date: 20.07.2019
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="../menu.jsp"/>

<a href="/excursion/add" class="btn btn-primary" style="float: right">Add new excursion</a>

<a href="/excursion/byPeriodForm" class="btn btn-primary" style="float: right">Find by period</a>

<div class="w3-container w3-content w3-center w3-padding-64 w3-card-8"
     style="max-width: 800px; margin: 30px">
    <h2 class="w3-wide">Excursions in given time period:</h2>
    <c:choose>
        <c:when test="${not empty excursions}">
            <div class="list-group">
                <div class="col-6">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th scope="col">Id</th>
                            <th scope="col">Begin</th>
                            <th scope="col">End</th>
                            <th scope="col">Price, UAH</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${excursions}" var="item">
                            <tr>
                                <th scope="row">${item.id}</th>
                                <td>${item.begin}</td>
                                <td>${item.end}</td>
                                <td>${item.price}</td>
                                <td>
                                    <form action="/excursion/delete" style="margin-block-end: 0em;" method="post">
                                        <input type="hidden" name="id" value="${item.id}">
                                        <input type="submit" class="btn btn-outline-danger" value="Delete"/>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </c:when>
        <c:otherwise>
            <h3 class="w3-wide">not found!</h3>
        </c:otherwise>
    </c:choose>
</div>

</body>
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
