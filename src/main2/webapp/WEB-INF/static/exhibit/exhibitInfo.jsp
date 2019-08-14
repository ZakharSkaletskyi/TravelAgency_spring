<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: macbookpro
  Date: 7/17/19
  Time: 8:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exhibit info</title>
</head>
<body>
<jsp:include page="../menu.jsp"/>


<div class="container">
    <diw class="row">
        <div class="col-1"></div>
        <div class="info col-10">
            <div class="name">Name of the exhibit is: ${exhibit.name}</div>
            <div class="material">Material is: ${exhibit.material}</div>
            <div class="technology">Create technology: ${exhibit.technology}</div>
            <div class="author">Author: <a
                    href="/author?id=${exhibit.author.id}">${exhibit.author.firstName} ${exhibit.author.secondName}</a>
            </div>
            <div class="author">Hall: <a href="/hall?id=${exhibit.hall.id}">${exhibit.hall.name}</a></div>


        </div>
        <div class="col-1">
            <a href="/exhibit/edit?id=${exhibit.id}" class="btn btn-primary">Edit</a>
            <button type="button" class="btn btn-primary" onclick="deleteExhibit(${exhibit.id})">Delete this
                exhibit
            </button>
        </div>
    </diw>
</div>

</body>
<script>
    function deleteExhibit(id) {
        var isDelete = confirm("Do you really want to delete this exhibit?");
        if (isDelete) {
            window.location.href = "http://localhost:8080/exhibit/delete?id=" + id;
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
