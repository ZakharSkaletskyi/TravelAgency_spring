<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: macbookpro
  Date: 7/28/19
  Time: 6:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit exhibit</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        <%@include file="../../../resources/index.css"%>
    </style>
</head>
<body>
<jsp:include page="../menu.jsp"/>

<div class="row">
    <div class="col-4"></div>
    <form action="/exhibit/update" method="post" class="exhibitForm col-4">
        <input type="hidden" name="id" value="${exhibit.id}">

        Name: <input type="text" name="name" class="form-control" placeholder="Name" aria-label="Name"
                     aria-describedby="basic-addon2" value="${exhibit.name}" required pattern="^[a-zA-Z]{1,30}$">
        <br>
        Material: <input type="text" name="material" class="form-control" placeholder="Material" aria-label="Material"
                         aria-describedby="basic-addon2" value="${exhibit.material}" required
                         pattern="^[a-zA-Z]{1,30}$">
        <br>

        Technology: <input type="text" name="technology" class="form-control" placeholder="Technology"
                           aria-label="Technology"
                           aria-describedby="basic-addon2" value="${exhibit.technology}" required
                           pattern="^[a-zA-Z]{1,30}$">
        <br>

        Author: <select name="authorId" class="custom-select" required>
        <c:forEach var="author" items="${authors}">
            <option
                    <c:if test="${author.id == exhibit.author.id}">selected</c:if>
                    value="${author.id}">${author.firstName} ${author.secondName}
            </option>
        </c:forEach>
    </select>
        <br><br>
        Hall: <select name="hallId" class="custom-select" required>
        <c:forEach var="hall" items="${halls}">
            <option
                    <c:if test="${hall.id == exhibit.hall.id}">selected</c:if>
                    value="${hall.id}">${hall.name}
            </option>
        </c:forEach>
    </select>
        <br><br>
        <input type="submit" class="btn btn-primary" value="Save"/>
    </form>
</div>
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
