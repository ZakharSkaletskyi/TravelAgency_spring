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
    <title>Author information</title>
</head>
<body>
<jsp:include page="../menu.jsp"/>

<div class="container">
    <div class="row">

        <div class="col-1"></div>

        <div class="author-exhibits col-10">

            <div class="info">
                <div>Fist name: ${author.firstName}</div>
                <div>Second name: ${author.secondName}</div>
            </div>

            <h4>Author`s exhibits:</h4>
            <c:forEach items="${author.exhibits}" var="exhibit">
                <p><a href="/exhibit?id=${exhibit.id}">${exhibit.name}</a></p>
            </c:forEach>

        </div>


        <div class="buttons col-1">
            <a href="/author/edit?id=${author.id}" class="btn btn-primary">Edit</a>

            <button type="button" class="btn btn-primary" onclick="deleteAuthor(${author.id})">Delete this
                author
            </button>
        </div>

    </div>
</div>

</body>
<script>
    function deleteAuthor(id) {
        var isDelete = confirm("Do you really want to delete this author?");
        if (isDelete) {
            window.location.href = "http://localhost:8080/author/delete?id=" + id;
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
