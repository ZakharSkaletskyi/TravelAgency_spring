<%--
  Created by IntelliJ IDEA.
  User: Nazar
  Date: 25.07.2019
  Time: 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8" %>
<html>
<head>
    <title>Про нас</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/index.css" />
</head>
<body>
<jsp:include page="modules/_header.jsp"/>
<div class="content">
    <h2>Про нас</h2>
    <p>На ринку уже понад <b>10</b> років.</p>
    <p><b>16</b> задоволених клієнтів</p>
    <br>

    <%--<% CountryService countryService = new CountryServiceImpl();--%>
        <%--VisaService visaService = new VisaServiceImpl();--%>

        <%--List<Country> countries = countryService.getCountryList();--%>
        <%--for (Country country : countries) {--%>
    <%--%>--%>
    <p>
        <%--<%=visaService.getCountVisaForCountry(countryService.getCountryIdByName(country.getCountryName()))--%>
        <%--%>--%>
        <%--візи видано в--%>
        <%--<%=country.getCountryName()%>--%>
    </p>
    <%--<%--%>
        <%--}--%>
    <%--%>--%>

</div>
</body>
</html>
