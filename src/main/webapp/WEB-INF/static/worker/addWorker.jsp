<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>New worker</title>
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
    <form action="/worker" method="post" class="col-4" id="workerForm">
        <h1>New worker: </h1>
        <input type="text" name="firstName" class="form-control" placeholder="first Name" aria-label="First name"
               aria-describedby="basic-addon2" required pattern="^[a-zA-Z]{1,20}$">
        <br>
        <input type="text" name="secondName" class="form-control" placeholder="Second Name" aria-label="Second name"
               aria-describedby="basic-addon2" required pattern="^[a-zA-Z]{1,20}$">
        <br>
        <select name="postId" class="custom-select" id="inputGroupSelect02" required>
            <option selected value="">Input some</option>
            <c:forEach var="post" items="${posts}" varStatus="rowCounter">
                <option value="${post.getId()}">${post.getName()}</option>
            </c:forEach>
        </select>
        <br><br>
        <button type="submit" class="btn btn-primary">Add worker</button>
    </form>
    <div class="col-4"></div>
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
