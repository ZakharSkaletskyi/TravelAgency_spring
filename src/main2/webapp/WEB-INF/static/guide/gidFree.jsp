<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Workers</title>
    <style>
        <%@include file="../../../resources/index.css"%>
    </style>
</head>
<body>
<jsp:include page="../menu.jsp"/>
<div class="row no-gutter">
    <div class="col-md-12">
        <c:choose>
            <c:when test="${not empty guides}">
                <div class="list-group">
                    <c:forEach items="${guides}" var="item">
                        <a href="http://localhost:8080/worker?id=${item.id}"
                           class="list-group-item list-group-item-action disabled">${item.firstName} ${item.secondName}
                        </a>
                    </c:forEach>
                </div>
            </c:when>
            <c:otherwise>
                <h3 class="w3-wide" style="margin: 20px;">Not found any guide!</h3>
            </c:otherwise>
        </c:choose>
    </div>
</div>
</body>
<script>
    function redirect() {
        document.location.href = "http://localhost:8080/worker/guides/free";
    }
    function redirectStat() {
        document.location.href = "http://localhost:8080/worker/guides/stat";
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
