<%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 01.08.2019
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>ERROR</title>
    <jsp:include page="modules/_header.jsp"/>
</head>
<body>
<div class="content">
    <div class="error">
        <h1 class="error-name">ERROR</h1>
        <img src="../../res/img/error.jpg" alt="" class="error-image">
        <p class="error-message">${message}</p>
    </div>
</div>
</body>
</html>
