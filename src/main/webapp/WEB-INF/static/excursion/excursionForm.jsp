<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <style>
        <%@include file="../../../resources/index.css"%>
    </style>
    <title>Museum</title>
    <link rel="stylesheet" href="../../../resources/index.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<jsp:include page="../menu.jsp"/>

<h2 style="margin: 10px">Please, enter the period you want to visit excursion in our museum.</h2>

<div style="margin: 10px">
    <label for="start">Start:</label>
    <input id="start" type="datetime-local" name="start"><br>
    <label for="end">End:</label>
    <input id="end" type="datetime-local" name="end"><br>
    <button type="button" class="button btn-btn-primary" onclick="ddd()">Submit</button>
</div>
</body>

<script>
    function ddd() {
        var start = document.getElementById("start").value;
        var end = document.getElementById("end").value;
        alert(start);
        document.location.href = "http://localhost:8080//excursion/byPeriod?start=" + start + "&end=" + end;
    }
</script>
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
