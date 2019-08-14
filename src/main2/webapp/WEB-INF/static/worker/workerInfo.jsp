<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.time.format.DateTimeFormatter" %>
<head>
    <title>${(worker.getSecondName())} - info</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        <%@include file="../../../resources/index.css"%>
    </style>
</head>
<body>
<jsp:include page="../menu.jsp"/>
<div class="container">
    <div class="row no-gutter">
        <div class="col-1"></div>
        <div class="author-exhibits col-10">
            <div class="info" style="margin: 20px">
                <h5>Worker id: ${(worker.getId())}</h5>
                <h5>First name: ${(worker.getFirstName())}</h5>
                <h5>Last name: ${(worker.getSecondName())}</h5>
                <h5>Post: ${(worker.getPost().getName())}</h5>
                <br>
                <c:forEach items="${worker.getHalls()}" var="item">
                    <h5>Serves ${(item.getName())}</h5>
                </c:forEach>
                <c:forEach items="${worker.getExcursions()}" var="item">
                    <h5>Excursion: begin - ${(item.getBegin()).format( DateTimeFormatter.ofPattern("dd.MM.yyyy HH-mm"))}
                        end - ${(item.getEnd()).format( DateTimeFormatter.ofPattern("dd.MM.yyyy HH-mm"))}</h5>
                </c:forEach>
            </div>
        </div>
        <div class="buttons col-1">
            <br>
            <button type="button" class="btn btn-primary" onclick="redirectToWorkerEditForm(${worker.id})">Edit
            </button>
            <br><br>
            <button type="button" class="btn btn-primary" onclick="deleteWorker(${worker.id})">Delete this
                worker
            </button>
        </div>
    </div>

</div>
</div>
</body>
<script>
    function redirectToWorkerEditForm(id) {
        window.location.href = "http://localhost:8080/worker/edit?id=" + id;
    }

    function deleteWorker(id) {
        var isDelete = confirm("Do you really want to delete this worker?");
        if (isDelete) {
            window.location.href = "http://localhost:8080/worker/delete?id=" + id;
        }
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
